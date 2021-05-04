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
        //loginPage.enterEmail("");                                                // "loginPage" je objekat
        //loginPage.enterPassword("");                                             // email i password bespotrebni
        loginPage.clickOnLoginButton();                                        
   
        String expectedAlertEmailMessage = "The email field is required.";   
        String actualAlertEmailMessage = driver.findElement(By.className("help-block")).getText();
        
        assertTrue("Olivere, konjino jedna, alert Email message isn't good!", expectedAlertEmailMessage.equals(actualAlertEmailMessage));
        
        String expectedAlertPasswordMessage = "The password field is required.";   
        String actualAlertPasswordMessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong")).getText();
        
        assertTrue("Olivere, konjino jedna glupa, alert Password message isn't good!", expectedAlertPasswordMessage.equals(actualAlertPasswordMessage));
    }
    
    
    @Test
    public void testInvalidParametersLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("oliver@cubes.rs");
        loginPage.enterPassword("1234");
        loginPage.clickOnLoginButton();      
        
        String expectedAlertMessage = "These credentials do not match our records.";   
        String actualAlertMessage = driver.findElement(By.className("help-block")).getText();
        
        assertTrue("Olivere, alert message isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    }
    
    
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, URL redirection is wrong!", expectedUrl.equals(actualUrl));
                
        logout();
    }


}

