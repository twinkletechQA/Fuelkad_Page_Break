package individualPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminTransactionSummary extends Base {

	
	String AdminBaseUrl = prop.getProperty("adminUrl");
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/a")
	private WebElement MainMenu;
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/div/a[3]")
	private WebElement SubMenu;
	
	@FindBy(xpath = "//*[@id=\"flatpickr\"]")
	private WebElement FILTER_DATE_FIELD;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[3]")
	private WebElement FILTER_FROM_DATE;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[32]")
	private WebElement FILTER_TO_DATE;
	
	@FindBy(name = "customerid")
	private WebElement CustomerIDFilter;
	
	@FindBy(name = "status")
	private WebElement CreditReverted;
	
	@FindBy(name = "customername")
	private WebElement CardHolderNameFilter;
	
	@FindBy(name = "email")
	private WebElement EmailFilter;
	
	@FindBy(xpath = "//*[@id=\"frmTransactions\"]/div[4]/div/div[3]/div/div/div[1]/button")
	private WebElement SearchButton;
	
	@FindBy (xpath = "//*[@id=\"frmTransactions\"]/div[4]/div/div[3]/div/div/div[2]/button")
	private WebElement ResetButton;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]")
	private WebElement CSVDownload;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]/span")
	private WebElement PDFDownload;
	
	public AdminTransactionSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
}
	
	public void ClickOnMenu() {
		MainMenu.click();
		SubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl+"Admintransactiondetails.do", "CLICKONMENU");
	}
	
	public void DefaultDownloadCSVAndPDF() {
		CSVDownload.click();
		PDFDownload.click();
	}
	
	public void SelectDatesFilter() {
		selectTodayAndPreviousMonthDate(FILTER_DATE_FIELD);

	}
	
	public void CheckCustomerID() {
		CustomerIDFilter.sendKeys("78898977");
	}
	
	public void TopupTypeDropDownSelect() {
		SelectRandomDropdownFieldvalue(CreditReverted);
	}
	
	public void CheckCardHolderNameFilter() {
		CardHolderNameFilter.sendKeys("Vasan test");
	}
	
	public void CheckEmailFilter() {
		EmailFilter.sendKeys("vasan.testing.2@gmail.com");
	}
	
	public void ClickSearchButton() {
		SearchButton.click();
		verifyUrlIsEqual(AdminBaseUrl+"AdminSearchtransactiondetails.do", "SEARCH");
	}
	
	public void CSVDownload() {
		CSVDownload.click();		
	}
	
	public void PDFDownload( ) {
		PDFDownload.click();
	}
	
	public void ClickCancelButton() {
		ResetButton.click();
		verifyUrlIsEqual(AdminBaseUrl+"Admintransactiondetails.do","CANCEL");
    }
}


