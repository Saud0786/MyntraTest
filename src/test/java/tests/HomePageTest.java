package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.HomePage;

public class HomePageTest extends BaseTest{
	HomePage hp;

    @BeforeMethod
    void initialize() {
        hp = new HomePage(driver);
    }

    @Test
    public void verifyhomepage() {

        boolean result = hp.verifyHomePage();
        Assert.assertTrue(result, "Homepage is not visible");

        // Logo Verification
        Assert.assertTrue(hp.verifyLogo(), "Logo is not visible");
    }
}
