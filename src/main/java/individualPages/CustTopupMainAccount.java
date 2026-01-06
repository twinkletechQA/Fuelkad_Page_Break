package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustTopupMainAccount extends Base {
	
	@FindBy(xpath = "//a[normalize-space(text())='Topup And Load']")
    private WebElement TopupAndLoadMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Topup Main Account']")
	private WebElement TopupMainAccountMenu;
	
	@FindBy(xpath = "(//a[@target='_blank'])[2]")
	private WebElement TermsAndConditionsLink;
	
	@FindBy(id = "paybutton")
	private WebElement PayBtn;

	public CustTopupMainAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		waitForElement(TopupAndLoadMenu).click();
		waitForElement(TopupMainAccountMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"TopupMainAccount.do");
	}
	
	public void clickOnTermsAndConditions() {
		TermsAndConditionsLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mainWindow = driver.getWindowHandle();

		for (String window : driver.getWindowHandles()) {
		    if (!window.equals(mainWindow)) {
		        driver.switchTo().window(window);
		        driver.close();
		    }
		}

		driver.switchTo().window(mainWindow);
	}
	
    public void clickOnPayBtn() {
    	PayBtn.click();
	}

}
