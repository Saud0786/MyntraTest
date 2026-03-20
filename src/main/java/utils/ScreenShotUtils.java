package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

    public String captureScreenShot(String testName) throws IOException {

        WebDriver driver = DriverFactory.getDriver(); // use existing driver

        if (driver == null) {
            throw new RuntimeException("Driver not found");
        }

        TakesScreenshot tScreenshot = (TakesScreenshot) driver;
        File src = tScreenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/screenshots/" 
                      + testName + "_" + timestamp + ".png";

        File destFile = new File(path);
        destFile.getParentFile().mkdirs();

        Files.copy(src.toPath(), destFile.toPath());

        return path;
    }
}