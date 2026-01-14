package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminTopupCustomers extends Base {
	
	String AdminBaseUrl = prop.getProperty("adminUrl");
	
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/a")
	private WebElement MainMenu;
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[2]/div/a[2]")
	private WebElement SubMenu;	
	
	@FindBy (id = "flatpickr")
	private WebElement FILTER_DATE_FIELD;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[3]")
	private WebElement FILTER_FROM_DATE;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[32]")
	private WebElement FILTER_TO_DATE;
	
	@FindBy (name = "type")
	private WebElement TopupTypeDropdown;
	
	@FindBy(xpath = "//*[@id=\"frmTransactions\"]/div/div/div[2]/div/div/div[1]/button")
	private WebElement SearchButton;
	
	@FindBy (xpath = "//*[@id=\"frmTransactions\"]/div/div/div[2]/div/div/div[3]/button")
	private WebElement CancelButton;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]/span")
	private WebElement PDFDownload;
	
	
	public AdminTopupCustomers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		MainMenu.click();
		SubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl+"TopupCustomerByAdmin.do", "SEARCH");
	}
	
	public void DefaultDownloadCSVAndPDF() {
		CSVDownload.click();
		PDFDownload.click();
	}
	
	public void DateFilterSearch() {		
		FILTER_DATE_FIELD.click();
		FILTER_FROM_DATE.click();
		FILTER_TO_DATE.click();			
	}
	
	public void TopupTypeDropDownSelect() {
		SelectRandomDropdownFieldvalue(TopupTypeDropdown);

	}
	
	public void ClickSearchButton() {
		SearchButton.click();
		verifyUrlIsEqual(AdminBaseUrl+"SearchTopupByAdmin.do", "SEARCH");
	}
	
	public void CSVDownload() {
		CSVDownload.click();		
	}
	
	public void PDFDownload( ) {
		PDFDownload.click();
	}
	public void ClickCancelButton() {
		CancelButton.click();
		verifyUrlIsEqual(AdminBaseUrl+"TopupCustomerByAdmin.do", "SEARCH");		
	}
		
}
