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


public class RegionsTest {
    
    private static WebDriver driver; 
    
    public RegionsTest() {
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
        loginPage.enterEmail("qa@cubes.rs");                                    
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
    }
    
    @After
    public void tearDown() {
        LogoutPage logoutPage = new LogoutPage(driver);                             // logout();
        logoutPage.clickOnNavDropDown();   
        logoutPage.clickOnLogoutButton(); 
    }

    //1. Click "Regions" link in Navigation bar
    //2. After redirection on new page, find "+ Add region" button in the upper right corner
    //3. Click on the "+ Add region" button
    //4. After redirection enter valid RegionTitle name in Region Title field
    //5. Click on green "Save" button
    //6. Click "Portals" link in Navigation bar
    //7. After redirection on new page, find "+ Add portal" button in the upper right corner
    //8. Click on the "+ Add portal" button
    //9. Find Region drop-down field and click on
    //10. Find valid Region name and click on

    @Test
    public void testCheckAddedRegionInPortalsAddedPage() {
        
        WebElement addRegionButton = driver.findElement(By.linkText("Add region"));
        addRegionButton.click();
        
        WebElement regionsTitleField = driver.findElement(By.id("title"));
        String newRegionsTitle = "Oliver-12345";
        regionsTitleField.sendKeys(newRegionsTitle); 
        
        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
        saveRegionButton.click();
        
        WebElement navPortals = driver.findElement(By.linkText("Portals"));
        navPortals.click();
        
        WebElement addPortalButton = driver.findElement(By.className("pull-right"));
        addPortalButton.click();
        
        WebElement regionField = driver.findElement(By.className("form-control"));
        regionField.click();
        WebElement regionFieldName = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[5]"));
        regionFieldName.click();
    }
    
    
}
