package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerUserAccountSettings extends Base {
	
	String MerchantBaseUrl = prop.getProperty("merUrl");
	
	@FindBy(id = "success")
	private WebElement successMsg;

	@FindBy(xpath = "//a[normalize-space(text())='UserAccount settings']")
	private WebElement UserAccountSettingsMenu;

	@FindBy(xpath = "//a[normalize-space(text())='User Account']")
	private WebElement UserAccountMenu;
	
	@FindBy(className = "resetpassword")
	private WebElement ClickPassResetLink;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement BackBtn;
	
	public MerUserAccountSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		UserAccountSettingsMenu.click();
		UserAccountMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), MerchantBaseUrl + "VendorAccountSetting.do");
	}

	public void clickOnPassResetLink() 
	{
		ClickPassResetLink.click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"forgotvendorpassword.do");
		driver.navigate().back();
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
                "Your Account Details updated successfully",
                "Success message text mismatch"
        );
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"UpdateVendorAccountSetting.do");
	}
	
	
	public void clickBackBtn() {
		
		BackBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"VendorAccountSetting.do");
	}
	
}
