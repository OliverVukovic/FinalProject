package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {           // atributi:
    private By emailFieldLocator = By.name("email");                             // "by.name" je lokatorska tehnika, koja vraca objekat klase "by"
    private By passwordFieldLocator = By.name("password");                       // to znaci, da je ovde prikazano uz pomoc koje tehnike pronalazimo atribut
    private By loginButtonLocator = By.className("btn-primary");
    private WebDriver driver;                                                    // atribut 

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
      
    public void enterEmail(String email) {                                       // ovo je login metoda (public void - javna metoda) izdeljena u nekoliko koraka
        driver.findElement (emailFieldLocator).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement (passwordFieldLocator).sendKeys(password);
    }
    public void clickOnLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
}
