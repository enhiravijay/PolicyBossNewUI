package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import basePage.BasePage;

public class ScreenshotUtils extends BasePage {
	
	public ScreenshotUtils(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		// below line is just to append the date format with the screenshot name to
		// avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		//String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+ ".png";
		//File failureImageFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+failureImageFileName);
		String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return destination;
	}
	
	

//	public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + screenshotName + dateName
//    				+ ".png";
//    		File finalDestination = new File(destination);
//    		FileUtils.copyFile(source, finalDestination);
//            FileHandler.copy(source, new File("./screenshots/" + screenshotName + ".png"));
//            System.out.println("Screenshot captured: " + screenshotName);
//        } catch (IOException e) {
//            System.out.println("Exception while taking screenshot: " + e.getMessage());
//        }
//    }

}
