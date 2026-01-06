package individualPages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.Base;

public class CustTransactionSummary extends Base {
	
	String BaseUrl = prop.getProperty("custUrl");
		
	@FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
	private WebElement DashboardMenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='Transaction Summary']")
	private WebElement TransactionSummaryMenu;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-csv buttons-html5']")
	private WebElement CSV_Download;
	
	@FindBy(xpath = "//button[@class='dt-button buttons-pdf buttons-html5']")
	private WebElement PDF_Download;
	
	@FindBy(id ="search")
	private WebElement searchFilterBtn;
	
	@FindBy(id ="flatpickr")
	private WebElement dateFieldLocator;

	public CustTransactionSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		DashboardMenu.click();
		TransactionSummaryMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"transactiondetails.do");
	}
	
	public void clickCSV_Download() {
		CSV_Download.click();
	}
	
	public void clickPDF_Download() {
		PDF_Download.click();
	}
	
	public void chooseFilterDateAndSearch() {
		selectTodayAndPreviousMonthDate(dateFieldLocator);
		searchFilterBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"Searchtransactiondetails.do");

	}
	
/*	public void selectTodayAndPreviousMonthDate() {
		
		dateFieldLocator.click();


	    // Get today's date
	    LocalDate today = LocalDate.now();
	    int todayDay = today.getDayOfMonth();

	    // Select today's date
	    String todayXpath = "//span[contains(@class,'flatpickr-day') and text()='" + todayDay + "']";
	    driver.findElement(By.xpath(todayXpath)).click();

	    // Reopen date picker
	 //   waitForElement(dateFieldLocator).click();

	    // Go to previous month
	    driver.findElement(By.cssSelector(".flatpickr-prev-month")).click();

	    // Calculate previous month date
	    LocalDate previousMonthDate = today.minusMonths(1);
	    int previousDay = previousMonthDate.getDayOfMonth();

	    // Try selecting same day in previous month
	    String prevDayXpath = "//span[contains(@class,'flatpickr-day') and text()='" + previousDay + "']";

	    List<WebElement> prevDayList = driver.findElements(By.xpath(prevDayXpath));

	    // Handle missing dates (e.g., 31st not available)
	    if (!prevDayList.isEmpty()) {
	        prevDayList.get(0).click();
	    } else {
	        // Select last available date in calendar
	        String lastDayXpath = "(//span[contains(@class,'flatpickr-day') and not(contains(@class,'disabled'))])[last()]";
	        driver.findElement(By.xpath(lastDayXpath)).click();
	    }
	    
	   searchFilterBtn.click();
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Assert.assertEquals(driver.getCurrentUrl(), BaseUrl+"Searchtransactiondetails.do");

	}
*/
	
}
