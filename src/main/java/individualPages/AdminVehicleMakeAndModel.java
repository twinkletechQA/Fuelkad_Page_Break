package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminVehicleMakeAndModel extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Vehicle Make/Model']")
	private WebElement VehicleMake_ModelMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Vehicle Make/Model']")
	private WebElement VehicleMake_ModelTitle;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private List<WebElement> CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private List<WebElement> PDF_Download;
	
	@FindBy(id = "makebtn")
	private WebElement MakeViewBtn;
	
	@FindBy(id = "modelbtn")
	private WebElement ModelViewBtn;
	
	@FindBy(id = "subModelbtn")
	private WebElement SubModelBtn;
	
	@FindBy(xpath = "//button[normalize-space(text())='Add Make']")
	private WebElement AddMakeBtn;
	
	@FindBy(xpath = "//button[normalize-space(text())='Add Model']")
	private WebElement AddModelBtn;
	
	@FindBy(xpath = "//button[normalize-space(text())='Add Sub Model']")
	private WebElement AddSubModelBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Add Vehicle Make']")
	private WebElement AddMakeTitle;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Add Vehicle Model']")
	private WebElement AddModelTitle;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Add Vehicle Sub Model']")
	private WebElement AddSubModelTitle;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement AddBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement CancelBtn;
	
	public AdminVehicleMakeAndModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		SettingsMainMenu.click();
		VehicleMake_ModelMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "CarMakeModel.do", "CLICK_Vehicle Make/Model_MENU");
		verifyIsEqual(VehicleMake_ModelTitle.getText(), "Vehicle Make/Model","Vehicle Make/Model_TITLE_CHECKING");
	}
	
	public void CheckMakeView() {
		MakeViewBtn.click();
		CSV_Download.get(0).click();
		PDF_Download.get(0).click();
//		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void CheckModelView() {
		ModelViewBtn.click();
		CSV_Download.get(1).click();
		PDF_Download.get(1).click();
//		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void CheckSubModelView() {
		SubModelBtn.click();
		CSV_Download.get(2).click();
		PDF_Download.get(2).click();
//		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void addMake() {
		AddMakeBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "AddMakeVehicle.do", "CLICK_AddMakeVehicle_BTN");
		verifyIsEqual(AddMakeTitle.getText(), "Add Vehicle Make","AddMakevehicle_TITLE_CHECKING");
		AddBtn.click();
		CancelBtn.click();
	}
	
	public void addModel() {
		AddModelBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "AddModelVehicle.do", "CLICK_AddModelVehicle_BTN");
		verifyIsEqual(AddModelTitle.getText(), "Add Vehicle Model","AddModelVehicle_TITLE_CHECKING");
		AddBtn.click();
		CancelBtn.click();
	}
	
	public void addSubModel() {
		AddSubModelBtn.click();
		verifyUrlIsEqual(AdminBaseUrl + "AddSubModelVehicle.do", "CLICK_AddSubModelVehicle_BTN");
		verifyIsEqual(AddSubModelTitle.getText(), "Add Vehicle Sub Model","AddSubModelVehicle_TITLE_CHECKING");
		AddBtn.click();
		CancelBtn.click();
	}

}
