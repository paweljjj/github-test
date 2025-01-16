package paweljjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paweljjj.pages.RepositoryPage;

public class CloneRepositoryTest extends BaseTest {

    @Autowired
    RepositoryPage repositoryPage;

    @Test(groups = {"repository", "clone"})
    @Parameters({"project", "repository", "expectedUrl"})
    public void cloneRepository(String project, String repository, String expectedUrl) {
        repositoryPage.open(project, repository);
        repositoryPage.verifyRepositoryName(repository);
        repositoryPage.clickCodeButton();
        repositoryPage.verifyCloneHttpsUrl(expectedUrl);
    }

}
