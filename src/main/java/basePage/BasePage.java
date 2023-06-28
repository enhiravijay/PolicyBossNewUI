package basePage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Config;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	private FluentWait<WebDriver> waitFlue;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
	}

	
	public Properties getprop() throws Exception {
		Config con = new Config();
		prop = Config.loadPropertyFile();
		return prop;

	}
	
	public static void waitHandle(WebDriver driver,WebElement ele,int timeout) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		}
	
	
	public static void sendText(WebElement ele,String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	
	public  boolean isElementClickable(WebElement element) {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        return element.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}	
	
	public void jsExecute(WebElement element) {
		waitHandle(driver, element, 20);
		//WebElement  element=driver.findElement(By.xpath"");  
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", element);
	}
	
	
	
}
