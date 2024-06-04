package jira_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jira_cucumber.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pagefactory.DashBoard;
import pagefactory.LoginPage;
import pagefactory.ProjectPage;

public class SearchProjectStepDef {
    WebDriver webDriver = WebDriverProvider.setupWebDriver();
    LoginPage loginPage = new LoginPage(webDriver);
    DashBoard dashBoard = new DashBoard(webDriver);
    ProjectPage projectPage = new ProjectPage(webDriver);
    @Given("the user is on the dashboard page")
    public void theUserIsOnTheDashboardPage() {
        webDriver.manage().window().maximize();
        loginPage.navigateToLoginPage();
        loginPage.enterUserCredentials("automation74", "CCAutoTest19.");
        loginPage.clickLoginButton();
    }

    @When("the user clicks on the project button")
    public void theUserClicksOnTheProjectButton() {

        dashBoard.clickOnProjectsButton();
    }

    @And("the user clicks on the show all projects button")
    public void theUserClicksOnTheShowAllProjectsButton() {
        dashBoard.showAllProjects();
    }

    @And("the user enters {string} into the search bar")
    public void theUserEntersIntoTheSearchBar(String projectName) {
        projectPage.searchForProject(projectName);
    }

    @And("the user clicks on the first cell in the project table")
    public void theUserClicksOnTheFirstCellInTheProjectTable() throws InterruptedException {
        projectPage.clickOnFirstCell();
    }

    @Then("the first cell in the project table should contain {string}")
    public void theFirstCellInTheProjectTableShouldContain(String projectName) {
        Assertions.assertEquals(projectPage.getProjectName(), projectName);
    }

    @After
    public void quitWebdriver()
    {
        webDriver.quit();
    }
}
