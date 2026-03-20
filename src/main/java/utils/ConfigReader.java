package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
     Properties properties;
     
     public ConfigReader() {
    	    try {
				FileInputStream fileInputStream = new FileInputStream("src/main/resources/Config.properties");
				
				properties = new Properties();
				properties.load(fileInputStream);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	    
     }
     
     public String getUrl() {
    	 return properties.getProperty("url");
     }
     
     public String getBrowser() {
    	    return properties.getProperty("browser");
     }
     
     public int getTimeout() {
    	 return Integer.parseInt(properties.getProperty("timeout"));
     }
}
