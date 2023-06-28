package testCase;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import basePage.BasePage;
import pages.Car_Ins_InputPage;
import testBase.TestBase;
import utility.Constant;
import utility.ExtentLogger;
import utility.ScreenshotUtils;



public class TestCase001 extends TestBase {
	
	public Properties prop;
	public BasePage basepage;
//	public BasePage basepage;
	public String sName="Sheet1";
	public String sName1="Sheet2";
	public String sName2="Sheet3";
	public ExtentLogger extent;
	public static ExtentSparkReporter extentreport;
	public ExtentLogger test;
	
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("Into Before Suiste");
		
		prop = getprop();
	}
	
	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.println("Into Before Test");
		extentreport = new ExtentSparkReporter(Constant.Path_ExtentReport);
		//extent.loadConfig(new File("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\src\\main\\resources\\configfile\\extent-config.xml"));
		extentreport.loadXMLConfig(new File(Constant.Path_ExtentReport_Config));
		ExtentLogger.initialize();
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		prop = getprop();
		System.out.println("Into Before Method");
		
	}

	@Test
	public void TestCs001() throws Exception {
		System.out.println("into test case 001");
		ExtentLogger.createTest("Test Case 001");
		openBrowser();
		ExtentLogger.logInfo("Successfully opened browser");
		Car_Ins_InputPage carinput = new Car_Ins_InputPage(driver);
		carinput.selectRenewsec();
		carinput.selectMake(sName);
		carinput.selectFuel(sName);
		carinput.selectVariant(sName);
	}
	
	@Test
	public void TestCs002() throws Exception {
		System.out.println("into test case 001");
		ExtentLogger.createTest("Test Case 002");
		openBrowser();
		ExtentLogger.logInfo("Successfully opened browser");
		Car_Ins_InputPage carinput = new Car_Ins_InputPage(driver);
		carinput.selectRenewsec();
		carinput.selectMake(sName1);
		carinput.selectFuel(sName1);
		carinput.selectVariant(sName1);
	}
	
	@Test
	public void TestCs003() throws Exception {
		System.out.println("into test case 001");
		ExtentLogger.createTest("Test Case 003");
		openBrowser();
		ExtentLogger.logInfo("Successfully opened browser");
		Car_Ins_InputPage carinput = new Car_Ins_InputPage(driver);
		carinput.selectRenewsec();
		carinput.selectMake(sName2);
		carinput.selectFuel(sName2);
		carinput.selectVariant(sName2);
	}
	
	@AfterMethod
	 public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
        	try{
        		ExtentLogger.logFail("Test Case Failed is "+result.getName());
        		ExtentLogger.logFail("Test Case Failed is "+result.getThrowable());
        		ScreenshotUtils.getScreenshot(driver, result.getName());
				
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}  
        }
    }
	
	@AfterTest
	 public void teardown() {
		System.out.println("into after test");
        ExtentLogger.flush();
    }
}
