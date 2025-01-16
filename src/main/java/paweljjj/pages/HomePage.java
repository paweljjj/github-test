package paweljjj.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import paweljjj.configuration.ApplicationConfig;
import paweljjj.configuration.PlaywrightThread;

@Component
@RequiredArgsConstructor
public class HomePage implements PlaywrightThread {

    private final ApplicationConfig applicationConfig;
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
