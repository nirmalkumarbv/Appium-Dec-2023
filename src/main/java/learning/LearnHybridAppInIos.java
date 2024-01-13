package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridAppInIos extends GenericWrappers {
    @Test
    public void runCode() {
        launchIosApp("iPhone 15 Pro Max", "", "", "com.example.apple-samplecode.UICatalog", "");
        swipe("up");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        printContext();
        printContext();
        switchWebView();
        click(getWebElement(Locators.XPATH.asString(), "(//a[contains(@href,\"/apple-vision-pro/\")])[3]"));
        sleep(5000);
        closeApp();


    }
}