package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AllMerchantReport extends Base {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DashboardMenu;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[3]")
	private WebElement AllMerchantReportMenu;

	@FindBy(xpath = "//select[@id=\"merchantId\"]")
	private WebElement MerchantDDFilter;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBTN;

	@FindBy(xpath = "//button[@id='ExportPdf']")
	private WebElement exportPDFBTN;

	public AllMerchantReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardMenu() {
		return DashboardMenu;
	}

	public void setDashboardMenu(WebElement dashboardMenu) {
		DashboardMenu = dashboardMenu;
		dashboardMenu.click();
	}

	public WebElement getAllMerchantReportMenu() {
		return AllMerchantReportMenu;
	}

	public void setAllMerchantReportMenu(WebElement allMerchantReportMenu) {
		AllMerchantReportMenu = allMerchantReportMenu;
		allMerchantReportMenu.click();
	}

	public WebElement getMerchantDDFilter() {
		return MerchantDDFilter;
	}

	public void setMerchantDDFilter(WebElement merchantDDFilter) {
		MerchantDDFilter = merchantDDFilter;
		selectByValue(merchantDDFilter, "73");
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public void setSearchBTN(WebElement searchBTN) {
		this.searchBTN = searchBTN;
		searchBTN.click();
	}

	public WebElement getExportPDFBTN() {
		return exportPDFBTN;
	}

	public String setExportPDFBTN(WebElement exportPDFBTN) {
		this.exportPDFBTN = exportPDFBTN;
		exportPDFBTN.click();
		return dateAndTime();
	}



	

}
