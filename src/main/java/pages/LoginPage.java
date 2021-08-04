package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private final By EMAIL_INPUT = By.xpath("//*[@id='email-login-form']");
	private final By PW_INPUT = By.xpath("//*[@id='password-login-form']");
	private final By LOGIN_BUTTON = By.xpath("//*[@id='login-btn']");
	private final By LOGIN_ERROR_MSG = By.xpath("//p");
	
	public void clickEmailInput() {
		driver.findElement(EMAIL_INPUT).click();
	}
	
	public void typeEmailInput(String email) {
		driver.findElement(EMAIL_INPUT).sendKeys(email);;
	}
	
	public void clickPwInput() {
		driver.findElement(PW_INPUT).click();
	}
	
	public void typePwInput(String pw) {
		driver.findElement(PW_INPUT).sendKeys(pw);
	}
	
	public AdminPage clickLoginButton() {
		driver.findElement(LOGIN_BUTTON).click();
		return new AdminPage(driver);
	}
	
	public boolean isLoginErrorMsgPresent() {
		try {
			driver.findElement(LOGIN_ERROR_MSG);
			return true;
		}catch(Exception ignored) {
			
		}
		return false;
	}
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

}
