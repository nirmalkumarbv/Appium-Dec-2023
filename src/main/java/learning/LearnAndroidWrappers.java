package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnAndroidWrappers extends GenericWrappers {
    @Test
    public void runCode() {
        launchAndroidApp("my device", "", "", "UiAutomator2", "/apks/leaforg.apk");
        sleep(3000);
        showNotificationMenu();
        sleep(3000);
        hideNotificationMenu();
        dataOffInAndroid();
        sleep(5000);
        dataOnInAndroid();
        sleep(5000);
        System.out.println(getCurrentActivity());
        System.out.println(getCurrentAppPackage());
    }
}