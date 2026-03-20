package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
   public static WebDriver driver;
    
    public static WebDriver initDriver() {
    	      ConfigReader reader = new ConfigReader();
    	      String browserString = reader.getBrowser();
    	      String urlString =reader.getUrl();
    	      
    	      switch (browserString) {
			case "chrome":
				  driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;
			}
    	      
    	      driver.manage().window().maximize();
    	      driver.get(urlString);
    	      
    	      return driver;
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
}
