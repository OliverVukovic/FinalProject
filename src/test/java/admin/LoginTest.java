package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginTest {
    
    private static WebDriver driver; 
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/Asus/Desktop/home-workspace/chromedriver.exe");  
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login"); 
    }
    
    @After
    public void tearDown() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:

    
    
    
    
    
    @Test
    public void testEmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();        
    }
    
    @Test
    public void testInvalidParametersLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("oliver@cubes.rs");
        loginPage.enterPassword("1234");
        loginPage.clickOnLoginButton();
    }
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
    }


}

