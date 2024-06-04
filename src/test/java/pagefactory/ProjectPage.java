package pagefactory;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {

    private final Dotenv dotenv = Dotenv.load();
    private final String BASE_URL = dotenv.get("URL_BASE");
    private final String DASH_BOARD_URL = BASE_URL + dotenv.get("URL_DASH_BOARD");
    private final String PROJECT_URL = BASE_URL + dotenv.get("URL_PROJECTS");

    private final String COALA_PROJECT = "coala project";

    @FindBy(id = "project-filter-text")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"projects\"]/div/table/tbody/tr/td[1]/a")
    private WebElement firstCell;
    @FindBy(id = "project-name-val")
    private WebElement projectName;
    @FindBy(xpath = "//*[@id=\"projects\"]/div/table/tbody")
    private WebElement table;

    public ProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForProject(String projectName) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(projectName);
    }

    public void clickOnFirstCell() throws InterruptedException {
        Thread.sleep(500);
        firstCell.click();
    }

    public String getProjectName() {
        wait.until(ExpectedConditions.visibilityOf(projectName));
        return projectName.getText().toLowerCase();
    }
}
