package admin;

import java.util.concurrent.TimeUnit;
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
    
    
    //1. Click "Sources" in Navigation bar (precondition)
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
        
        assertTrue("Olivere, table alert message isn't good!", expectedAlertMessage.equals(actualAlertMessage));       
    }
    
    
    //Disable last added Source, check it and enable again
    //1. Find user Source in Sources table
    //2. Find "Disable" icon button in Actions column and click on    
    //3. Click on blue "Disable" button in pop-up field
    //4. Find Source status drop-down field, choose "Disabled" and click on
    //5. Find user Source in new table
    //6. Find "Enable" Actions button in Actions column and click on
    //7. Click on blue "Enable" button in pop-up field
    //8. Find Source status drop-down field, choose "Enabled" and click on
    
    @Test
    public void testDisableEnableFirstRowSource() {
    
        WebElement disableIconButton = driver.findElement(By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[8]/div/button[1]/span"));
        disableIconButton.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement disableButton = driver.findElement(By.xpath("//*[@id=\"sourceDisableDialog\"]/div/div/div[3]/button[2]"));
        disableButton.click();
        
        String sourceTitle = "Srpska Televizija";
        String expectedDisableAlertMessage = "Source \"" + sourceTitle + "\" has been disabled";
        String actualDisableAlertMessage = driver.findElement(By.className("alert-success")).getText();   
        
        assertTrue("Olivere, disable alert message isn't good!", expectedDisableAlertMessage.equals(actualDisableAlertMessage)); 
        
        WebElement sourceStatusFieldDropDown = driver.findElement(By.id("sourceStatusSelect"));
        sourceStatusFieldDropDown.click();
        WebElement sourceStatusFieldName = driver.findElement(By.xpath("//*[@id=\"sourceStatusSelect\"]/option[3]"));
        sourceStatusFieldName.click();
        
        WebElement enableIconButton = driver.findElement(By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr/td[8]/div/button[1]/span"));
        enableIconButton.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"sourceEnableDialog\"]/div/div/div[3]/button[2]"));
        enableButton.click();
        
        String expectedEnableAlertMessage = "Source \"" + sourceTitle + "\" has been enabled";
        String actualEnableAlertMessage = driver.findElement(By.className("alert-success")).getText();   
        
        assertTrue("Olivere, enable alert message isn't good!", expectedEnableAlertMessage.equals(actualEnableAlertMessage)); 
    }
    
    
    //Find the element using Portal and Category tables inside Sources and delete it
    //1. Click Sources link on NavBar and go to the Sources page (precondition)
    //2. Find Portal drop-down field in the table and click on valid Portal
    //3. Find Category drop-down field in the table and click on valid Category
    //4. Find "Delete" icon button in Actions buttons and click on
    //5. Click on blue "Delete" button in pop-up field
    
    @Test
    public void testFindElementAndDeleteIt() {
    
        String sourceTitleName = "Srpska Televizija";
        
        WebElement sourcePortalFieldDropDown = driver.findElement(By.id("sourcePortalSelect"));
        sourcePortalFieldDropDown.click();
        WebElement sourcePortalFieldName = driver.findElement(By.xpath("//*[@id=\"sourcePortalSelect\"]/option[2]"));
        sourcePortalFieldName.click();
        
        WebElement sourceCategoryFieldDropDown = driver.findElement(By.id("sourceCategorySelect"));
        sourceCategoryFieldDropDown.click();
        WebElement sourceCategoryFieldName = driver.findElement(By.xpath("//*[@id=\"sourceCategorySelect\"]/option[14]"));
        sourceCategoryFieldName.click();
        
        WebElement deleteIconButton = driver.findElement(By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr/td[8]/div/button[2]/span"));
        deleteIconButton.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement deleteSourceButton = driver.findElement(By.xpath("//*[@id=\"sourceDeleteDialog\"]/div/div/div[3]/button[2]"));
        deleteSourceButton.click();
    
        String expectedAlertMessage = "Source \"" + sourceTitleName + "\" has been successfully deleted!";
        String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();       
        
        assertTrue("Olivere, da li si ćorav!? Table alert message isn't good!", expectedAlertMessage.equals(actualAlertMessage));
    }
    
}
