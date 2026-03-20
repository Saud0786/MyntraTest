package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.SearchProductPage;

public class SearchProductPageTest extends BaseTest {

    SearchProductPage sp;

    @BeforeMethod
    void initialize() {
        sp = new SearchProductPage(driver);
    }

    @Test()
    public void verifyMobilePhonesPage() {

        // Step 1: Click Mobile Phones
        sp.clickMobilePhonesCategory();

        // Step 2: Validate heading is visible
        Assert.assertTrue(sp.isHeadingDisplayed(),
                "Heading is NOT displayed!");

        // 🔥 Step 3: Strong validation (recommended)
        String actualText = sp.getHeadingText();

        Assert.assertEquals(actualText,
                "Buy Second Han Mobile Phones in India",
                "Heading text mismatch!");
    }
}