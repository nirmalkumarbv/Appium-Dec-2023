package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnUsingWrappers extends GenericWrappers {
    @Test
    public void runCode() {
        launchApp("Android", "my device", "", "", "", "UiAutomator2", "", "", "", "", "", "/apks/leaforg.apk", "", "");
        verifyAndInstallApp("com.the511plus.MultiTouchTester", "/apks/MultiTouch Tester_v1.2.apk");
        System.out.println(getOrientation());
        sleep(3000);
        setLandscapeOrientation();
        sleep(3000);
        System.out.println(getOrientation());
        setPortraitOrientation();
        System.out.println(getOrientation());
        sleep(5000);
        closeApp();
    }
}