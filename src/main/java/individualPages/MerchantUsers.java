package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class MerchantUsers extends Base{
	
	
	String BaseUrl = prop.getProperty("merUrl");
	
	
	
	@FindBy(xpath = "(//a[normalize-space(text())='Users'])[1]")
	private WebElement UsersMainMenu;
	
	
	@FindBy(xpath = "(//a[normalize-space(text())='Users'])[2]")
	private WebElement UsersSubMenu;
		
	@FindBy( xpath = "//button[@type='submit']\r\n")
	private WebElement SaveButton;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement CancelButton;
	
	@FindBy(xpath = "//span[text()='CSV']\r\n")
	private WebElement CSVDownload;
	
	@FindBy(xpath = "//span[text()='PDF']\r\n")
	private WebElement PDFDownload;
	
	public MerchantUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMenu() {
		

		waitForElement(UsersMainMenu).click();
		waitForElement(UsersSubMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"mERCHANTUserLogin.do");
	}
		
	
	public void ClickSaveButton() {
		SaveButton.click();
	}
	
	public void ClickCancelButton() {
		CancelButton.click();
	}
	
	
	public void clickCSV_Download() {
		CSVDownload.click();
	}
	
	public void clickPDF_Download() {
		PDFDownload.click();
	}
	
	
}