package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        driver.quit();
    }
       
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login"); 
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");                                                // objekat
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

    // 1. Login (precondition)
    // 2. Open Portals section
    // 3. Add New Portal Title
    // 4. Save new Portal Title
    // 5. Logout
     
    
    //private void login () {
     //   WebElement emailField = driver.findElement(By.name("email"));
     //   emailField.sendKeys("qa@cubes.rs");

     //   WebElement passwordField = driver.findElement(By.name("password"));
     //   passwordField.sendKeys("cubesqa");

     //   WebElement loginButton = driver.findElement(By.className("btn-primary"));
     //   loginButton.click();
    //}
    
    
    
    @Test
    public void testInsertNewPortalName() {
                 
        WebElement addPortalButton = driver.findElement(By.className("pull-right"));
        addPortalButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        String newPortalTitle = "Srpska TV";
        titleField.sendKeys("Srpska TV");
        
        WebElement urlField = driver.findElement(By.id("url"));
        urlField.sendKeys("https://srpskatelevizija.com");
        
        WebElement regionField = driver.findElement(By.className("form-control"));
        regionField.click();
        WebElement regionFieldName = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[5]"));
        regionFieldName.click();
        
        WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
        savePortalButton.click();
        
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();
            
    }
    
    // 1. Login (precondition)
    // 2. Open Portals section
    // 3. Edit Last Added Portal Title - try without parameters, if can't try with valid.
    // 4. Save new Portal Title
    // 5. Delete Last Added Portal Title
    // 6. Logout (postcondition)
    
    
    @Test
    public void testEditAndDeleteLastAddedPortalName() {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,30000)");
                 
        WebElement editPortalIcon = driver.findElement(By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[39]/td[5]/div/a/span"));
        editPortalIcon.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        driver.findElement(By.xpath("//*[@id=\"title\"]")).clear();
        //driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Srpska Televizija");
        
        String newPortalTitle = "Srpska Televizija";
        titleField.sendKeys("Srpska Televizija");
        
        WebElement urlField = driver.findElement(By.id("url"));
        urlField.sendKeys("https://srpskatelevizija.com");
        
        WebElement regionField = driver.findElement(By.className("form-control"));
        regionField.click();
        WebElement regionFieldName = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/fieldset/div[3]/div/select/option[5]"));
        regionFieldName.click();
        
        WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
        savePortalButton.click();
        
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();
        
        
            
    }
  
        
        
        
    
    
    
    
}
