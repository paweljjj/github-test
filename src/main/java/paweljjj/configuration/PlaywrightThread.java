package paweljjj.configuration;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public interface PlaywrightThread {

    ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    ThreadLocal<Browser> browser = new ThreadLocal<>();
    ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    ThreadLocal<Page> page = new ThreadLocal<>();

    default Page getPage() {
        return page.get();
    }

}