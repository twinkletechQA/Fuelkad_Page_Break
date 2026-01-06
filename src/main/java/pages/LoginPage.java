package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class LoginPage extends Base {

	WebDriver driver;

	@FindBy(how = How.ID, using = "email")
	static WebElement emailAddressField;

	@FindBy(how = How.ID, using = "password")
	static WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	static WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//span[@id='UserName-error']")
	static WebElement emailAddressFieldWarning;

	@FindBy(how = How.XPATH, using = "//span[@id='Password-error']")
	static WebElement passwordFieldWarning;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/div[3]")
	static WebElement emailPasswordNotMatchingWarning;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String emailText, String passwordText) {

		System.out.println("Field Va;lue ois" + emailText);

		if (emailText == null || emailText.isEmpty()) {
			emailAddressField.sendKeys("");
		} else {
			emailAddressField.sendKeys(emailText);
		}

		if (passwordText == null || passwordText.isEmpty()) {
			passwordField.sendKeys("");
		} else {
			passwordField.sendKeys(passwordText);
		}

		loginButton.click();

	}

	public void clearText() {

		emailAddressField.clear();
		passwordField.clear();
	}

	public String usernameValidationMsg() {
		String text = emailAddressFieldWarning.getText();
		return text;
	}

	public String passwordValidationMsg() {
		String text = passwordFieldWarning.getText();
		return text;
	}

	public String usernameFieldLength() {

		String userFieldLength = emailAddressField.getAttribute("maxlength");
		return userFieldLength;
	}

	public String passwordFieldLength() {

		String passFieldLength = passwordField.getAttribute("maxlength");
		return passFieldLength;
	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {

		String text = emailPasswordNotMatchingWarning.getText();
		System.out.println(text);
		return text;

	}

}
