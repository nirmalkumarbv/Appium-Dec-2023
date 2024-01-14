package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnPickerWheelInIos extends GenericWrappers {
    @Test
    public void runCode() {
        launchIosApp("iPhone 15 Pro Max", "", "", "com.example.apple-samplecode.UICatalog", "");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        // Option 1
        String getValue = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        while(!getValue.equals("75")) {
            //Adjust the right pixels based on screen size
            swipeWithinWebElement("up",getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
            getValue = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        }
        //Option 2 --> Has failures if it has time/date --> Con: Use the exact match of value
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Green color component value"),"100",false);
        //Option 3: Picker wheel --> Can be used only when class name is "XCUIElementTypePickerWheel" --> Alternate for option 1
        chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        choosePreviousOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        String getValue1 = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        while(!getValue1.equals("50")) {
            //Adjust the right pixels based on screen size
            choosePreviousOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
            getValue1 = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        }
        //Only option 2 and 3 are recommended for iOS
        sleep(5000);
        closeApp();
    }
}