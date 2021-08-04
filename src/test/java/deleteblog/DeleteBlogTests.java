package deleteblog;

import org.junit.jupiter.api.Test;

import pages.AdminPage;
import pages.BlogCreatorWindow;
import testbase.TestBase;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

public class DeleteBlogTests extends TestBase {
	
	@Test
	public void deleteBlog_CheckIfVanishedFromAdminPage() {
		AdminPage adminPage = doLogin("admin", "fradi1899");
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "This is just a test", "this-is-just-a-test", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		adminPage.deleteFirstBlog();
		assertFalse(adminPage.isTitlePresent());
		doLogout(adminPage);
	}
	
	@Test
	public void deleteBlog_CheckIfBlog_s_PageDeleted() throws IOException {
		AdminPage adminPage = doLogin("admin", "fradi1899");
		BlogCreatorWindow blogCreatorWindow = adminPage.clickCreateNewBlogBtn();
		createBlog("BlogTest", "This is just a test", "this-is-just-a-test", "\\src\\test\\resources\\testfiles\\halo360.jpg", "This is just a test with a little bit more text.", blogCreatorWindow);
		adminPage.deleteFirstBlog();
		assertTrue(Utils.getPageResponse(url + "/this-is-just-a-test.html")  >= 400);
		doLogout(adminPage);
	}

}
