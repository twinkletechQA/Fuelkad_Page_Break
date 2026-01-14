package individualPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.Base;

public class AdminAdjustMainACBalance extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");

	@FindBy(xpath = "//a[normalize-space(text())='FuelKad Customers']")
	private WebElement FuelKadCustomersMainMenu;

	@FindBy(xpath = "//a[normalize-space(text())='Adjust Main A/C Balance']")
	private WebElement AdjustMainACBalanceSubMenu;

	@FindBy(xpath = "//h1[normalize-space(text())='Adjust Main A/C Balance']")
	private WebElement AdjustMainACBalanceTitle;

	@FindBy(xpath = "//h1[normalize-space(text())='Customers Main Account Balance Adjustment List']")
	private WebElement AdjustMainACBalanceListTitle;

	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;

	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;

	@FindBy(id = "flatpickr")
	private WebElement dateFieldLocator;

	@FindBy(id = "company")
	private WebElement CompanyFilter;

	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "(//button[contains(@type,'reset') and normalize-space()='Cancel'])[2]")
	private WebElement CancelBtn;
	
	@FindBy(id = "country3")
	private WebElement CustomerAdminName;
	
	@FindBy(xpath = "//datalist[@id='countrydata3']/option")
	private List<WebElement> CustomerAdminNameList;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Adjust']")
	private WebElement AdjustBtn;

	@FindBy(xpath = "(//button[contains(@type,'reset') and normalize-space()='Cancel'])[1]")
	private WebElement AdjustAccBalanceResetBtn;
	
	@FindBy(xpath = "//button[contains(@type,'submit') and normalize-space()='Debit']")
	private WebElement DebtBtn;

	@FindBy(xpath = "(//button[contains(@type,'reset') and normalize-space()='Cancel'])[1]")
	private WebElement AdjustAccBalanceCancelBtn;

	public AdminAdjustMainACBalance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnMenu() {
		FuelKadCustomersMainMenu.click();
		AdjustMainACBalanceSubMenu.click();
		ListViewURL_And_TitleCheking();
	}

	public void ListViewURL_And_TitleCheking() {
		verifyUrlIsEqual(AdminBaseUrl + "GetAdjustmentMainAcDetails.do");
		verifyIsEqual(AdjustMainACBalanceTitle.getText(), "Adjust Main A/C Balance");
	}
	
	public void SearchViewURL_And_TitleCheking() {
		verifyUrlIsEqual(AdminBaseUrl + "SearchAdjustmentByAdmin.do");
		verifyIsEqual(AdjustMainACBalanceTitle.getText(), "Adjust Main A/C Balance");
	}
	
	public void AdjustViewURL_And_TitleCheking() {
		verifyUrlIsEqual(AdminBaseUrl + "ConfirmAdjustmentByAdmin.do");
		verifyIsEqual(AdjustMainACBalanceTitle.getText(), "Adjust Main A/C Balance");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}

	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnSearchBtn() {
		SearchBtn.click();
	}

	public void clickOnCancelBtn() {
		CancelBtn.click();
	}
	
	public void clickOnAdjustBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
		        .elementToBeClickable(AdjustBtn)).click();
		
		
		AdjustViewURL_And_TitleCheking();
	}
	
	public void clickOnAdjustAccCancelBtn() {
		AdjustAccBalanceCancelBtn.click();
		ListViewURL_And_TitleCheking();
	}
	
	public void passValuesOnCustomerAdminName() {
		ClickOnMenu();
		CustomerAdminName.clear();
		CustomerAdminName.sendKeys("Cathi Taukoro Administrator");
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CustomerAdminName);	
		
		clickOnAdjustBtn();
		waitForVisibilityOfElementLocated(DebtBtn).click();
		clickOnAdjustAccCancelBtn();
	}
	
	
	// Methodsddtest
	
	public void withoutFilter() {
		
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
	}
	
	public void emptyFilterSearch() {
		clickOnSearchBtn();
		SearchViewURL_And_TitleCheking();
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnCancelBtn();
	}
	
	public void chooseOneMonthFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(waitForElement(dateFieldLocator));
		SelectRandomDropdownFieldvalue(CompanyFilter);
		clickOnSearchBtn();
		clickCSV_Download();
		clickPDF_Download();
		ClickOnPaginationButtonUntilDisabled();
		clickOnCancelBtn();
	}

}
