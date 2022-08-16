package seleniumgluecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Constants.contants.Dates;
import pageObjects.EventsPage;
import pageObjects.SearchPage;
import pageObjects.SearchResultsPage;
import pageObjects.waitUntilElementIsClickable;
public class test {
	
		
	
	
	 public static WebDriver driver;
		 
	    @Given("^user opens ticketa search$")
	    public void user_opens_ticketa_search() throws Throwable {     
	    	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts();
			driver.get("https://www.tiketa.lt/EN/search");
	    }

		@When("^user accepts cookie")
		public void user_accepts_cookie() throws InterruptedException {
	    	SearchPage searchPage = new SearchPage(driver);
	    	searchPage.acceptCookie();
	        Thread.sleep(2000);
		}
	    
	    @When("^user writes Corteo in Caption field$")
	    public void user_writes_corteo_in_caption_field() throws Throwable {
	    	SearchPage searchPage = new SearchPage(driver);
	    	searchPage.inputCaption("Corteo");
	    	searchPage.loseCaptionFocus();   
	    }
	    
	    @When("^user selects avia solutions group arena event place$")
	    public void user_selects_arena_place() throws Throwable {
	    	SearchPage searchPage = new SearchPage(driver);
	    	searchPage.openArenaList();
	    	searchPage.selectAviaSolutionsArena();
	    }
	    
	    @When("^user selects date by input")
	    public void user_selects_date_by_input() throws Throwable {
	    	SearchPage searchPage = new SearchPage(driver);
	    	searchPage.fillDateTo(Dates.DATE_TO);
	    	searchPage.clearDateTo();
	    }
	    
	    @When("^user selects date by elements")
	    public void user_selects_date_by_elements() throws Throwable {
	    	SearchPage searchPage = new SearchPage(driver);
			waitUntilElementIsClickable clickableElement = new waitUntilElementIsClickable(driver);

	    	searchPage.clickDateLabel();
	    	searchPage.pressDateTo();
	    	clickableElement.waitUntilClickable("[title='Next']");
	    	searchPage.navigateToDecember(searchPage.countMonths());
	    	searchPage.pressDay();
	    }
	    
	    @When("^user presses search button")
	    public void user_presses_search_button() throws Throwable {
	    	SearchPage searchPage = new SearchPage(driver);
	    	searchPage.pressSearch();
	    }
	    
	    @When("^user clicks buy")
	    public void user_clicks_buy() throws Throwable {
	    	SearchResultsPage resultPage = new SearchResultsPage(driver);
	    	resultPage.pressCorteoEvent();
	    }
	    
	    @When("^user verifies list of tickets")
	    public void user_verifies_list_of_tickets() throws Throwable {
	    	EventsPage eventPage = new EventsPage(driver);
	    	eventPage.checkAmountOfEvents();
	    	eventPage.checkContent();
	    }
	    
		@Then("^user quits")
	    public void user_quit() throws Throwable {
			driver.quit();
	    }
}
