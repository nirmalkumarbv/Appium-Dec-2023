package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSFirstCodeInRealDevice {

    public static void main(String[] args) throws MalformedURLException, InterruptedException, URISyntaxException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("deviceName", "Real device");
        dc.setCapability("udid", "<right udid of real device>");
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