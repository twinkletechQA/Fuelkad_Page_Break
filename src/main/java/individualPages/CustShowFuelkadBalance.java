package individualPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustShowFuelkadBalance extends Base {
	
	@FindBy(xpath = "//a[normalize-space(text())='Topup And Load']")
    private WebElement TopupAndLoadMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Show FuelCard Balance']")
	private WebElement ShowFuelcardBalanceMenu;
	
	@FindBy(xpath = "//*[@id='example_wrapper']/div[1]/button[1]")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//*[@id='example_wrapper']/div[1]/button[2]")
	private WebElement PDF_Download;
	
	@FindBy(xpath = "//*[@id='example']/tbody/tr/td/button")
	private List<WebElement> ReverseCreditBtns;
	
	@FindBy(xpath = "//*[@id='example']/tbody/tr/td/button[1]")
	private WebElement ReverseCreditBtn;
	
	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[2]")
	private WebElement ConfirmNoBtn;

	public CustShowFuelkadBalance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() 
	{
		waitForElement(TopupAndLoadMenu).click();
		waitForElement(ShowFuelcardBalanceMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), getBaseURL()+"FuelKadBalance.do");
	}
	
	public void clickOnCSVDownload() {
		CSV_Download.click();
	}
	
    public void clickOnPDFDownload() {
    	PDF_Download.click();
	}
    
    public void clickOnReverseCredit() {
    	if (ReverseCreditBtns.size() > 0) {
    		ReverseCreditBtn.click();
    		ConfirmNoBtn.click();
		}
    }

}
