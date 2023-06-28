package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;
import utility.ExcelUtils;
import utility.ExtentLogger;

public class Car_Ins_InputPage extends BasePage {
	
		public Car_Ins_InputPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='banner-detail-area']//img[@title='Car Insurance']")
	WebElement selcarInsurance;
	
	
	@FindBy(xpath = "//form[@class='validate-form']//div[@class='link-box']//a[contains(text(), 'Continue without car number?')]")
	WebElement RenewSection;
	
	@FindBy(xpath = "//input[@id='MakeModelVarientFuel']")
	WebElement MakeModelVarientFuelFld;
	
//	@FindBy(how = How.XPATH, using = xpathExpression)
//	@CacheLookup
//	WebElement MakeModel;
	
	
	

//	 @FindBy(how = How.XPATH, using = "//input[@id='%s']")
//	    private WebElement dynamicElement;
//	//div[@id='WithoutCarNumberPopup']//label//span[text()='HONDA, CITY']
	
	
	public void selectRenewsec() {
		try {
			selcarInsurance.click();
			RenewSection.click();
			} catch (NoSuchElementException  e) {
			// TODO: handle exception
			System.out.println("Incorrect Element");
		}
		
	}
	
	
	public void selectMake(String sName) throws IOException {
		ExtentLogger.logInfo("Trying to select make model");		
		jsExecute(MakeModelVarientFuelFld);
		WebElement ByMake = driver.findElement(By.xpath("//div[@id='WithoutCarNumberPopup']//label//span[text()= 'MARUTI, WAGON R']"));
		jsExecute(ByMake);
		ExtentLogger.logInfo("Make Model Selected Successfully");
				
	}
	
	public void selectFuel(String sname) throws Exception {
		//ExcelUtils.getMapData(keyenter);
		//String valueenter = ExcelUtils.getMapData(fueltype);
		//System.out.println("i'm trying to get fuel value issue"+fname);
		WebElement ByFuel = driver.findElement(By.xpath("//div[@id='WithoutCarNumberPopupFuel']//span[text()=\""+ExcelUtils.getMapData("FuelType",sname)+"\"]"));
		jsExecute(ByFuel);
				
	}
	
	public void selectVariant(String sname) throws Exception {
		
		WebElement ByVariant = driver.findElement(By.xpath("//div[@class='select-variant-listing-area']//span[text()=\""+ExcelUtils.getMapData("Variant",sname)+"\"]"));
		jsExecute(ByVariant);
				
	}
	
	
	
	

}
