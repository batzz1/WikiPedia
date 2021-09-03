package pageObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObjectRepository {

    @AndroidFindBy(id = "fragment_onboarding_skip_button")
    public MobileElement lblSkip;

    @AndroidFindBy(id = "search_container")
    public MobileElement fldSearch;


}
