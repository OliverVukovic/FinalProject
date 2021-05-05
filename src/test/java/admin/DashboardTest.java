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
import pages.LogoutPage;


public class DashboardTest {
    
    private static WebDriver driver; 
    
    public DashboardTest() {
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");                                    // objekat
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
    }
    
    @After
    public void tearDown() {
        LogoutPage logoutPage = new LogoutPage(driver);                           
        logoutPage.clickOnNavDropDown();   
        logoutPage.clickOnLogoutButton();  
    }

    // TODO add test methods here:
    
    @Test
    public void checkDashboardLinks() {
                
        WebElement navSignatures = driver.findElement(By.linkText("Signatures"));
        navSignatures.click();
        
        String expectedSignaturesUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualSignaturesUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, Signatures URL redirection is wrong!", expectedSignaturesUrl.equals(actualSignaturesUrl));
        
        
        WebElement navCategories = driver.findElement(By.linkText("Categories"));
        navCategories.click();
        
        String expectedCategoriesUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualCategoriesUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, Categories URL redirection is wrong!", expectedCategoriesUrl.equals(actualCategoriesUrl));
        
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        String expectedRegionsUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualRegionsUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, Regions URL redirection is wrong!", expectedRegionsUrl.equals(actualRegionsUrl));
        
        
        WebElement navPortals = driver.findElement(By.linkText("Portals"));
        navPortals.click();
        
        String expectedPortalsUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualPortalsUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, Portals URL redirection is wrong!", expectedPortalsUrl.equals(actualPortalsUrl));
        
        
        WebElement navSource = driver.findElement(By.linkText("Sources"));
        navSource.click();
        
        String expectedSourcesUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualSourcesUrl = driver.getCurrentUrl();
        
        assertTrue("Olivere, Sources URL redirection is wrong!", expectedSourcesUrl.equals(actualSourcesUrl));
    }
    
    
}
