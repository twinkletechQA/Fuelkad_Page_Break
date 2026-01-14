package individualPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminAuditLog extends Base{
	
	String AdminBaseUrl = prop.getProperty("adminUrl");
	//
	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Audit Log']")
	private WebElement AuditLogSubMenu;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Audit Log']")
	private WebElement AuditLogTitle;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement SearchBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement ResetBtn;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	public AdminAuditLog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		SettingsMainMenu.click();
		AuditLogSubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "AuditLog.do", "CLICK_AUDITLOG_MENU");
		verifyIsEqual(AuditLogTitle.getText(), "Audit Log","AUDITLOG_TITLE_CHECKING");
	}
	
	public void clickOnSearchBtn() {
		SearchBtn.click();
	}
	
	public void clickOnResetBtn() {
		ResetBtn.click();
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);	
	}	
	
	

}
