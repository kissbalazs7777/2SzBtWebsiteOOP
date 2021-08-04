package createblog;

import org.junit.jupiter.api.Test;

import pages.AdminPage;
import pages.BlogCreatorWindow;
import testbase.TestBase;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateBlogTests extends TestBase {
	
	@Test
	public void createBlogSuccess() {
		AdminPage adminPage = doLogin();
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "This is just a test", "this-is-just-a-test", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		Utils.scrollDown(adminPage.getCONTINUE_READ_ARROW(), getDriver());
		assertTrue(adminPage.isTitlePresent());
		doLogout(adminPage);
	}
	
	@Test
	public void createBlogLeavingBlankField() {
		AdminPage adminPage = doLogin();
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "", "this-is-just-a-test", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		assertTrue(blogCreatorWindow.isThereAreBlankFieldsMsgDisplayed());
		blogCreatorWindow.clickCloseBlogEditorButton();
		doLogout(adminPage);
	}
	
	@Test
	public void createBlogUrlAlreadyTaken() {
		AdminPage adminPage = doLogin();
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "This is just a test", "lakasfelujitas-tippek", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		assertTrue(blogCreatorWindow.isUrlTakenMsgDisplayed());
		blogCreatorWindow.clickCloseBlogEditorButton();
		doLogout(adminPage);
	}
	
	

}
