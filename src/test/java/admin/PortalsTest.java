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
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


public class PortalsTest {
    
    private static WebDriver driver; 
    
    public PortalsTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/Asus/Desktop/home-workspace/chromedriver.exe");  
        driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, 0);
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
       
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login"); 
       LoginPage loginPage = new LoginPage(driver);
       loginPage.enterEmail("");
       loginPage.enterPassword("");
       loginPage.clickOnLoginButton();
    }
    
    @After
    public void tearDown() {
        logout();
    }
    
    
    private void logout () {
        WebElement navDropDown = driver.findElement(By.linkText("Cubes QA"));
        navDropDown.click();

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }

    
    // 1. Login - without parameters, if can't login try with invalid, if can't login try with valid 
    // 2. Open Portals section
    // 3. Add New Portal Title
    // 4. Edit Last Added Portal Title - try without parameters, if can't try with valid.
    // 5. Delete Last Added Portal Title
    // 6. Logout
  
    
    //private void login () {
     //   WebElement emailField = driver.findElement(By.name("email"));
     //   emailField.sendKeys("qa@cubes.rs");

     //   WebElement passwordField = driver.findElement(By.name("password"));
     //   passwordField.sendKeys("cubesqa");

     //   WebElement loginButton = driver.findElement(By.className("btn-primary"));
     //   loginButton.click();
    //}
    
    
    
    @Test
    public void hello() {}
}
