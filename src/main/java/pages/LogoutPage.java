package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutPage {
    
    private By navDropDownFieldLocator = By.linkText("Cubes QA");                            
    private By logoutButtonFieldLocator = By.linkText("Logout");                       
    private WebDriver driver;                                                  

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
      
    public void clickOnNavDropDown() {
        driver.findElement(navDropDownFieldLocator).click();
    }
    public void clickOnLogoutButton() {
        driver.findElement(logoutButtonFieldLocator).click();
    }
    
    //WebElement navDropDown = driver.findElement(By.linkText("Cubes QA"));
        //navDropDown.click();

        //WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        //logoutButton.click();
    
}
