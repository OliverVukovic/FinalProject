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
        WebElement navPortals = driver.findElement(By.linkText("Sources"));
        navPortals.click();
    }
    
    @After
    public void tearDown() {
        LogoutPage logoutPage = new LogoutPage(driver);                             // logout();
        logoutPage.clickOnNavDropDown();   
        logoutPage.clickOnLogoutButton();  
    }   
    
    
    //1. Click "Sources" in Navigation bar
    //2. After redirection on new page,find "+ Add source" button in the upper right corner
    //3. Click on the "+ Add source" button
    //4. After next redirection click on drop-down sign in Portal field and choose valid portal
    //5. Enter valid name in Title field
    //6. Enter valid URL in Url field
    //7. Click on drop-down sign in Type field and choose valid Type
    //8. Click on drop-down sign in Processor field and choose valid Processor
    //9. Click on drop-down sign in Category field and choose valid Category
    //10. Click on green "Save" button
    
    @Test
    public void testAddNewSource() {
                 
        WebElement addSourceButton = driver.findElement(By.className("pull-right"));
        addSourceButton.click();
        
        WebElement portalFieldDropDown = driver.findElement(By.id("sourcePortalSelect"));    //String newPortalTitle = "Srpska TV";
        portalFieldDropDown.click();
        WebElement portalFieldName = driver.findElement(By.xpath("//*[@id=\"sourcePortalSelect\"]/option[2]"));
        portalFieldName.click();
        
        WebElement titleTextField = driver.findElement(By.id("sourceTitleText"));
        String newSourceTitle = "Srpska Televizija";
        titleTextField.sendKeys("Srpska Televizija");
        
        WebElement urlTextField = driver.findElement(By.id("sourceUrlText"));
        urlTextField.sendKeys("https://srpskatelevizija.com");
        
        WebElement processorFieldDropDown = driver.findElement(By.id("sourceNewsProcessorSelect"));
        processorFieldDropDown.click();
        WebElement processorFieldName = driver.findElement(By.xpath("//*[@id=\"sourceNewsProcessorSelect\"]/option[1]"));
        processorFieldName.click();
        
        WebElement categoryFieldDropDown = driver.findElement(By.id("sourceCategorySelect"));
        categoryFieldDropDown.click();
        WebElement categoryFieldName = driver.findElement(By.xpath("//*[@id=\"sourceCategorySelect\"]/option[14]"));
        categoryFieldName.click();
        
        WebElement saveSourceButton = driver.findElement(By.id("save-source-button"));
        saveSourceButton.click();
        
        String expectedAlertMessage = "Source \"" + newSourceTitle + "\" has been successfully saved!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();     
    }
    
    
    
    
    
    
    
    
}
