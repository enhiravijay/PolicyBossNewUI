package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentLogger {
	
	 private static ExtentReports extent;
	    private static ExtentTest test;

	    public static void initialize() {
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	    }

	    public static void createTest(String testName) {
	        test = extent.createTest(testName);
	    }

	    public static void logInfo(String message) {
	        test.info(message);
	    }

	    public static void logPass(String message) {
	        test.pass(message);
	    }

	    public static void logFail(String message) {
	        test.fail(message);
	    }

	    public static void flush() {
	        extent.flush();
	    }

}
