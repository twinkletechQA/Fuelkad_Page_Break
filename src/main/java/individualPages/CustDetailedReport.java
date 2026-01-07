package individualPages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseclass.Base;

public class CustDetailedReport extends Base{
	
	
	
	String BaseUrl = prop.getProperty("custUrl");
	
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/a")
	private WebElement ReportingDashboard;
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/div/a[3]")
	private WebElement DetailedReportMenu;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="search")
	private WebElement searchFilterBtn;
	
	@FindBy (xpath = "//*[@id=\"search\"]/b")
	private WebElement SearchButton;	
		
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[2]/span")
	private WebElement PDFDownload;
	
	@FindBy (id = "status")
	private WebElement StatusDropdownField;
	
	@FindBy (id = "cardNumber")
	private WebElement CardNumberDropdownField;
	
	
	@FindBy (xpath = "//*[@id=\"search\"]/b")
	private WebElement ResetButton;
	
	public CustDetailedReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		
		waitForElement(ReportingDashboard).click();
		waitForElement(DetailedReportMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"DetailedReport.do");
		
	}
	
	public void ClickSearchButton() {
		SearchButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SearchDetailedReport.do");

	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
	}
	
	public void clickCSV_Download() {
		CSVDownload.click();
	}
	
	public void clickPDF_Download() {
		PDFDownload.click();
	}
	
	
	public void clickResetButton() {
		ResetButton.click();
	}
	
	
    public void SelectRandomDropdownFieldvalue() {

   	 Select s = new Select(StatusDropdownField);
   	 List<WebElement> options = s.getOptions();
   	 Random rand = new Random();
   	 int randomIndex = rand.nextInt(options.size() - 1) + 1;
   	 s.selectByIndex(randomIndex);
    }
    
    public void SelectCardNumberDropdownField() {

   	 Select s = new Select(CardNumberDropdownField);
   	 List<WebElement> options = s.getOptions();
   	 Random rand = new Random();
   	 int randomIndex = rand.nextInt(options.size() - 1) + 1;
   	 s.selectByIndex(randomIndex);
    }

	

}

