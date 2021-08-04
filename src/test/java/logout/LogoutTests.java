package logout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.AdminPage;
import testbase.TestBase;
import utils.Utils;

public class LogoutTests extends TestBase {
	
	@Test
	public void logOut() {
		AdminPage adminPage = doLogin();
		doLogout(adminPage);
		Assertions.assertEquals(url + "/login.php" ,getDriver().getCurrentUrl());
	}
	
	@Test
	public void afterLogoutTryGoBackToPreviusPage() {
		AdminPage adminPage = doLogin();
		doLogout(adminPage);
		Utils.goBack(getDriver());
		Assertions.assertEquals(url + "/login.php" ,getDriver().getCurrentUrl());
	}

}
