package individualPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseclass.Base;

public class AdminFuelkadCustomers extends Base {

	static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/a")
	private WebElement DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/div/a[1]")
	private WebElement SUB_DASHBOARD_MENU;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[4]/div/div[2]/div/div/div[3]/button")
	private WebElement RESET_BTN;
	
	@FindBy(id="flatpickr")
	private WebElement DatePickerFilter;
	
	@FindBy (name = "status")
	private WebElement EmailFilter;
	
	@FindBy (name = "mobileNumber")
	private WebElement mobileNumberFilter;
	
	@FindBy (name = "name")
	private WebElement CardHolderName;
	
	@FindBy (name = "merchantname")
	private WebElement MerchantNameFilter;
	
	
	 @FindBy(id = "status")
	 private WebElement AccountStatusDropdown;

	   
		/*
		 * this.driver = driver; PageFactory.initElements(driver, this);
		 * 
		 * 
		 * public void selectAccountStatus(String value) { Select
		 * AccountStatusDropdownSelect = new Select(AccountStatusDropdown);
		 * AccountStatusDropdownSelect.selectByVisibleText(value);
		 */
	
	
	
	@FindBy(xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]")
	private WebElement EXPORT_CSV_FIELD;

	@FindBy(xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]")
	private WebElement EXPORT_PDF_FIELD;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/button[1]")
	private WebElement DEACTIVATE_BTN;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]")
	private WebElement BLOCK_BTN;

	@FindBy(xpath = "//*[@id=\"example\"]/tbody/tr[3]/td[17]/label/span")
	private WebElement BULK_ACTION_CHECK_BOX;

	@FindBy(xpath = "/html/body/div[4]/div[3]/div/button[1]")
	private WebElement DEACTIVATE_CONFIRM_YES_BTN;

	@FindBy(css = ".alert.alert-success#success")
	private WebElement DEACTIVATE_OR_BLOCK_SUCC_MSG;

	@FindBy(xpath = "//*[@id=\"selectCardAlert\"]/p[1]")
	private WebElement ALERT_BOX;

	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement ALERT_CONFIRM_BTN;

	public AdminFuelkadCustomers(WebDriver driver) {
		AdminFuelkadCustomers.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnMenu() throws InterruptedException {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();
		Assert.assertEquals(checkURL(driver), "FuelKadUsers.do");
		
	}
	public void SearchButton() throws InterruptedException {
		SEARCH_BTN.click();
		Thread.sleep(1000);
		Assert.assertEquals(checkURL(driver), "SearchFuelCardDetails.do");

	}
	
	public void ResetButton() {
		RESET_BTN.click();
		Assert.assertEquals(checkURL(driver), "FuelKadUsers.do");
	}
	
	public void ExportPDF() {
		EXPORT_PDF_FIELD.click();
	}
	
	public void ExportCSV() {
		EXPORT_CSV_FIELD.click();
	}
	
	public void DeactivateButton() {
		DEACTIVATE_BTN.click();
		Assert.assertEquals(ALERT_BOX.getText(), "Kindly first select the Bulk Action checkboxes to action.");
		ALERT_CONFIRM_BTN.click();
		RESET_BTN.click();

		//clickElementWithJSExecuiter(driver, SEARCH_BTN);
		/*
		 * BULK_ACTION_CHECK_BOX.click(); DEACTIVATE_BTN.click();
		 * clickElementWithJSExecuiter(driver, DEACTIVATE_CONFIRM_YES_BTN);
		 * System.out.println(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText()); //
		 * Assert.assertEquals(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText(),
		 * "Selected card details deactivated successfully.");
		 * clickElementWithJSExecuiter(driver, SEARCH_BTN);
		 */
		
		
	}
	

    public void BlockButton() { 
		
		BLOCK_BTN.click();
		Assert.assertEquals(ALERT_BOX.getText(), "Kindly first select the Bulk Action checkboxes to action.");
		ALERT_CONFIRM_BTN.click();
		RESET_BTN.click();

		//clickElementWithJSExecuiter(driver, SEARCH_BTN);
		
	}
    public void FilterSearch() throws InterruptedException {
    	//DatePickerFilter
    	EmailFilter.sendKeys("vasan.testing.5@gmail.com");
    	mobileNumberFilter.sendKeys("75646545");
    	CardHolderName.sendKeys("Fuelkad customer");
    	MerchantNameFilter.sendKeys("V8 merchant");
    	//AccountStatusDropdown.
		SEARCH_BTN.click();
		Thread.sleep(1000);
		EXPORT_PDF_FIELD.click();
		EXPORT_CSV_FIELD.click();
		RESET_BTN.click();

}
}