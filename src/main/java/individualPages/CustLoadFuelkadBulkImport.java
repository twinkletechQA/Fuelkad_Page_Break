package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustLoadFuelkadBulkImport extends Base{
	
	@FindBy(xpath = "//a[normalize-space(text())='Topup And Load']")
    private WebElement TopupAndLoadMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Load Fuelcard (bulk import)']")
	private WebElement LoadFuelcardBulkImportMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Download Load FuelKad (bulk import)']")
	private WebElement DownloadLoadFuelcardBulkImport;
	
	@FindBy(id = "submit")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement CancelBtn;
	
	@FindBy(id = "flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id = "search")
	private WebElement searchFilterBtn;
	
	@FindBy(xpath = "//a[normalize-space(text())='Reporting']")
    private WebElement report;
	
	@FindBy(xpath = "//a[normalize-space(text())='Transfer Report']")
	private WebElement transferReport;

	public CustLoadFuelkadBulkImport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		waitForElement(TopupAndLoadMenu).click();
		waitForElement(LoadFuelcardBulkImportMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"loadbulkfuelcard.do");
	}
	
	public void clickOnDownloadFuelkadBulkImport() {
		DownloadLoadFuelcardBulkImport.click();
	}
	
	public void clickOnCancel() {
		CancelBtn.click();
	}
	
    public void clickOnSubmit() {
    	SubmitBtn.click();
	}
    
    public void chooseFilterDateAndSearch() {
    	
    	waitForElement(report).click();
		waitForElement(transferReport).click();
    	
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		searchFilterBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	//	Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SearchTransferReport.do");

	}

}
