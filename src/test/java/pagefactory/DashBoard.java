package pagefactory;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashBoard extends BasePage{
    private final Dotenv dotenv = Dotenv.load();
    private final String BASE_URL = dotenv.get("URL_BASE");
    private final String DASH_BOARD_URL = dotenv.get(BASE_URL + "URL_DASH_BOARD");

    @FindBy(id="home_link")
    private WebElement dashboard;
    @FindBy(id="browse_link")
    private WebElement projects;
    @FindBy(id="project_view_all_link_lnk")
    private WebElement viewAllProjects;
    @FindBy(id="find_link")
    private WebElement issues;
    @FindBy(id="ktm_top_menu")
    private WebElement tests;


    public DashBoard(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToLoginPage(){
        webDriver.navigate().to(BASE_URL);
    }

    public void clickOnProjectsButton(){
        wait.until(ExpectedConditions.visibilityOf(projects));
        projects.click();
    }

    public void showAllProjects(){
        wait.until(ExpectedConditions.visibilityOf(viewAllProjects));
        viewAllProjects.click();
    }
}
