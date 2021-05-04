package admin;

import framework.Helper01;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.LogoutPage;


public class PortalsTest {
    
    private static WebDriver driver; 
 //   private static WebDriverWait wait;

    
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
        loginPage.enterEmail("qa@cubes.rs");                                    // objekat
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        WebElement navPortals = driver.findElement(By.linkText("Portals"));
        navPortals.click();
    }
    
    @After
    public void tearDown() {
        LogoutPage logoutPage = new LogoutPage(driver);                             // logout();
        logoutPage.clickOnNavDropDown();   
        logoutPage.clickOnLogoutButton();  
    }
    
    
    
    
    //private void logout () {
     //   WebElement navDropDown = driver.findElement(By.linkText("Cubes QA"));
     //   navDropDown.click();

     //   WebElement logoutButton = driver.findElement(By.linkText("Logout"));
     //   logoutButton.click();
    //}
    
    //private void login () {
     //   WebElement emailField = driver.findElement(By.name("email"));
     //   emailField.sendKeys("qa@cubes.rs");

     //   WebElement passwordField = driver.findElement(By.name("password"));
     //   passwordField.sendKeys("cubesqa");

     //   WebElement loginButton = driver.findElement(By.className("btn-primary"));
     //   loginButton.click();
    //}
    
    // 1. Login (precondition)
    // 2. Open Portals section (precondition)
    // 3. Add New Portal Title
    // 4. Save new Portal Title
    // 5. Logout
    
    @Test
    public void testInsertNewPortalName() {
                 
        WebElement addPortalButton = driver.findElement(By.className("pull-right"));
        addPortalButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        String newPortalTitle = Helper01.generateTitle();
        titleField.sendKeys(newPortalTitle); 
        
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
        
        assertTrue("Olivere, table alert message (in insert test) isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    }
    
    
    // 1. Login (precondition)
    // 2. Open Portals section (precondition)
    // 3. Edit Last Added Portal Title - try without parameters, if can't try with valid.
    // 4. Save new Portal Title
    // 5. Delete Last Added Portal Title
    // 6. Logout (postcondition)
    
    @Test
    public void testEdit35thPortalWithoutName() {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,30000)");
                 
        WebElement editPortalIcon = driver.findElement(By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[35]/td[5]/div/a/span"));
        editPortalIcon.click();
        
        WebElement portalTitleField = driver.findElement(By.id("title"));
        driver.findElement(By.xpath("//*[@id=\"title\"]")).clear();
        
        WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
        savePortalButton.click();
        
    //    WebElement popUpMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("help-block")));

        
        
        //Alert alert = driver.switchTo().alert();
        
    //    String expectedAlertMessage = "Please fill out this field.";
    //    String actualAlertMessage = popUpMessage.getText();    // - ne radi
                
                //driver.switchTo().alert().getText();         //- pronađi način da dohvatiš popup element
    
        //driver.findElement(By.className("alert-success")).getText(); 
        
    //    assertTrue("Olivere, title field alert message (in edit no name test) isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    
        
        
        
    
    
    }
    
    
    @Test
    public void testEditAddedPortalName() {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,30000)");
                 
        WebElement editPortalIcon = driver.findElement(By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[39]/td[5]/div/a/span"));
        editPortalIcon.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        driver.findElement(By.xpath("//*[@id=\"title\"]")).clear();
        //driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Srpska Televizija"); 
        String newPortalTitle = Helper01.generateTitle();
        titleField.sendKeys(newPortalTitle);      
        
        WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
        savePortalButton.click();
        
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();      
        
        assertTrue("Olivere, table alert message (in edit test) isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    }

    
    // 1. Login (precondition)
    // 2. Open Portals section (precondition)
    // 3. Edit Last Added Portal Title - try without parameters, if can't try with valid.
    // 4. Save new Portal Title
    // 5. Delete Last Added Portal Title
    // 6. Logout (postcondition)    
    
    @Test
    public void testDeleteAddedPortalName() {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,30000)");
        
        String portalTitleName = "Srpska TV";
                 
        WebElement deletePortalIcon = driver.findElement(By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[44]/td[5]/div/button[2]/span"));
        deletePortalIcon.click(); 
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        WebElement deletePortalButton = driver.findElement(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]"));
        deletePortalButton.click();
        
        String expectedAlertMessage = "Portal \"" + portalTitleName + "\" has been successfully deleted!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();       
        
        assertTrue("Olivere, table alert message (in delete test) isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    }        
}
