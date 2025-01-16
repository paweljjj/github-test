package paweljjj.pages;

import org.springframework.stereotype.Component;
import paweljjj.configuration.PlaywrightThread;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class SearchPage implements PlaywrightThread {

    private final String searchInputPlaceholder = "Search GitHub";
    private final String resultListTestId = "results-list";
    private final String resultListSearchMatchClass = ".search-match";
    private final String searchSubHeaderTestId = "search-sub-header";

    public void open() {
        getPage().navigate("/search");
    }

    public void search(String text) {
        getPage().getByPlaceholder(searchInputPlaceholder).fill(text);
        getPage().getByPlaceholder(searchInputPlaceholder).press("Enter");
    }

    public void verifyResultIsVisibleOnResultsList(String expectedText) {
        assertThat(getPage().getByTestId(resultListTestId)).containsText(expectedText);
    }

    public void verifySearchResultsIsGreaterThanZero() {
        assertThat(getPage().getByTestId(resultListTestId).locator(resultListSearchMatchClass).first()).isVisible();
    }

    public void verifySearchResultsIsZero() {
        assertThat(getPage().getByTestId(searchSubHeaderTestId)).containsText("0 results");
    }

}
