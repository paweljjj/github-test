package paweljjj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paweljjj.configuration.ApplicationConfig;
import paweljjj.configuration.PlaywrightThread;

import static paweljjj.configuration.PlaywrightFactory.*;

@Service
@RequiredArgsConstructor
public class PlaywrightService implements PlaywrightThread {

    private final ApplicationConfig applicationConfig;

    public void setupPlaywrght() {
        playwright.set(createPlaywrightInstance());
        browser.set(createBrowser(playwright.get(), applicationConfig.getBrowserType(), applicationConfig.getBrowserHeadless(), applicationConfig.getBrowserArgs()));
        browserContext.set(createContext(browser.get()));
        page.set(createPage(browserContext.get(), Double.valueOf(applicationConfig.getTimeout())));
    }

    public void cleanupPlaywright() {
        closeContext(browserContext.get());
        closePage(page.get());
        closeBrowser(playwright.get());
        browserContext.remove();
        page.remove();
        playwright.remove();
    }

}
