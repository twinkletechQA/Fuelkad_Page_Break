package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class AdminDashboard extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[1]")
	private WebElement SUB_DASHBOARD_MENU;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div/div/div/div[5]/div/div[1]/input")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div/div/div/div[5]/div/div[3]/button")
	private WebElement RESET_BTN;

	@FindBy(xpath = "//*[@id=\"flatpickr\"]")
	private WebElement FILTER_DATE_FIELD;

	public AdminDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void ClickOnMenu() {
		DASHBOARD_MENU.click();
		SUB_DASHBOARD_MENU.click();
		
	}
	public void SelectDatesFilter() {
		  selectTodayAndPreviousMonthDate(FILTER_DATE_FIELD);

	}
	
	public void ClickSearchButton() {
		SEARCH_BTN.click();
		Assert.assertEquals(checkURL(driver), "SearchFuelCardUsageStatistics.do");

	}
	
	public void ClickResetButton() {
		RESET_BTN.click();
		Assert.assertEquals(checkURL(driver), "AdminDashboard.do");
		verifyUrlIsEqual(AdminBaseUrl + "AdminDashboard.do", "RESET");
	}

}
