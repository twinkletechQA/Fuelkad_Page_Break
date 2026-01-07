package baseclass;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Base {

	public SoftAssert softAssert;
	public WebDriver driver;
	public static Properties prop;
	public static Properties dataProp;
	public static Properties urlProp;
	public static Properties titleName;

	public Base() {
		softAssert = new SoftAssert();
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\Vignesh\\eclipse-workspace\\Fuelkad_Project_Page_Break\\Drivers\\chromedriver.exe");
//test
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.default_directory", "D:\\Vignesh_R\\TSS Projects\\Automation download files"); // Set
																												// download
																												// directory
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);

			options.setExperimentalOption("prefs", prefs);
			
			// New Check Screen resolution
//			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//	        GraphicsDevice[] gs = ge.getScreenDevices();
//
//	        for (GraphicsDevice device : gs) {
//	            Rectangle bounds = device.getDefaultConfiguration().getBounds();
//	            System.out.println("Monitor: " + device.getIDstring() + "  Bounds = " + bounds);
//	        }
	        //
	        
	     // Move Chrome to second monitor
	        driver.manage().window().setPosition(new Point(-1920, -304));

	    // Optional: Resize as needed
	        driver.manage().window().setSize(new Dimension(1200, 900));
	        

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));

		return driver;

	}

	public void clickFunction(WebElement element) {

		element.click();

	}

	public String getText(WebElement elementtxt) {

		String txt = elementtxt.getText();
		return txt;

	}

	public void selectVisibleText(WebElement elementtxt, String value) {

		Select s = new Select(elementtxt);
		s.selectByVisibleText(value);

	}

	public void selectByIndex(WebElement elementtxt, int value) {

		Select s = new Select(elementtxt);
		s.selectByIndex(value);

	}

	public void selectByValue(WebElement elementtxt, String value) {

		Select s = new Select(elementtxt);
		s.selectByValue(value);

	}

	public static String compareText(String key) {
		String property = titleName.getProperty(key);

		return property;

	}

	public String checkURL(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		String[] split = currentUrl.split("/");
		String string = split[split.length - 1];
		return string;
	}

	public void clickElementWithJSExecuiter(WebDriver driver, WebElement elementToClick) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elementToClick);
	}

	public String dateAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	public WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForVisibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectTodayAndPreviousMonthDate(WebElement dateField) {

		dateField.click();

		// Get today's date
		LocalDate today = LocalDate.now();
		int todayDay = today.getDayOfMonth();

		// Select today's date
		String todayXpath = "//span[contains(@class,'flatpickr-day') and text()='" + todayDay + "']";
		driver.findElement(By.xpath(todayXpath)).click();

		// Reopen date picker
		// waitForElement(dateFieldLocator).click();

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

	}
	
	public String getBaseURL() 
	
	{
		return prop.getProperty("custUrl");
	}
	
	public void SelectRandomDropdownFieldvalue(WebElement dropdownField) {
		 
/*	   	 Select s = new Select(dropdownField);
	   	 List<WebElement> options = s.getOptions();
	   	 Random rand = new Random();
	   	 int randomIndex = rand.nextInt(options.size() - 1) + 1;
	   	 s.selectByIndex(randomIndex);
 Note : Hided by Vignesh for Sometimes breaking the flow while 0 size came
 */
		 Select select = new Select(dropdownField);
		    List<WebElement> options = select.getOptions();

		    if (options.size() == 0) {
		        System.out.println("Dropdown has no options");
		        return;
		    }

		    // If only one option → select it
		    if (options.size() == 1) {
		        select.selectByIndex(0);
		        System.out.println("Only one option found, selected index 0");
		        return;
		    }

		    // If multiple options → select random (excluding default index 0)
		    Random random = new Random();
		    int randomIndex = random.nextInt(options.size() - 1) + 1;

		    select.selectByIndex(randomIndex);
		    System.out.println("Random option selected: index " + randomIndex);
		
	}
	
	protected void verifyUrlIsEqual(String expectedUrl) {

	    String actualUrl = driver.getCurrentUrl();

	    if (!actualUrl.equals(expectedUrl)) {
	        System.out.println("URL MISMATCH DETECTED" +"EXPECTED URL:"+ expectedUrl +"ACTUAL URL:"+ actualUrl);
	       
	    }

	    softAssert.assertEquals(
	            actualUrl,
	            expectedUrl
	    );
	}

}
