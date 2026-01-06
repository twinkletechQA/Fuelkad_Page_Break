package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseclass.Base;

public class CustSetupUserAccount extends Base {	
	
	String BaseUrl = prop.getProperty("custUrl");
	
	@FindBy(id = "success")
	private WebElement successMsg;
	
	@FindBy(id = "submit")
	private WebElement SaveBtn;
	
	@FindBy(id = "cancel")
	private WebElement CancelBtn;
	
	@FindBy(xpath = "//a[normalize-space(text())='FuelCard Actions']")
    private WebElement FuelCardActionsMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Setup User Account']")
	private WebElement SetupUserAccountMenu;
	
	@FindBy(id = "update")
	private WebElement SendRequestBtn;
	
	@FindBy(className = "(//button[normalize-space(text())='Cancel'])[2]")
	private WebElement CancelMoreCardsAlert;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement SendRequestCloseBtn;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement SendRequestSendBtn;
	
	@FindBy(xpath = "//*[@id='sendrequestdialuge']/span")
	private WebElement CardsEmptyValidation;
	
	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement SendRequestCancelBtn;
	
	@FindBy(className = "resetpassword")
	private WebElement ClickPassResetLink;

	public CustSetupUserAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSaveBtn() {
		SaveBtn.click();
		waitForVisibilityOfElementLocated(successMsg);
		Assert.assertTrue(
				successMsg.isDisplayed(),
                "Success message is not displayed"
        );
		
		Assert.assertEquals(
				successMsg.getText().trim(),
                "User account Details Saved Successfully",
                "Success message text mismatch"
        );
		
	}
	
	
	public void clickCancelBtn() {
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"useraccount.do");
		CancelBtn.click();
	}
	
	public void clickOnMenu() 
	{
		waitForElement(FuelCardActionsMenu).click();
		waitForElement(SetupUserAccountMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"useraccount.do");
	}
	
	public void clickOnSendRequestCancel() 
	{
		SendRequestBtn.click();
		SendRequestCancelBtn.click();
	}
	
	public void clickOnSendRequestClose() 
	{
		SendRequestBtn.click();
		SendRequestCloseBtn.click();
	}
	
	public void clickOnSendRequestSendValidation() 
	{
		SendRequestBtn.click();
		SendRequestSendBtn.click();		
		Assert.assertEquals(CardsEmptyValidation.getText(), "Please enter no of cards");
	}
	
	public void clickOnPassResetLink() 
	{
		ClickPassResetLink.click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"forgotpassword.do");
		driver.navigate().back();
	}

}
