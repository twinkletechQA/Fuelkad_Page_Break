package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Base;

public class AdminPageBreak extends Base {

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li/a")
	private static List<WebElement> NAVLINK_MainMenus;
	
	
	
	 // All Main Menu Links
    @FindBy(xpath = "//*[@id='navbarsExample03']/ul/li/a")
    public List<WebElement> mainMenus;

    // All Submenu Containers (divs)
    @FindBy(xpath = "//*[@id='navbarsExample03']/ul/li/div")
    public List<WebElement> submenuContainers;

    // All submenu links (optional if you want all together)
    @FindBy(xpath = "//*[@id='navbarsExample03']/ul/li/div/a")
    public List<WebElement> allSubMenus;
    
    

	static WebDriver driver;
	static List<String> values = new ArrayList<>();

	public AdminPageBreak(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private static void getNAVLINK_DASHBOARD() {
		Actions a = new Actions(driver);
	}

	public void termsAndConditions() {
		driver.findElement(By.xpath("/html/body/div[10]/div[1]/button")).click();

	}

	public void AdmincheckBreak() {

 		System.out.println(NAVLINK_MainMenus.size());

		for (int i = 1; i <= NAVLINK_MainMenus.size(); i++) {

			// System.out.println(moduleTitleName);

			List<WebElement> NAVLINK_SubMenus = driver
					.findElements(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[" + i + "]/div/a"));

			int submenusize;

			submenusize = NAVLINK_SubMenus.size();

			System.out.println(submenusize);

			for (int j = 1; j <= submenusize; j++) {

				WebElement mainModule = driver
						.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[" + i + "]/a"));

				Actions a = new Actions(driver);
				a.click(mainModule).build().perform();

				WebElement NAVLINK_MainMenus = driver
						.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[" + i + "]/div/a[" + j + "]"));
				String moduleTitleName = NAVLINK_MainMenus.getText();
				a.click(NAVLINK_MainMenus).build().perform();

				verifyLink(driver.getCurrentUrl());

				List<WebElement> findElements = driver
						.findElements(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[" + i + "]/div/a"));

				verifyLink(driver.getCurrentUrl());

				submenusize = findElements.size();
				System.out.println("--->" + submenusize);

				List<WebElement> ttt = driver.findElements(By.xpath("//a[@href]"));

				for (WebElement webElement123 : ttt) {
					String attribute123 = webElement123.getAttribute("href");
					verifyLink(attribute123, moduleTitleName);
					String verifyLink = verifyLink(attribute123, moduleTitleName);
					values.add(verifyLink);
				}

			}

		}

		Set<String> uniqueValues = new HashSet<>(values);
		for (String uniqueValue : uniqueValues) {
			System.out.println(uniqueValue);
		}
/*
		
		for (int i = 0; i < mainMenus.size(); i++) {
	        WebElement mainMenu = mainMenus.get(i);

	        Actions actions = new Actions(driver);
	        actions.moveToElement(mainMenu).click().perform();

	        // Now get submenu items inside this main menu
	        List<WebElement> subMenus = submenuContainers.get(i)
	                .findElements(By.tagName("a"));

	        System.out.println("Submenu count: " + subMenus.size());

	        for (WebElement subMenu : subMenus) {
	            String moduleTitleName = subMenu.getText();
	            System.out.println(moduleTitleName);
	            subMenu.click();

	            verifyLink(driver.getCurrentUrl());

	            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
	            for (WebElement link : links) {
	                String href = link.getAttribute("href");
	                String result = verifyLink(href, moduleTitleName);
	                values.add(result);
	            }

	            // Go back to main page before next iteration
	            driver.navigate().back();
	        }
	    }

	    // Remove duplicates and print results
	    Set<String> uniqueValues = new HashSet<>(values);
	    for (String uniqueValue : uniqueValues) {
	        System.out.println(uniqueValue);
	    }
*/	    
		
	}

	public static String verifyLink(String url, String ModuleName) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200) {
				// System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				// System.err.println(ModuleName + " - " + url + " - " +
				// httpURLConnection.getResponseMessage() + " - "+ "is a broken link");
				String s = url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link";

				return s;
				// driver.navigate().back();
			}
		} catch (Exception e) {
			// System.err.println(url + " - " + "is a broken link");

		}
		String s = null;
		return s;

	}

	private String verifyLink(String url) {

		

		return url;

	}

	public void checkSingleModule() {
		driver.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[2]")).click();
		int size = driver.findElements(By.xpath("//button")).size();

		for (int i = 2; i <= size; i++) {
			driver.findElement(By.xpath("(//button)[" + i + "]")).click();
		}

	}

}
