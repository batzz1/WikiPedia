package pageObjectRepository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonAppiumBinding {

    public AppiumDriver driver;

    public CommonAppiumBinding(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void scrollToElementIndex(WebElement e) {

    }

}
