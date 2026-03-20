package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class SearchProductPage extends Base {

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    //  Mobile Phones category
    @FindBy(xpath = "//span[@data-aut-id='header_link' and normalize-space()='Mobile Phones']")
    WebElement mobilePhonesLink;

    //  Exact heading text
    @FindBy(xpath = "//h1[normalize-space()='Buy Second Hand Mobile Phones in India']")
    WebElement headingText;

    //  Action
    public void clickMobilePhonesCategory() {
        mobilePhonesLink.click();
    }

    //  Validate heading
    public boolean isHeadingDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(headingText));
    return headingText.isDisplayed();
    }

    //  Optional (better validation)
    public String getHeadingText() {
        return headingText.getText();
    }
}