package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AndroidFirstCodeUsingAppPackageAndAppActivity {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("deviceName", "my device");
        dc.setCapability("appPackage", "com.testleaf.leaforg");
        dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
        AppiumDriver driver = new AppiumDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(AppiumBy.xpath("(//android.view.View[@text=\"Login Or Create Your New Account\"]/..//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
