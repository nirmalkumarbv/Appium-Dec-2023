package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppInIos extends GenericWrappers {
    @Test
    public void runCode() {
        launchSafariBrowser("iPhone 15 Pro Max","https://www.google.com","");
        enterValue(getWebElement(Locators.ID.asString(), "XSqSsc"),"Lokesh Kumar");
//        switchNativeView();
//        System.out.println(driver.getPageSource());
//        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Search"));
//        switchWebView();
        clickGivenKeyboardButtonInIosByAccessibilityId("Search");
//        System.out.println(driver.getPageSource());
        sleep(5000);
        closeApp();
    }
}