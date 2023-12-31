package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnSwitchBetweenApps extends GenericWrappers {
    @Test
    public void runCode() {
        launchApp("Android", "my device", "", "", "", "UiAutomator2", "", "", "", "", "", "/apks/leaforg.apk", "", "");
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        switchToAnotherApp("com.the511plus.MultiTouchTester");
        swipe("up");
        //switchToAnotherApp("com.amazon.mShop.android.shopping");
        startAnAppUsingActivity("com.amazon.mShop.android.shopping", "com.amazon.mShop.home.HomeActivity");
        startAnAppUsingActivity("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
        //stopRunningApp("com.the511plus.MultiTouchTester");
        sleep(2000);
        switchToAnotherApp("com.testleaf.leaforg");
        sleep(5000);
        closeApp();
    }
}