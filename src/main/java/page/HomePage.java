package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Base;

public class HomePage extends Base {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Logo
    @FindBy(xpath="//img[@alt='OLX India']")
    WebElement logo;

    public boolean verifyHomePage() {
        String title = driver.getTitle();
        return title.contains("OLX");
    }

    public boolean verifyLogo() {
        return logo.isDisplayed();
    }
}