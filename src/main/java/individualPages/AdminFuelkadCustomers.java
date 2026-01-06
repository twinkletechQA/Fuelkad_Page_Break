package individualPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	private WebElement ALERT_TEXT;

	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement ALERT_CONFIRM_BTN;

	public AdminFuelkadCustomers(WebDriver driver) {
		AdminFuelkadCustomers.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void testCase1() throws InterruptedException {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();
		Assert.assertEquals(checkURL(driver), "FuelKadUsers.do");
		SEARCH_BTN.click();
		Assert.assertEquals(checkURL(driver), "SearchFuelCardDetails.do");
		RESET_BTN.click();
		Assert.assertEquals(checkURL(driver), "FuelKadUsers.do");
		EXPORT_PDF_FIELD.click();
		EXPORT_CSV_FIELD.click();

		DEACTIVATE_BTN.click();
		Assert.assertEquals(ALERT_TEXT.getText(), "Kindly first select the Bulk Action checkboxes to action.");
		ALERT_CONFIRM_BTN.click();
		clickElementWithJSExecuiter(driver, SEARCH_BTN);

		BULK_ACTION_CHECK_BOX.click();
		DEACTIVATE_BTN.click();
		clickElementWithJSExecuiter(driver, DEACTIVATE_CONFIRM_YES_BTN);
		System.out.println(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText()); //
		Assert.assertEquals(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText(), "Selected card details deactivated successfully.");
		clickElementWithJSExecuiter(driver, SEARCH_BTN);

		DEACTIVATE_BTN.click();
		Assert.assertEquals(ALERT_TEXT.getText(), "Kindly first select the Bulk Action checkboxes to action.");
		ALERT_CONFIRM_BTN.click();
		clickElementWithJSExecuiter(driver, SEARCH_BTN);

		BULK_ACTION_CHECK_BOX.click();
		BLOCK_BTN.click();
		DEACTIVATE_CONFIRM_YES_BTN.click();
		System.out.println(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText());
		Assert.assertEquals(DEACTIVATE_OR_BLOCK_SUCC_MSG.getText(), "Selected card details blocked successfully.");
		
		
	}

}