package login;

import pages.AdminPage;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
	
	@Test
	public void successfulLogin() {
		AdminPage adminPage = doLogin();
		assertTrue(adminPage.isLogoutBtnPresent());
		doLogout(adminPage);
	}
	
	@Test
	public void unSuccessfulLogin() {
		doLogin("admin", "fradi1900");
		assertTrue(homePage.isLoginErrorMsgPresent());
	}

}
