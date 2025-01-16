package paweljjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paweljjj.pages.HomePage;
import paweljjj.pages.SearchPage;

import java.util.UUID;

public class SearchTest extends BaseTest {

    @Autowired
    HomePage homePage;

    @Autowired
    SearchPage searchPage;

    @Test(groups = {"search"})
    @Parameters("searchText")
    public void searchForTextFromHomePage(String searchText) {
        homePage.open();
        homePage.search(searchText);
        searchPage.verifySearchResultsIsGreaterThanZero();
        searchPage.verifyResultIsVisibleOnResultsList(searchText);
    }

    @Test(groups = {"search"})
    @Parameters("searchText")
    public void searchForTextFromSearchPage(String searchText) {
        searchPage.open();
        searchPage.search(searchText);
        searchPage.verifySearchResultsIsGreaterThanZero();
        searchPage.verifyResultIsVisibleOnResultsList(searchText);
    }

    @Test(groups = {"search"})
    public void searchNotMatchAnyRepositories() {
        searchPage.open();
        searchPage.search(UUID.randomUUID() + "_not_existing_repository");
        searchPage.verifySearchResultsIsZero();
    }

}
