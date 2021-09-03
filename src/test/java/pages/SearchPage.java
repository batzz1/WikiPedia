package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObjectRepository.SearchObjectRepository;

public class SearchPage {

    SearchObjectRepository searchObjectRepository = new SearchObjectRepository();

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchObjectRepository);

    }


    public String getFirstSearchResult() {
        return searchObjectRepository.lstSearchResult.get(0).getText();
    }

    public SearchPage search(String text) {
        searchObjectRepository.icnSearchTxt.sendKeys(text);
        return this;
    }

}
