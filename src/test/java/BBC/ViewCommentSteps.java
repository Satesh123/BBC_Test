package BBC;

import BBC.pageObject.CommentsPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class ViewCommentSteps extends TestRunner {

    public CommentsPage commentsPage;


    @Before
    public void startTest() {
        commentsPage = new CommentsPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void stop(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }
    }

    @Given("^Open BBC website$")
    public void openBBCWebsite() {
        driver.get("https://www.bbc.co.uk/");
    }

    @When("^Go to News Headlines from Home Page$")
    public void goToNewsHeadlinesFromHomePage() {
        commentsPage.newsHeadlines();
    }

    @And("^Go on the article where commenting is enabled$")
    public void goOnTheArticleWhereCommentingIsEnabled() {
        commentsPage.goOnEnabledArticle();
    }

    @Then("^Sign in and Register button should be visible$")
    public void signInAndRegisterButtonShouldBeVisible() {
        commentsPage.signInButtonVisible();
    }

    @Then("^User should be able to view comments$")
    public void userShouldBeAbleToViewComments() {
        commentsPage.verifyViewCommentsBody();
    }

    @And("^Go to SignIn tab on the top navigation bar$")
    public void goToSignInTabOnTheTopNavigationBar() {
        commentsPage.signInTab();
    }

    @When("^Enter valid \"([^\"]*)\" and \"([^\"]*)\" and click on Sign In button$")
    public void enterValidAndAndClickOnSignInButton(String Username, String Password) {
        commentsPage.userLogIn(Username, Password);
    }

    @Then("^It should navigate to BBC Home Page$")
    public void itShouldNavigateToBBCHomePage() {
        commentsPage.verifyTitleText();
    }

    @And("^User should be able to add a comment$")
    public void userShouldBeAbleToAddAComment() {
        commentsPage.verifyInputCommentBox();
    }
}
