package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObjectRepository.CommonAppiumBinding;
import pageObjectRepository.HomePageObjectRepository;


public class HomePage extends CommonAppiumBinding {

    HomePageObjectRepository homePageObjectRepository = new HomePageObjectRepository();

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageObjectRepository);
    }

    public HomePage skipOnBoarding() {
        homePageObjectRepository.lblSkip.click();
         return this;
    }

    public SearchPage tapOnSearch() {
        homePageObjectRepository.fldSearch.click();
        return new SearchPage(driver);
    }
}
