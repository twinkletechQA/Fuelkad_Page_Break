package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerFuelPrice extends Base {
	
    String MerchantBaseUrl = prop.getProperty("merUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Set Fuel Price']")
	private WebElement SetFuelPriceMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Fuel Price']")
	private WebElement FuelPriceMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="(//button[@type='reset'])[1]")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Fuel Price History']")
	private WebElement FuelPriceHistoryTitle;
	
	@FindBy(xpath ="(//button[@type='reset'])[2]")
	private WebElement ViewHistoryOFFuelPriceBtn;
	
	public MerFuelPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		SetFuelPriceMenu.click();
		FuelPriceMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "SetFuelPriceByMerchant.do");
	}
	
	public void clockOnSaveBtn() {
		saveBtn.click();
	}
	
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnHistyoryOfFuelPrice() {
		ViewHistoryOFFuelPriceBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "DownloadFuelAmountHistory.do");		
		Assert.assertEquals(FuelPriceHistoryTitle.getText(), "Fuel Price History");
		clickCSV_Download();
		clickPDF_Download();
		clickOnCancelBtn();
	}

}
