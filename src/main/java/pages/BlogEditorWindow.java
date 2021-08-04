package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogEditorWindow {
	
	private WebDriver driver;
	private final By BLOG_URL_INPUT = By.id("blogUrl-edit");
	private final By BLOG_UPLOAD_IMAGE_INPUT = By.id("blogMainImg-edit");
	private final By SAVE_BLOG_BUTTON = By.xpath("//button[@onclick='saveBlogEdit()']");
	private final By CLOSE_BLOG_EDITOR_BUTTON = By.xpath("//button[@onclick='blogEditorHiddenEdit()']");
	private final By URL_TAKEN_MSG = By.id("alertBlogUrl-edit");
	private final By THERE_ARE_BLANK_FIELDS_MSG = By.id("alertBlog-edit");
	
	public void clickUrlInput() {
		driver.findElement(BLOG_URL_INPUT).click();
	}
	
	public void TypeUrlInput(String value) {
		driver.findElement(BLOG_URL_INPUT).sendKeys(value);
	}
	
	public void UploadWithUploadImageInput(String value) {
		driver.findElement(BLOG_UPLOAD_IMAGE_INPUT).sendKeys(value);
	}
	
	public void clickSaveBlogButton() {
		driver.findElement(SAVE_BLOG_BUTTON).click();
	}
	
	public void clickCloseBlogEditorButton() {
		driver.findElement(CLOSE_BLOG_EDITOR_BUTTON).click();
	}
	
	public void clearUrlInput() {
		driver.findElement(BLOG_URL_INPUT).clear();
	}
	
	public BlogEditorWindow(WebDriver driver) {
        this.driver = driver;
    }

}
