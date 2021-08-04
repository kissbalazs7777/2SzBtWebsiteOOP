package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Utils;

public class AdminPage {
	
	private WebDriver driver;
	private final By LOGOUT_BUTTON = By.xpath("//*[@id=\"logout-btn\"]");
	private final By CREATE_NEW_BLOG_BTN = By.xpath("//div[3]/div/button[2]");
	private final By CONTINUE_READ_ARROW = By.xpath("//i[@class='fa fa-arrow-right']");
	private final By EDIT_BLOG_BUTTON = By.id("edit-blogthis-is-just-a-test");
	private final By FIRST_BLOG_DELETE_BUTTON = By.className("delete-blog");
	private final By CREATED_BLOG_TITLE = By.xpath("//p[@id='this-is-just-a-testblogtitle'][text()='BlogTest']");
	
	public void clickLogoutButton() {
		driver.findElement(LOGOUT_BUTTON).click();
	}
	
	public BlogCreatorWindow clickCreateNewBlogBtn() {
		driver.findElement(CREATE_NEW_BLOG_BTN).click();
		return new BlogCreatorWindow(driver);
	}
	
	public void clickContinueReadArrow() {
		driver.findElement(CONTINUE_READ_ARROW).click();
	}
	
	public BlogEditorWindow clickEditBlogButton() {
		driver.findElement(EDIT_BLOG_BUTTON).click();
		return new BlogEditorWindow(driver);
	}
	
	public void clickFirstDeleteButton() {
		driver.findElement(FIRST_BLOG_DELETE_BUTTON).click();
	}
	
	public By getCONTINUE_READ_ARROW() {
        return CONTINUE_READ_ARROW;
    }
	
	public boolean isTitlePresent() {
		try {
			driver.findElement(CREATED_BLOG_TITLE);
			return true;
		}catch(Exception ignored) {
			
		}
		return false;
	}
	
	public boolean isLogoutBtnPresent() {
		try {
			driver.findElement(LOGOUT_BUTTON);
			return true;
		}catch(Exception ignored) {
			
		}
		return false;
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void deleteFirstBlog() {
		Utils.scrollDown(CONTINUE_READ_ARROW, driver);
		clickFirstDeleteButton();
		acceptAlert();
	}
	
	public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

}
