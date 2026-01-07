package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustUsers extends Base{
	
	
String BaseUrl = prop.getProperty("custUrl");
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[6]/a")
	private WebElement UsersMainMenu;
	
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[6]/div/a")
	private WebElement UsersSubMenu;
		
	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div/div/div[2]/div/div/div[1]/button")
	private WebElement SaveButton;
	
	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div/div/div[2]/div/div/div[3]/button")
	private WebElement CancelButton;
	
	@FindBy(xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy(xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]/span")
	private WebElement PDFDownload;
	
	public CustUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMenu() {
		

		waitForElement(UsersMainMenu).click();
		waitForElement(UsersSubMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"CustomerUserLogin.do");
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