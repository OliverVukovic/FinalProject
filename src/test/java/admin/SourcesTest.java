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


public class SourcesTest {
    
    private static WebDriver driver; 
    
    public SourcesTest() {
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
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login"); 
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");                                    
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        WebElement navPortals = driver.findElement(By.linkText("Portals"));
        navPortals.click();
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
    
    
    
    // @Test
    // public void hello() {}
}
