package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidFirstCode {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("deviceName", "my device");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/leaforg.apk");
        AppiumDriver driver = new AppiumDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
        Thread.sleep(5000);
        driver.quit();
    }
}
