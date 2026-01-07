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

public class CustSummaryReport extends Base{
	
	String BaseUrl = prop.getProperty("custUrl");
	
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/a")
	private WebElement ReportingDashboard;
	
	@FindBy (xpath = "//*[@id=\"navbarsExample03\"]/ul/li[4]/div/a[2]")
	private WebElement SummaryReportMenu;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;
	
	@FindBy(id ="search")
	private WebElement searchFilterBtn;
	
	@FindBy (xpath = "//*[@id=\"search\"]/b")
	private WebElement SearchButton;		
	
	@FindBy (xpath = "//*[@id=\"example_wrapper\"]/div[1]/button[1]/span")
	private WebElement CSVDownload;
	
	@FindBy (id = "search")
	private WebElement PDFDownload;
	
	
	@FindBy (id = "status")
	private WebElement StatusDropdownField;
	
	@FindBy (xpath = "//*[@id=\"search\"]/b")
	private WebElement ResetButton;
	
	public CustSummaryReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		
		waitForElement(ReportingDashboard).click();
		waitForElement(SummaryReportMenu).click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SummaryReport.do");
		
	}
	
	public void ClickSearchButton() {
		SearchButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"SearchSummaryDetails.do");

	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		SelectRandomDropdownFieldvalue();
		
	}
	
	public void clickCSV_Download() {
		CSVDownload.click();
	}
	
	public void clickPDF_Download() {
		PDFDownload.click();
	}
	
	
	public void ClickResetButton() {
		ResetButton.click();
	}
	
     public void SelectRandomDropdownFieldvalue() {

    	 Select s = new Select(StatusDropdownField);
    	 List<WebElement> options = s.getOptions();
    	 Random rand = new Random();
    	 int randomIndex = rand.nextInt(options.size() - 1) + 1;
    	 s.selectByIndex(randomIndex);
     }
	

}

	


