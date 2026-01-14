package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminFuelkadStatus extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Fuelkad Status']")
	private WebElement FuelkadStatusMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Fuelkad Status']")
	private WebElement FuelkadStatusTitle;
	
	@FindBy(xpath = "//h2[normalize-space(text())='Fuelkad Status List']")
	private WebElement FuelkadStatusListTitle;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement SearchBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement ResetBtn;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	public AdminFuelkadStatus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		SettingsMainMenu.click();
		FuelkadStatusMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "FuelkadStatus.do", "CLICK_FuelkadStatus_MENU");
		verifyIsEqual(FuelkadStatusTitle.getText(), "Fuelkad Status","FuelkadStatus_TITLE_CHECKING");
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
