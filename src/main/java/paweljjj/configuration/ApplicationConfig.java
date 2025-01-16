package paweljjj.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Configuration
public class ApplicationConfig {

    @Value("${playwright.browser.type}")
    private String browserType;

    @Value("${playwright.browser.args}")
    private List<String> browserArgs;

    @Value("#{new Boolean('${playwright.browser.headless}')}")
    private Boolean browserHeadless;

    @Value("${playwright.browser.baseUrl")
    private String browserBaseUrl;

    @Value("${timeout}")
    private String timeout;

    @Value("${timeout.unit}")
    private String timeoutUnit;
}
