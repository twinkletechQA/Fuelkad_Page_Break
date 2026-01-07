package individualPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustGenerateSecondaryCards  extends Base{
	
	String BaseUrl = prop.getProperty("custUrl");
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[5]/a")
	private WebElement GenerateSecondaryCardsMainMenu;
	
	
	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[5]/div/a")
	private WebElement GenerateSecondaryCardsSubMenu;
	
	
	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div/div[2]/div/div/div[1]/button")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div/div[2]/div/div/div[3]/button")
	private WebElement CancelButton;
	
	
	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div/div[1]/div/div/a")
	private WebElement DownloadLink;
		
	
	@FindBy(xpath = "//*[@id='example_wrapper']/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy(xpath = "//*[@id='example_wrapper']/div[1]/button[2]/span")
	private WebElement PDFDownload;
	
	public CustGenerateSecondaryCards(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMenu() {
		
//		GenerateSecondaryCardsMainMenu.click();
//		GenerateSecondaryCardsSubMenu.click();
		waitForElement(GenerateSecondaryCardsMainMenu).click();
		waitForElement(GenerateSecondaryCardsSubMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"GenerateSecondaryCard.do");
		
	}
	
	public void ClickSubmitButton() {
		SubmitButton.click();
	}
	
	public void ClickCancelButton() {
		CancelButton.click();
	}
	
	public void ClickDownloadLink() {
		DownloadLink.click();

	}
	
	
	public void clickCSV_Download() {
		CSVDownload.click();
	}
	
	public void clickPDF_Download() {
		PDFDownload.click();
	}
	
	
	
	
}





