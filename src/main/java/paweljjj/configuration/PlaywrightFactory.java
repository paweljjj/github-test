package paweljjj.configuration;

import com.microsoft.playwright.*;
import paweljjj.exception.TestException;

import java.util.List;

public class PlaywrightFactory {

    public static Playwright createPlaywrightInstance() {
        return Playwright.create();
    }

    public static Browser createBrowser(Playwright playwright, String browserName, boolean headless, List<String> args) {
        BrowserType browserType = switch (browserName) {
            case "chromium" -> playwright.chromium();
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> throw new TestException("Browser type " + browserName + " is not supported");
        };
        return browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setArgs(args));
    }

    public static void closeBrowser(Playwright playwright) {
        if (playwright != null) playwright.close();
    }

    public static BrowserContext createContext(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions().setBaseURL("https://github.com"));
    }

    public static void closeContext(BrowserContext browserContext) {
        if (browserContext != null) browserContext.close();
    }

    public static Page createPage(BrowserContext browserContext, Double timeout) {
        browserContext.setDefaultTimeout(timeout);
        browserContext.setDefaultNavigationTimeout(timeout);
        Page page = browserContext.newPage();
        page.setViewportSize(1920, 1080);
        return page;
    }

    public static void closePage(Page page) {
        if (page != null) page.close();
    }

}
