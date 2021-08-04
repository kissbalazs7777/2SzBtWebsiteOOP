package editblog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.AdminPage;
import pages.BlogCreatorWindow;
import pages.BlogEditorWindow;
import testbase.TestBase;
import utils.Utils;

public class EditBlogTests extends TestBase {

	@Test
	public void editBlogSuccess() {
		AdminPage adminPage = doLogin();
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "This is just a test", "this-is-just-a-test", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		Utils.scrollDown(adminPage.getCONTINUE_READ_ARROW(), getDriver());
		BlogEditorWindow blogEditorWindow = adminPage.clickEditBlogButton();
		blogEditorWindow.clearUrlInput();
		blogEditorWindow.TypeUrlInput("edited-url");
		blogEditorWindow.UploadWithUploadImageInput(System.getProperty("user.dir") + "\\src\\test\\resources\\testfiles\\halo360.jpg");
		blogEditorWindow.clickSaveBlogButton();
		Utils.scrollDown(adminPage.getCONTINUE_READ_ARROW(), getDriver());
		adminPage.clickContinueReadArrow();
		Assertions.assertEquals(url + "/blog/edited-url.html" ,getDriver().getCurrentUrl());
		Utils.goBack(getDriver());
		adminPage.deleteFirstBlog();
		doLogout(adminPage);
	}
}
