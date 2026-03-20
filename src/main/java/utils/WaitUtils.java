package utils;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
   	
   WebDriver driver = DriverFactory.getDriver();
   WebDriverWait wait;
   
   public WaitUtils() {
	 ConfigReader configReader = new ConfigReader();
	 wait = new WebDriverWait(driver,Duration.ofSeconds(configReader.getTimeout()));
   }
   
   public WebElement waitForElementVisible(WebElement element) {
	    return wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   public WebElement waitForElementClickable(WebElement element) {
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   public void waitForElementsVisible(List<WebElement> element) {
	     wait.until(ExpectedConditions.visibilityOfAllElements(element));
  }
}
