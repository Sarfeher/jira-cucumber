package pagefactory;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final Dotenv dotenv = Dotenv.load();
    private final String BASE_URL = dotenv.get("URL_BASE");

    @FindBy(id = "login-form-username")
    private WebElement usernameField;
    @FindBy(id = "login-form-password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    private WebElement profilePicture;

    @FindBy(css = "[class^='aui-message']")
    private WebElement errorMassage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToLoginPage(){
        webDriver.navigate().to(BASE_URL);
    }

    public void enterUserCredentials(String userName, String password){
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean areWeLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(profilePicture));
        return profilePicture.isDisplayed();
    }
    public boolean isErrorDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(errorMassage));
        return errorMassage.isDisplayed();
    }


}
