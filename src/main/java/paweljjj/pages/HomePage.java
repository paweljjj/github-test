package paweljjj.pages;

import org.springframework.stereotype.Component;
import paweljjj.configuration.PlaywrightThread;

@Component
public class HomePage implements PlaywrightThread {

    private final String searchButton = "[data-target='qbsearch-input.inputButtonText']";
    private final String searchInput = "[data-target='query-builder.input']";

    public void open() {
        getPage().navigate("/");
    }

    public void search(String text) {
        getPage().locator(searchButton).click();
        getPage().locator(searchInput).fill(text);
        getPage().locator(searchInput).press("Enter");
    }

}
