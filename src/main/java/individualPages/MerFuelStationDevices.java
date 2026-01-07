package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerFuelStationDevices extends Base {

	String MerchantBaseUrl = prop.getProperty("merUrl");

	@FindBy(xpath = "(//a[normalize-space(text())='Fuel Stations / Devices'])[1]")
	private WebElement FuelStationDevicesMainMenu;

	@FindBy(xpath = "(//a[normalize-space(text())='Fuel Stations / Devices'])[2]")
	private WebElement FuelStationDevicesSubMenu;

	@FindBy(id = "flatpickr")
	private WebElement dateFieldLocator;

	@FindBy(id = "merchantId")
	private WebElement MerchantDropdown;

	@FindBy(id = "vendorLocation")
	private WebElement MerchantStationDropdown;

	@FindBy(id = "ExportPdf")
	private WebElement PDFDownload;

	@FindBy(xpath = "//*[@id='buttons']/div/button")
	private WebElement ExportExcel;

	@FindBy(id = "dailyPeriodButton")
	private WebElement PeriodMenu;

	@FindBy(xpath = "//div[@id='dailyPeriod12_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement PeriodCSVBtn;

	@FindBy(id = "customerUsageButton")
	private WebElement CustomerUsageMenu;

	@FindBy(xpath = "//div[@id='customerUse_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement CustomerUsageCSVBtn;

	@FindBy(id = "customerPurchaseButton")
	private WebElement CustomerPurchasesMenu;

	@FindBy(xpath = "//div[@id='CustomerPurchase_wrapper']//button[contains(@class,'buttons-csv')]")
	private WebElement CustomerPurchasesCSVBtn;

	@FindBy(xpath = "//*[@id='example']/tbody/tr")
	private List<WebElement> AddManageDeviceList;

	@FindBy(xpath = "//button[@type='reset']")
	private List<WebElement> AddManageDeviceBtns;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement AddDeviceSaveButton;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement AddDeviceCancelButton;

	@FindBy(xpath = "//*[@id='example']//td[not(contains(text(),'No data'))]/parent::tr")
	private List<WebElement> DeviceList;

	@FindBy(xpath = "//button[@class='editbutton']")
	private List<WebElement> DeviceListEditBtns;

	public MerFuelStationDevices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenu() {
		FuelStationDevicesMainMenu.click();
		FuelStationDevicesSubMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "AddFuelStations.do");
	}

	public void clickOnAddManageDevice() {

		for (int i = 0; i < AddManageDeviceList.size(); i++) {
			AddManageDeviceBtns.get(i).click();
			AddDeviceSaveButton.click();
			AddDeviceCancelButton.click();
			Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "AddFuelStations.do");
		}

	}

	public void clickOnDeviceListEdit() {

		for (int i = 0; i < AddManageDeviceList.size(); i++) {
			AddManageDeviceBtns.get(i).click();

			if (DeviceList.size() == 0) {
				System.out.println("No device records available to edit");
				AddDeviceCancelButton.click();
				return;
			} else {
				for (int j = 0; j < DeviceList.size(); j++) {
					DeviceListEditBtns.get(j).click();
				}
				AddDeviceCancelButton.click();
				Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "AddFuelStations.do");
			}

		}
	}

//	public void chooseFilterDateAndSearch() {
//		selectTodayAndPreviousMonthDate(dateFieldLocator);
//		clickOnSearchBtn();
//	}
//	
//	public void chooseFilterMerchantDDAndSearch() {
//		SelectRandomDropdownFieldvalue(MerchantDropdown);
//		clickOnSearchBtn();
//	}
//	
//	public void chooseFilterMerchantStationDDAndSearch() {
//		SelectRandomDropdownFieldvalue(MerchantStationDropdown);
//		clickOnSearchBtn();
//	}
//
//	public void clickOnSearchBtn() {
//		SearchButton.click();
//	}
//
//	public void clickOnResetBtn() {
//		ResetButton.click();
//	}
//
//	public void clickOnExportPDF() {
//		PDFDownload.click();
//	}
//
//	public void clickOnExportExcel() {
//		ExportExcel.click();
//	}
//
//	public void clickOnPeriodMenu() {
//		PeriodMenu.click();
//		PeriodCSVBtn.click();
//	}
//	
//	public void clickOnCustomerUsageMenu() {
//		CustomerUsageMenu.click();
//		CustomerUsageCSVBtn.click();
//	}
//	
//	public void clickOnCustomerPurchasesMenu() {
//		CustomerPurchasesMenu.click();
//		CustomerPurchasesCSVBtn.click();
//	}

}
