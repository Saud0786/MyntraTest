package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.Base;

public class SearchProductPage extends Base {

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    // 📱 Mobile Phones category
    @FindBy(xpath = "//span[@data-aut-id='header_link' and normalize-space()='Mobile Phones']")
    WebElement mobilePhonesLink;

    // ✅ Exact heading text
    @FindBy(xpath = "//h1[normalize-space()='Buy Second Hand Mobile Phones in India']")
    WebElement headingText;

    // 🔧 Action
    public void clickMobilePhonesCategory() {
        mobilePhonesLink.click();
    }

    // ✅ Validate heading
    public boolean isHeadingDisplayed() {
        return headingText.isDisplayed();
    }

    // ✅ Optional (better validation)
    public String getHeadingText() {
        return headingText.getText();
    }
}