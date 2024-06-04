package jira_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pagefactory.LoginPage;

public class LoginStepDef {
    WebDriver webDriver = WebDriverProvider.setupWebDriver();
    LoginPage loginPage = new LoginPage(webDriver);

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("the user enters a valid {string} and {string}")
    public void theUserEntersAValidUsernameAndPassword(String username, String password) {
        loginPage.enterUserCredentials(username, password);
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user profile picture is displayed")
    public void theUserProfilePictureIsDisplayed() {
        //Assertions.assertTrue(loginPage.areWeLoggedIn()); ez jobb esetleg?
        loginPage.areWeLoggedIn();
    }

    @When("the user enters a invalid {string} and {string}")
    public void theUserEntersAInvalidUsernameAndPassword(String username, String password) {
        loginPage.enterUserCredentials(username, password);
    }

    @Then("the error massage is displayed")
    public void theErrorMassageIsDisplayed() {
        //Assertions.assertTrue(loginPage.isErrorDisplayed()); ez jobb esetleg?
        loginPage.isErrorDisplayed();
    }

    @AfterEach
    public void quitWebdriver()
    {
        webDriver.quit();
    }

}
