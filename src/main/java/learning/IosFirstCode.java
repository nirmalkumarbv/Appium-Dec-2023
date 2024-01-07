package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class IosFirstCode {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("deviceName", "iPhone 15 Pro Max");
        dc.setCapability("udid", "30254222-DA9E-406C-8D76-FFE8EF39A8DF");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/uicatalog.zip");
        AppiumDriver driver = new AppiumDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
        driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
        driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.className("XCUIElementTypeButton")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}