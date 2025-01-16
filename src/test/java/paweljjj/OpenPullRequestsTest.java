package paweljjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paweljjj.pages.PullRequestPage;

public class OpenPullRequestsTest extends BaseTest {

    @Autowired
    PullRequestPage pullRequestPage;

    @Test(groups = {"repository", "pullRequest"})
    @Parameters({"project", "repository"})
    public void openPullRequest(String project, String repository) {
        pullRequestPage.open(project, repository);
        pullRequestPage.openFirstPullRequest();
        pullRequestPage.verifyPullRequestStateIsOpen();
    }

}
