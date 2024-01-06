package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

    @AndroidFindBy(xpath = "//android.view.View[@text='Rajkumar Ganesan']")
    private WebElement userNameTxt;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
        if (!eleIsDisplayed(userNameTxt)) {
            throw new RuntimeException("Home page is not displayed");
        }
    }

    @Given("Home page is verified")
    public HomePage verifyHomePage() {
        eleIsDisplayed(userNameTxt);
        return this;
    }

}