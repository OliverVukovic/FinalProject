package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login"); 
    }
    
    @After
    public void tearDown() {
        
    }
    
    private void logout () {
        WebElement navDropDown = driver.findElement(By.linkText("Cubes QA"));
        navDropDown.click();

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }

    // Login: 
    // 1. without parameters
    // 2. with invalid parameters
    // 3. with valid parameters


    
    @Test
    public void testEmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("");
        loginPage.enterPassword("");
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
        logout();
    }


}

