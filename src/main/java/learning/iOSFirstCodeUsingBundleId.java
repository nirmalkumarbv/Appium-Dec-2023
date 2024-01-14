package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class iOSFirstCodeUsingBundleId {
    public static void main(String[] args) throws MalformedURLException, InterruptedException, URISyntaxException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("appium:deviceName", "iPhone 15");
        dc.setCapability("appium:automationName", "XCUITest");
        dc.setCapability("appium:bundleId", "com.example.apple-samplecode.UICatalog");
        //dc.setCapability("appium:app", System.getProperty("user.dir") + "/apks/UiCatalog.zip");
        IOSDriver driver = new IOSDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
        driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}