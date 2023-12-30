package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class LearnPinchAndZoom {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my device");
        dc.setCapability("noReset", true);
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int maxX = driver.manage().window().getSize().getWidth();
        int maxY = driver.manage().window().getSize().getHeight();
        int startX = 0, startY = 0, endX = 0, endY = 0;
        //Pinch
        startX = (int) (maxX * 0.75);
        startY = (int) (maxY * 0.25);
        endX = (int) (maxX * 0.5);
        endY = (int) (maxY * 0.5);
        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence finger1 = new Sequence(input1, 1);
        finger1.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        finger1.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger1.addAction(input1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        finger1.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        startX = (int) (maxX * 0.25);
        startY = (int) (maxY * 0.75);
        endX = (int) (maxX * 0.5);
        endY = (int) (maxY * 0.5);
        PointerInput input2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence finger2 = new Sequence(input2, 1);
        finger2.addAction(input2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        finger2.addAction(input2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger2.addAction(input2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        finger2.addAction(input2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(finger1, finger2));

        //Zoom
        startX = (int) (maxX * 0.5);
        startY = (int) (maxY * 0.5);
        endX = (int) (maxX * 0.75);
        endY = (int) (maxY * 0.25);
        PointerInput input3 = new PointerInput(PointerInput.Kind.TOUCH, "finger3");
        Sequence finger3 = new Sequence(input3, 1);
        finger3.addAction(input3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        finger3.addAction(input3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger3.addAction(input3.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        finger3.addAction(input3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        startX = (int) (maxX * 0.5);
        startY = (int) (maxY * 0.5);
        endX = (int) (maxX * 0.25);
        endY = (int) (maxY * 0.75);
        PointerInput input4 = new PointerInput(PointerInput.Kind.TOUCH, "finger4");
        Sequence finger4 = new Sequence(input4, 1);
        finger4.addAction(input4.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        finger4.addAction(input4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger4.addAction(input4.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        finger4.addAction(input4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(finger3, finger4));
        Thread.sleep(5000);
        driver.quit();
    }
}
