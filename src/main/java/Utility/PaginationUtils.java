package Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.Base;

public class PaginationUtils extends Base{

    private WebDriverWait wait;

    // ====== Locators ======
    private By tableRows = By.xpath("//table[@id='example']/tbody/tr");

    private By firstBtn = By.xpath("//a[contains(@class,'paginate_button') and contains(@id,'first')]");
    private By prevBtn  = By.xpath("//a[contains(@class,'paginate_button') and contains(@id,'previous')]");
    private By nextBtn  = By.xpath("//a[contains(@class,'paginate_button') and contains(@id,'next')]");
    private By lastBtn  = By.xpath("//a[contains(@class,'paginate_button') and contains(@id,'last')]");

    // ====== Constructor ======
    public PaginationUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ====== Wait for table refresh ======
    public void waitForTableRefresh(List<WebElement> oldRows) {
        if (!oldRows.isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(oldRows.get(0)));
        }
    }

    // ====== Click pagination until disabled ======
    public void clickPagination(String type) {

        By button;

        switch (type.toLowerCase()) {
            case "first":
                button = firstBtn;
                break;
            case "previous":
                button = prevBtn;
                break;
            case "next":
                button = nextBtn;
                break;
            case "last":
                button = lastBtn;
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid pagination type. Use: first / previous / next / last"
                );
        }
        
        while (true) {

            WebElement btn = driver.findElement(button);

            // Stop when button is disabled
            if (btn.getAttribute("class").contains("disabled")) {
                System.out.println(type + " button is disabled. Pagination stopped.");
                break;
            }

            List<WebElement> rows = driver.findElements(tableRows);

            btn.click();
      //      waitForTableRefresh(rows);
        }
    }

    // ====== Get current page info text ======
    public String getPageInfoText() {
        return driver.findElement(By.id("example_info")).getText();
    }

    // ====== Get row count in current page ======
    public int getCurrentPageRowCount() {
        return driver.findElements(tableRows).size();
    }
    
    public void clickPagination(String type,int position) {

        By button;

        switch (type.toLowerCase()) {
            case "first":
                button = firstBtn;
                break;
            case "previous":
                button = prevBtn;
                break;
            case "next":
                button = nextBtn;
                break;
            case "last":
                button = lastBtn;
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid pagination type. Use: first / previous / next / last"
                );
        }
        
        while (true) {

            WebElement btn = driver.findElements(button).get(position);

            // Stop when button is disabled
            if (btn.getAttribute("class").contains("disabled")) {
                System.out.println(type + " button is disabled. Pagination stopped.");
                break;
            }

 //           List<WebElement> rows = driver.findElements(tableRows);

            btn.click();
       //     waitForTableRefresh(rows);
        }
    }
    
    
}
