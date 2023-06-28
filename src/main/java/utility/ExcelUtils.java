package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils {

	// private static XSSFSheet ExcelWSheet;
	private static HSSFSheet ExcelWSheet;
	// private static XSSFWorkbook ExcelWBook;
	private static HSSFWorkbook ExcelWBook;
	// private static XSSFCell Cell;
	public static HSSFCell valueCell;
	public static HSSFCell keyCell;
	// private static XSSFRow Row;
	private static HSSFRow Row;
	public static Properties prop;
	public static HSSFCell lastCell;
	public static int lastrow;

//		public static Map<String, Map<String, String>> setMapData(String Sname) throws IOException {
//			//"C://Users//Vijay//git//New_Test//New_Car_insurance//New_Insurance//src//main//resources//data//TestData.xls"
//			//"D://Desk8//selenium//eclipse-workspace//New_Insurance//src//main//resources//data//TestData.xls"
//			String path = "C://Users//IT//eclipse-workspace//policyboss-carinsurance//src//main//resources//data//TestData.xls";
//			FileInputStream ExcelFile = new FileInputStream(path);
//			ExcelWBook = new HSSFWorkbook(ExcelFile);
//			//ExcelWSheet = ExcelWBook.getSheetAt(0);
//			ExcelWSheet = ExcelWBook.getSheet(Sname);
//			//int lastRow = ExcelWSheet.getLastRowNum();
//			int lastarow = getLastRow(Sname);
//			System.out.println("this is last row"+lastarow);
//			System.out.println("sheet name entered is "+Sname);
//			//Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
//			Map<String, Map<String, String>> excelFileMap = new HashMap<>();
//			
//
//			for (int i = 0; i < lastarow; i++) {
//			    Row = ExcelWSheet.getRow(i);
//			    valueCell = Row.getCell(1);
//			    keyCell = Row.getCell(0);
//			    String value = null;
//			    String key = null;
//			    CellType ctype = valueCell.getCellType();
//
//			    if (valueCell.getCellType() == CellType.STRING) {
//			        value = valueCell.getStringCellValue().trim();
//			        System.out.println("value of cell is " + value);
//			    }
//
//			    if (keyCell.getCellType() == CellType.STRING) {
//			        key = keyCell.getStringCellValue().trim();
//			        System.out.println("key of cell is " + key);
//			    }
//
//			    Map<String, String> dataMap = new HashMap<>();
//			    dataMap.put(key, value);
//			    excelFileMap.put("DataSheet", dataMap);
//			}
//
//			return excelFileMap;
//
//
//		}
//	

	public static int getLastRow(String Sname) throws IOException {
		String path = "C://Users//IT//eclipse-workspace//policyboss-carinsurance//src//main//resources//data//TestData.xls";
		FileInputStream ExcelFile = new FileInputStream(path);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		// ExcelWSheet = ExcelWBook.getSheetAt(0);
		ExcelWSheet = ExcelWBook.getSheet(Sname);
		lastrow = 0;
		System.out.println("inside get last row");
		int lrow = ExcelWSheet.getLastRowNum();
		for (int i = 0; i <= lrow; i++) {
			String actRowValue = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
			if (actRowValue.equalsIgnoreCase("LastRow")) {
				break;
			} else {
				lastrow++;
			}
		}
		return lastrow;

	}

	public static Map<String, String> readExcelData(String sheetName) throws IOException {
		Map<String, String> dataMap = new HashMap<>();

		FileInputStream file = new FileInputStream(
				"C://Users//IT//eclipse-workspace//policyboss-carinsurance//src//main//resources//data//TestData.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("sheet name in readexcel method para is " + sheetName);

		int rowCount = sheet.getLastRowNum() + 1;
		for (int i = 0; i < rowCount; i++) {
			HSSFRow row = sheet.getRow(i);
			HSSFCell keyCell = row.getCell(0);
			HSSFCell valueCell = row.getCell(1);

			if (keyCell == null) {
				return null; // Return null if the cell is empty
			}

			if (valueCell == null) {
				return null; // Return null if the cell is empty
			}

			keyCell.setCellType(CellType.STRING);
			valueCell.setCellType(CellType.STRING);
			String key = keyCell.getStringCellValue();
			// System.out.println("value of key in readxl is "+key);
			String value = valueCell.getStringCellValue();
			// System.out.println("value of keyvalue in readxl is "+value);

			dataMap.put(key, value);
//	            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
//				    String key2 = entry.getKey();
//				    String value2 = entry.getValue();
//				    System.out.println("Key2: " + key2 + ", Value2: " + value2);
//				}

//	            System.out.println("value of datamap key is "+dataMap.get("FuelType"));
//	            System.out.println("sheet name in readexcel method para is " + sheetName);
//	            System.out.println("rowCount: " + rowCount);
//	            System.out.println("key: " + key);
			System.out.println("value: " + value);

		}

		workbook.close();
		file.close();

		return dataMap;
	}

//	
//		public static String getMapData(String key,String sName) throws IOException {
//			Map<String, String> m = setMapData(sName).get("DataSheet");
//			String value = m.get(key);
//			return value;
//		}

	public static String getMapData(String keyname,String sheetname) throws Exception {
		Map<String, String> dataMap = readExcelData(sheetname);
		String value = dataMap.get(keyname);
		
		return value;

	}

	public static void writeToExcel(Map<Integer, Map<Integer, List<String>>> qmap, String sName) throws Exception {
		String path = "C://Users//IT//eclipse-workspace//policyboss-carinsurance//src//main//resources//data//TestData.xls";
		File file = new File(path);
		FileInputStream ExcelFile = new FileInputStream(file);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sName);
		int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
		// int rowCount = 18;
		// Get the first row from the sheet
		HSSFRow row = ExcelWSheet.getRow(0);
		// Create a new row and append it at last of sheet
		HSSFRow newRow = ExcelWSheet.createRow(rowCount + 1);
		// Create a loop over the cell of newly created Row
		int qmapsize = qmap.size();
		// ExcelWSheet.shiftRows(18, 30,-1);
		// ExcelWSheet.
		int lasttrow = getLastRow(sName);
		for (int x = lasttrow + 1; x <= rowCount; x++) {
			HSSFRow removingRow = ExcelWSheet.getRow(x);
			if (removingRow != null) {
				ExcelWSheet.removeRow(removingRow);
			}

		}

		System.out.println("qmap size is " + qmapsize);
		for (int j = 0; j < qmapsize; j++) {
			// Fill data in row
			qmapsize = qmap.size();
			int createRowv = lasttrow + 1;
			for (Integer insdetails : qmap.keySet()) {
				if (!(insdetails == qmapsize - 1)) {
					Map<Integer, List<String>> qmapvalue = qmap.get(insdetails);
					List<String> qstringvalue = qmapvalue.get(insdetails);
					System.out.println("Key = " + insdetails + ", Value = " + "Insurance Co : " + qstringvalue.get(0)
							+ " Premium value is :  " + qstringvalue.get(1) + " No of Insurer is: "
							+ qstringvalue.get(2));
					// Create a new row and append it at last of sheet
					HSSFRow newRow1 = ExcelWSheet.createRow(createRowv);
					HSSFCell cell = newRow1.createCell(0);
					cell.setCellValue("Insurance Co : " + qstringvalue.get(0) + ":  " + "Premium value is "
							+ qstringvalue.get(1) + ":  " + qstringvalue.get(2));
					j++;
					rowCount++;
					createRowv++;
				} else {
					Map<Integer, List<String>> qmapvalue = qmap.get(insdetails);
					List<String> qstringvalue = qmapvalue.get(insdetails);
					// System.out.println("Key = " + insdetails + ", Value = " + "Insurance Co :
					// "+qstringvalue.get(0)+": "+qstringvalue.get(1)+": "+"Premium value is
					// "+qstringvalue.get(2));
					System.out.println("Key = " + insdetails + "  Crn value is :  " + qstringvalue.get(0)
							+ "  Make Model is " + qstringvalue.get(1) + " Rto is  :" + qstringvalue.get(2)
							+ "  No of insurer is :  " + qstringvalue.get(3));
					// Create a new row and append it at last of sheet
					HSSFRow newRow1 = ExcelWSheet.createRow(createRowv);
					HSSFCell cell = newRow1.createCell(0);
					cell.setCellValue("Crn value is :" + qstringvalue.get(0) + " Make Model is " + qstringvalue.get(1)
							+ "  Rto is  :" + qstringvalue.get(2) + "  No of insurer is :" + qstringvalue.get(3));
				}

			}

		}

		// Close input stream
		ExcelFile.close();
		// Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		// write data in the excel file
		ExcelWBook.write(outputStream);
		// close output stream
		outputStream.close();
	}

}
