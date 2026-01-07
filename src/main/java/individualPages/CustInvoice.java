package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustInvoice  extends Base {
	
	
	
String BaseUrl = prop.getProperty("custUrl");
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[7]/a")
	private WebElement InvoiceMainMenu;
	
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[7]/div/a")
	private WebElement GenerateSubMenu;
		
	@FindBy(id = "popup-button")
	private WebElement PreviewInvoice;
	
	@FindBy(xpath = "//*[@id=\"resetBtn\"]")
	private WebElement ResetButton;
	

	
	public CustInvoice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMenu() {
		

		waitForElement(InvoiceMainMenu).click();
		waitForElement(GenerateSubMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"GenerateTaxInvoice.do");
	}
		
	
	public void ClickSaveButton() {
		PreviewInvoice.click();
	}
	
	public void ClickCancelButton() {
		ResetButton.click();
	}
	


}
