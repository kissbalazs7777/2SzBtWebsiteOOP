package testbase;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AdminPage;
import pages.BlogCreatorWindow;
import pages.LoginPage;

public class TestBase {
	
	private WebDriver driver;
    protected LoginPage homePage;
    protected String email = "admin";
    protected String pw = "fradi1899";
    protected String url = "https://kissbalazstest.000webhostapp.com";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=hu");
        driver = new ChromeDriver(options);
        driver.get(url + "/login.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new LoginPage(driver);
    }
    
    public AdminPage doLogin(){
    	homePage.clickEmailInput();
    	homePage.typeEmailInput(email);
    	homePage.clickPwInput();
    	homePage.typePwInput(pw);
    	return homePage.clickLoginButton();
    }
    
    public AdminPage doLogin(String email, String pw){
    	homePage.clickEmailInput();
    	homePage.typeEmailInput(email);
    	homePage.clickPwInput();
    	homePage.typePwInput(pw);
    	return homePage.clickLoginButton();
    }
    
    public void doLogout(AdminPage adminPage){
    	driver.get(url + "/admin.php");
		adminPage.clickLogoutButton();
    }
    
    public void createBlog(String title, String desc, String url, String filePath, String text, BlogCreatorWindow blogCreatorWindow){
    	blogCreatorWindow.clickTitleInput();
    	blogCreatorWindow.TypeTitleInput(title);
    	blogCreatorWindow.clickDescriptionInput();
    	blogCreatorWindow.TypeDescriptionInput(desc);
    	blogCreatorWindow.clickUrlInput();
    	blogCreatorWindow.TypeUrlInput(url);
    	blogCreatorWindow.UploadWithUploadImageInput(System.getProperty("user.dir") + filePath);
    	blogCreatorWindow.switchToTextEditorIFrame();
    	blogCreatorWindow.TypeBlogTextEditorInput(text);
    	blogCreatorWindow.switchBackFromIFrame();
    	blogCreatorWindow.clickSaveBlogButton();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
