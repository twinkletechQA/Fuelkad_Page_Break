package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminBrandManagement extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//a[normalize-space(text())='Settings']")
	private WebElement SettingsMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Brand Management']")
	private WebElement BrandManagementMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Brand Management']")
	private WebElement BrandManagementTitle;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private List<WebElement> CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private List<WebElement> PDF_Download;
	
	@FindBy(id = "provincebtn")
	private WebElement ProvinceBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Province List']")
	private WebElement ProvinceListViewTitle;
	
	@FindBy(id = "townbtn")
	private WebElement TownBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Town List']")
	private WebElement TownListViewTitle;
	
	@FindBy(id = "locationbtn")
	private WebElement LocationBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Location List']")
	private WebElement LocationListViewTitle;
	
	@FindBy(id = "fuelbrandbtn")
	private WebElement FuelBrandBtn;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Fuel Brand List']")
	private WebElement FuelBrandListViewTitle;
	
	@FindBy(xpath ="//button[@type='submit']")
	private List<WebElement> CreateBtn;

	
	public AdminBrandManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		SettingsMainMenu.click();
		BrandManagementMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "BrandManagementDetails.do", "CLICK_Brand Management_MENU");
		verifyIsEqual(BrandManagementTitle.getText(), "Brand Management","Brand Management_TITLE_CHECKING");
	}
	
	public void CheckProvinceView() {
		ProvinceBtn.click();
		CreateBtn.get(0).click();
		verifyIsEqual(ProvinceListViewTitle.getText(), "Province List","ProvinceListView_TITLE_CHECKING");
		CSV_Download.get(0).click();
		PDF_Download.get(0).click();	
		ClickOnPaginationButtonUntilDisabledUsingListElement(0);
	}
	
	public void CheckTownView() {
		ClickElementUsingJavaScript(TownBtn);
		CreateBtn.get(1).click();
		verifyIsEqual(TownListViewTitle.getText(), "Town List","TownListView_TITLE_CHECKING");
		
		waitForElement(CSV_Download.get(1)).click();
		waitForElement(PDF_Download.get(1)).click();
		ClickOnPaginationButtonUntilDisabledUsingListElement(1);
	}
	
	public void CheckLocationView() {
		ClickElementUsingJavaScript(LocationBtn);
		CreateBtn.get(2).click();
		verifyIsEqual(LocationListViewTitle.getText(), "Location List","LocationListView_TITLE_CHECKING");
		CSV_Download.get(2).click();
		PDF_Download.get(2).click();
		ClickOnPaginationButtonUntilDisabledUsingListElement(2);
		}
	
	public void CheckFuelBrandView() {
		ClickElementUsingJavaScript(FuelBrandBtn);
		CreateBtn.get(3).click();
		verifyIsEqual(FuelBrandListViewTitle.getText(), "Fuel Brand List","FuelBrandListView_TITLE_CHECKING");
		CSV_Download.get(3).click();
		PDF_Download.get(3).click();	
		ClickOnPaginationButtonUntilDisabledUsingListElement(3);
	}

}
