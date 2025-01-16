package paweljjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paweljjj.configuration.SpringConfig;
import paweljjj.service.PlaywrightService;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(classes = SpringConfig.class, webEnvironment = NONE)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PlaywrightService playwrightService;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        playwrightService.setupPlaywrght();
    }

    @AfterMethod(alwaysRun = true)
    void cleanUp() {
        playwrightService.cleanupPlaywright();
    }

}
