package paweljjj.pages;

import com.microsoft.playwright.Locator;
import org.springframework.stereotype.Component;
import paweljjj.configuration.PlaywrightThread;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class RepositoryPage implements PlaywrightThread {

    private final String repositoryNameLocator = "#repository-container-header [itemprop='name']";
    private final String codeButtonLocator = "[data-component='buttonContent']:has-text(\"Code\")";
    private final String httpsUrlLocator = "#clone-with-https";
    private final String branchButtonId = "#branch-picker-repos-header-ref-selector";
    private final String branchListLocator = "#branches li";

    public void open(String project, String repository) {
        getPage().navigate("/" + project + "/" + repository);
    }

    public void verifyRepositoryName(String repository) {
        assertThat(getPage().locator(repositoryNameLocator)).hasText(repository);
    }

    public void clickCodeButton() {
        getPage().locator(codeButtonLocator).click();
    }

    public void verifyCloneHttpsUrl(String expectedUrl) {
        assertThat(getPage().locator(httpsUrlLocator)).hasValue(expectedUrl);
    }

    public void verifyActiveBranchIsMaster() {
        assertThat(getPage().locator(branchButtonId)).containsText("master");
    }

    public void verifyActiveBranchIsNotMaster() {
        assertThat(getPage().locator(branchButtonId)).not().containsText("master");
    }

    public void changeToBranchDifferentThanMaster() {
        getPage().locator(branchButtonId).click();
        getPage().locator(branchListLocator).filter(new Locator.FilterOptions().setHasNotText("master")).first().click();
    }

}
