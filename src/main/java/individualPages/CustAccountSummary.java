package individualPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseclass.Base;

public class CustAccountSummary extends Base {
	
	String BaseUrl = prop.getProperty("custUrl");
		
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(xpath = "//a[contains(normalize-space(.), 'Edit Account settings')]")
	private WebElement EditAccountSettings;
	
	@FindBy(xpath = "//a[normalize-space(text())='Account Summary']")
	private WebElement AccountSummaryMenu;
	
	// Edit Btn
	@FindBy(xpath = "//*[@class='editright']")
	private List<WebElement> editRightButtons;
	
	private By editRightButton = By.xpath("//*[@class='editright']");
	
	// Edit card Update Btn
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement EditCardUpdateBtn;
	
	// Edit Card cancel Btn
	@FindBy(id = "cancel")
	private WebElement CancelBtn;
	
	// Add Secondary Card Btn
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	private WebElement SecondaryCardAddBtn;
	
	// Active or Inactive
	@FindBy(xpath = "//a[contains(text(), 'Activate') or contains(text(), 'Deactivate')]")
	private List<WebElement> activeButtons;
	
	private By activeButton = By.xpath("//a[contains(text(), 'Activate') or contains(text(), 'Deactivate')]");


	public CustAccountSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		waitForElement(AccountSummaryMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"fuelcardaccounts.do");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void clickEditAccountSettings() {
		EditAccountSettings.click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"useraccount.do");
		DashboardMenu.click();
		AccountSummaryMenu.click();
	}
	
	public void clickAllEditRightButtons() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    for (int i = 0; i < editRightButtons.size(); i++) {

	        // Re-fetch list to avoid stale element
	        List<WebElement> updatedList = driver.findElements(editRightButton);
	        WebElement button = updatedList.get(i);

	        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(CancelBtn)).click();
	        
	        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"fuelcardaccounts.do");
	    }
	}
	
	public void clickSecondaryCardAddBtn() {
		waitForElement(SecondaryCardAddBtn).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"addcard.do");
		waitForElement(CancelBtn).click();
		clickOnMenu();
	}
	
	public void clickAllActive_Inactive() {
	/*	for (int i = 0; i < activeButtons.size(); i++) {

			// Re-fetch list to avoid stale element
			List<WebElement> updatedList = driver.findElements(activeButton);
			WebElement act_deact_button = updatedList.get(i);
			waitForElement(act_deact_button).getText();
			waitForElement(act_deact_button).click();
			
			if(i <= 0) {
				
				
				
			}else {
				
			}
			
			
		}
	*/
		
		List<WebElement> ele = driver.findElements(By.xpath("//a[contains(@class,'moveright') and contains(@onclick,'dialogue')]"));
		
		for (int i = 0; i < ele.size(); i++) {
			WebElement ele1 = ele.get(i);
			String text = ele1.getText();
			String res = text.substring(0,1).toLowerCase() + text.substring(1);
			ele1.click();
			
			WebElement dialogueConfirmationText = driver.findElement(By.xpath("//*[@id='cardinactive']/p[1]"));
			Assert.assertEquals(dialogueConfirmationText, "Are you sure to "+res+" the primary card?");
			
			WebElement confirmationNoElement = driver.findElement(By.xpath("//button[contains(text(),'No')]"));
			confirmationNoElement.click();
			
			ele1.click();
			WebElement closeiconElement = driver.findElement(By.xpath("//button[@title='Close']"));
			closeiconElement.click();
			
		//	WebElement confirmationYesElement = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		}
		
	}

}
