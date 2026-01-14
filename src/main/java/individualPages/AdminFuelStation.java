package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminFuelStation extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");
	
	@FindBy(xpath = "//a[normalize-space(text())='FuelKad Merchants']")
	private WebElement FuelKadMerchantsMainMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Fuel Stations']")
	private WebElement FuelStationSubMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Fuel Station']")
	private WebElement FuelStationTitle;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;

	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Add Station']")
	private WebElement AddNewStationBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Add Station']")
	private WebElement AddStationTitle;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Add Station']")
	private WebElement AddStationBtn;
	
	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Cancel']")
	private WebElement CancelBtn;
	
	@FindBy(xpath = "//*[@id='example']/tbody/tr/td[7]/a")
	private List<WebElement> FuelStationEditBtns;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Edit Station']")
	private WebElement EditStationTitle;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Update']")
	private WebElement UpdateStationBtn;
	
	@FindBy(xpath = "//button[contains(@type,'reset') and normalize-space()='Back']")
	private WebElement BackBtn;
	
	public AdminFuelStation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		FuelKadMerchantsMainMenu.click();
		FuelStationSubMenu.click();		
	}
	
	public void ListViewURL_And_TitleCheking() {
		verifyUrlIsEqual(AdminBaseUrl + "FuelStation.do", "CLICK_FuelStation_MENU");
		verifyIsEqual(FuelStationTitle.getText(), "Fuel Station", "FuelStation_TITLE_CHECKING");
	}
	
	public void AddNewStationViewURL_And_TitleCheking() {
		verifyUrlIsEqual(AdminBaseUrl + "AddFuelStation.do", "CLICK_AddFuelStation_MENU");
		verifyIsEqual(AddStationTitle.getText(), "Add Station", "AddFuelStation_TITLE_CHECKING");
	}
	
	public void EditViewURL_And_TitleCheking() {
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertTrue(
			    currentUrl.contains("EditFuelStation.do") &&
			    currentUrl.contains("Hidden_id_Update="),
			    "Edit page URL validation failed. Actual URL: " + currentUrl
			);
		verifyIsEqual(EditStationTitle.getText(), "Edit Station", "EditStation_TITLE_CHECKING");
	}
	
	public void clickOnEditBackBtn() {
		BackBtn.click();
		ListViewURL_And_TitleCheking();
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}

	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnFuelStationMenu() {
		ClickOnMenu();
		ListViewURL_And_TitleCheking();
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void clickOnAddNewStation() {
		AddNewStationBtn.click();
		AddNewStationViewURL_And_TitleCheking();
		AddStationBtn.click();
		CancelBtn.click();
	}
	
	public void clickOnEditBtn() {
		FuelStationEditBtns.get(generateRandomNumber(FuelStationEditBtns)).click();
		EditViewURL_And_TitleCheking();
		clickOnEditBackBtn();
	}
	
	
	
}
