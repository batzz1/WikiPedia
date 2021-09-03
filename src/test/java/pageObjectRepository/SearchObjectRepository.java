package pageObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SearchObjectRepository {

    @AndroidFindBy(id = "page_list_item_title")
    public List<MobileElement> lstSearchResult;

    @AndroidFindBy(id = "search_src_text")
    public MobileElement icnSearchTxt;
    public final static String SEARCH_TEXT = "India Capital";
}
