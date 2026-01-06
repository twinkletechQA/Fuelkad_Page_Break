package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustAddSecondaryCard extends Base {
	
	@FindBy(xpath = "//a[normalize-space(text())='FuelCard Actions']")
    private WebElement FuelCardActionsMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Add Secondary Card']")
	private WebElement AddSecondaryCardMenu;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SaveBtn;
	
	@FindBy(id = "cancel")
	private WebElement CancelBtn;
	
	public CustAddSecondaryCard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		waitForElement(FuelCardActionsMenu).click();
		waitForElement(AddSecondaryCardMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"addcard.do");
	}
	
	public void clickCancelBtn() {
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"addcard.do");
		CancelBtn.click();
	}
	
	public void clickSaveBtn() {
		SaveBtn.click();				
	}

}
