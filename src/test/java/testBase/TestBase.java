package testBase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Config;

public class TestBase {
	
	public WebDriver driver;
	Properties prop;
	
	public WebDriver openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Users//IT//Documents//chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("into open browser");
		prop=utility.Config.loadPropertyFile();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("liveurl"));
		return driver;
		
	}
	
	public Properties getprop() throws Exception {
		Config con = new Config();
		prop = Config.loadPropertyFile();
		return prop;
		
		
	}
	
//	public String xpathxpression(String value) {
//		
//		String xpathTemplate = "//div[@id='WithoutCarNumberPopup']//label//span[text()=  '%s']";
//		String textValue = "your-text-value";
//
//		String xpathExpression = String.format(xpathTemplate, value);
//	}

}
