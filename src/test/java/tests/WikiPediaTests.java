package tests;

import api.WikiClient;
import base.BasePage;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pageObjectRepository.HomePageObjectRepository;
import pageObjectRepository.SearchObjectRepository;
import pages.HomePage;
import pages.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class WikiPediaTests extends BasePage {

    @Test
    public void searchForKeyWord() throws InterruptedException {
        SearchPage searchPage = new HomePage(new BasePage().getDriver()).skipOnBoarding()
                .tapOnSearch();
        searchPage.search(SearchObjectRepository.SEARCH_TEXT);
        String searchResultAPI = new WikiClient().getResponse("India").jsonPath().get("capital").toString().replaceAll("[()\\[\\]]", "");
        String uiResult = searchPage.getFirstSearchResult();
        assertEquals(searchResultAPI, uiResult);
    }

}
