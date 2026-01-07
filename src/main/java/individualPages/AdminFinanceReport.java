package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class AdminFinanceReport extends Base {

	static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[2]")
	private WebElement SUB_DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[1]/button")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[3]/button")
	private WebElement RESET_BTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[5]/button")
	private WebElement EXPORT_CSV_FIELD;

	

	public AdminFinanceReport(WebDriver driver) {
		AdminFinanceReport.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void ClickOnMenu() {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();


	}
	
	public void ClickExport() {
		EXPORT_CSV_FIELD.click();	

	}
	
	public void ClickSearchButton() {
		SEARCH_BTN.click();
		Assert.assertEquals(checkURL(driver), "SearchFinanceReport.do");
		
		
	}
	public void ClickResetButton() {
		RESET_BTN.click();
		Assert.assertEquals(checkURL(driver), "GetFinanceReport.do");
	
	
	}
	

}