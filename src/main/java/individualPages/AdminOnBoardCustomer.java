package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminOnBoardCustomer extends Base {

	String AdminBaseUrl = prop.getProperty("adminUrl");
	
	@FindBy(xpath = "(//a[normalize-space(text())='Onboard Customer'])[1]")
	private WebElement OnBoardCustomerMainMenu;

	@FindBy(xpath = "(//a[normalize-space(text())='Onboard Customer'])[2]")
	private WebElement OnBoardCustomerSubMenu;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Customer Onboarding']")
	private WebElement OnBoardCustomerTitle;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement RegisterBtn;
	
	@FindBy(xpath ="//button[@type='reset']")
	private WebElement CancelBtn;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath = "//*[@id='example']//td[not(contains(text(),'No data'))]/parent::tr")
	private List<WebElement> OnBoardCustomerList;
	
	@FindBy(xpath = "//table[@id='example']//button[normalize-space()='Resend']")
	private List<WebElement> ResendBtns;
	
	@FindBy(xpath = "//span[normalize-space(text())='CONFIRMATION']")
	private WebElement ConfirmationTitle;
	
	@FindBy(xpath = "//*[@id='deleteUser']/p[1]")
	private WebElement ConfirmationDialogue;
	
	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[text()='Yes']")
	private WebElement Confirm_Yes_Btn;
	
	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[text()='No']")
	private WebElement Confirm_No_Btn;
	
	public AdminOnBoardCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMenu() {
		OnBoardCustomerMainMenu.click();
		OnBoardCustomerSubMenu.click();
		verifyUrlIsEqual(AdminBaseUrl + "GetOnboardingCustomer.do", "CLICK_ONBOARD_CUSTOMER_MENU");
		verifyIsEqual(OnBoardCustomerTitle.getText(), "Customer Onboarding","ONBOARD_CUSTOMER_TITLE_CHECKING");
	}
	
	public void clickOnRegisterBtn() {
		RegisterBtn.click();
	}
	
	public void clickOnCancelBtn() {
		CancelBtn.click();
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickOnOnboardCustomerList() {
		for (int j = 0; j < OnBoardCustomerList.size(); j++) {
			ResendBtns.get(j).click();
			verifyIsEqual(ConfirmationTitle.getText().trim(), "CONFIRMATION","ONBOARD_CUSTOMER_LIST_EDIT_TITLE_CHECKING");
			verifyIsEqual(ConfirmationDialogue.getText().trim(), "Are you sure you want to resend registration link?","ONBOARD_CUSTOMER_LIST_EDIT_MSG_CHECKING");
			Confirm_No_Btn.click();
			return;
		}
	}
	
}
