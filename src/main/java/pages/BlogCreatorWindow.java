package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogCreatorWindow {
	
	private WebDriver driver;
	private final By BLOG_TITLE_INPUT = By.id("blogTitle");
	private final By BLOG_DESCRIPTION_INPUT = By.id("blogDesc");
	private final By BLOG_URL_INPUT = By.id("blogUrl");
	private final By BLOG_UPLOAD_IMAGE_INPUT = By.id("blogMainImg");
	private final By BLOG_TEXT_EDITOR_IFRAME = By.xpath("//iFrame[@aria-describedby='cke_55']");
	private final By BLOG_TEXT_EDITOR_INPUT = By.xpath("//body[@contenteditable]/p");
	private final By SAVE_BLOG_BUTTON = By.xpath("/html/body/div[4]/div/button[1]");
	private final By CLOSE_BLOG_EDITOR_BUTTON = By.xpath("//div[4]/div/button[2]");
	private final By URL_TAKEN_MSG = By.id("alertBlogUrl");
	private final By THERE_ARE_BLANK_FIELDS_MSG = By.id("alertBlog");
	
	public void clickTitleInput() {
		driver.findElement(BLOG_TITLE_INPUT).click();
	}
	
	public void TypeTitleInput(String value) {
		driver.findElement(BLOG_TITLE_INPUT).sendKeys(value);
	}
	
	public void clickDescriptionInput() {
		driver.findElement(BLOG_DESCRIPTION_INPUT).click();
	}
	
	public void TypeDescriptionInput(String value) {
		driver.findElement(BLOG_DESCRIPTION_INPUT).sendKeys(value);
	}
	
	public void clickUrlInput() {
		driver.findElement(BLOG_URL_INPUT).click();
	}
	
	public void TypeUrlInput(String value) {
		driver.findElement(BLOG_URL_INPUT).sendKeys(value);
	}
	
	public void UploadWithUploadImageInput(String value) {
		driver.findElement(BLOG_UPLOAD_IMAGE_INPUT).sendKeys(value);
	}
	
	public void switchToTextEditorIFrame() {
		driver.switchTo().frame(driver.findElement(BLOG_TEXT_EDITOR_IFRAME));
	}
	
	public void clickBlogTextEditorInput() {
		driver.findElement(BLOG_TEXT_EDITOR_INPUT).click();
	}
	
	public void TypeBlogTextEditorInput(String value) {
		driver.findElement(BLOG_TEXT_EDITOR_INPUT).sendKeys(value);
	}
	
	public void switchBackFromIFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void clickSaveBlogButton() {
		driver.findElement(SAVE_BLOG_BUTTON).click();
	}
	
	public void clickCloseBlogEditorButton() {
		driver.findElement(CLOSE_BLOG_EDITOR_BUTTON).click();
	}
	
	public boolean isUrlTakenMsgDisplayed() {
		return driver.findElement(URL_TAKEN_MSG).isDisplayed();
	}
	
	public boolean isThereAreBlankFieldsMsgDisplayed() {
		return driver.findElement(THERE_ARE_BLANK_FIELDS_MSG).isDisplayed();
	}
	
	public BlogCreatorWindow(WebDriver driver) {
        this.driver = driver;
    }

}
