package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridApps extends GenericWrappers {
    @Test
    public void runCode() {
        launchAndroidApp("my device", "", "", "UiAutomator2", "/apks/leaforg.apk");
        sleep(2000);
        printContext();
        switchContext("WEBVIEW_com.testleaf.leaforg");
        enterValue(getWebElement(Locators.TAG_NAME.asString(), "input"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//input)[2]"), "Leaf@123");
        click(getWebElement(Locators.XPATH.asString(), "//button[@type='submit']"));
        sleep(5000);
        closeApp();
    }
}