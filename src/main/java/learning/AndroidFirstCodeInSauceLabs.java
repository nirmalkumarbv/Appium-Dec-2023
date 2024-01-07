package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AndroidFirstCodeInSauceLabs {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=leaforg.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0-flutter2");
        sauceOptions.setCapability("username", "oauth-lk2420598-79e83");
        sauceOptions.setCapability("accessKey", "b5d5a6da-39d7-49cf-87ab-b53613e663f0");
        sauceOptions.setCapability("build", "<your build id>");
        sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(AppiumBy.xpath("(//android.view.View[@text=\"Login Or Create Your New Account\"]/..//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
