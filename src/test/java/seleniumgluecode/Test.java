package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import constants.Constants.Dates;
import page.objects.EventsPage;
import page.objects.SearchPage;
import page.objects.SearchResultsPage;
import page.objects.WaitUntilElementIsClickable;
import constants.Constants.Inputs;
import constants.Constants.Urls;

public class Test {
    private final WebDriver driver = new ChromeDriver();
    SearchPage searchPage = new SearchPage(driver);
    WaitUntilElementIsClickable clickableElement = new WaitUntilElementIsClickable(driver);
    SearchResultsPage resultPage = new SearchResultsPage(driver);
    EventsPage eventPage = new EventsPage(driver);

    public Test() {
        driver.manage().window().maximize();
    }

    @Given("^user opens tiketa search$")
    public void user_opens_tiketa_search() {
        driver.get(Urls.BASE_URL);
    }

    @When("^user accepts cookie")
    public void user_accepts_cookie() throws InterruptedException {
        searchPage.acceptCookie();
        Thread.sleep(2000);
    }

    @When("^user writes corteo in Caption field$")
    public void user_writes_corteo_in_caption_field() {
        searchPage.inputCaption(Inputs.EVENT);
        searchPage.loseCaptionFocus();
    }

    @When("^user selects avia solutions group arena event place$")
    public void user_selects_arena_place() {
        searchPage.openArenaList();
        searchPage.selectAviaSolutionsArena();
    }

    @When("^user selects date by input")
    public void user_selects_date_by_input() {
        searchPage.fillDateTo(Dates.DATE_TO);
        searchPage.clearDateTo();
    }

    @When("^user selects date by elements")
    public void user_selects_date_by_elements() {
        searchPage.clickDateLabel();
        searchPage.pressDateTo();
        clickableElement.waitUntilClickable("[title='Next']");
        searchPage.navigateToDecember(searchPage.countMonths());
        searchPage.pressDay();
    }

    @When("^user presses search button")
    public void user_presses_search_button() {
        searchPage.pressSearch();
    }

    @When("^user clicks buy")
    public void user_clicks_buy() {
        resultPage.pressCorteoEvent();
    }

    @Then("^user verifies list of tickets")
    public void user_verifies_list_of_tickets() {
        eventPage.checkAmountOfEvents();
        eventPage.checkContent();
        driver.quit();
    }
}
