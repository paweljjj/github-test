package paweljjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paweljjj.pages.RepositoryPage;

public class ChangeBranchTest extends BaseTest {

    @Autowired
    RepositoryPage repositoryPage;

    @Test(groups = {"repository", "branch"})
    @Parameters({"project", "repository"})
    public void changeActiveBranch(String project, String repository) {
        repositoryPage.open(project, repository);
        repositoryPage.verifyActiveBranchIsMaster();
        repositoryPage.changeToBranchDifferentThanMaster();
        repositoryPage.verifyActiveBranchIsNotMaster();
    }

}
