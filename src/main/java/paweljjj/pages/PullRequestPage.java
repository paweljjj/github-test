package paweljjj.pages;

import org.springframework.stereotype.Component;
import paweljjj.configuration.PlaywrightThread;
import paweljjj.model.PullRequestState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class PullRequestPage implements PlaywrightThread {

    private final String pullRequestListLocator = ".js-active-navigation-container .Link--primary";
    private final String pullRequestStateLocator = "#partial-discussion-header .flex-self-start .State";

    public void open(String project, String repository) {
        getPage().navigate("/" + project + "/" + repository + "/pulls");
    }

    public void openFirstPullRequest() {
        getPage().locator(pullRequestListLocator).first().click();
    }

    public void verifyPullRequestStateIsOpen() {
        assertThat(getPage().locator(pullRequestStateLocator)).containsText(PullRequestState.OPEN.getLabel());
    }

}
