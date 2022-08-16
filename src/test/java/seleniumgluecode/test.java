package seleniumgluecode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Constants.contants.Dates;
import Constants.contants.Labels;
import Constants.contants.EventAmount;

public class test {
		
	static Long monthDifference() {
		LocalDate todayDate = LocalDate.now();
		long monthsBetween = ChronoUnit.MONTHS.between(
		        LocalDate.parse(todayDate.toString()).withDayOfMonth(1),
		        LocalDate.parse(Dates.DATE_TO).withDayOfMonth(1));
		return monthsBetween;
	}
	
	static void waitUntilElementIsClickable(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
	}
	
	 public static WebDriver driver;
		 
	    @Given("^user opens ticketa search$")
	    public void user_opens_ticketa_search() throws Throwable {     
	    	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts();
	        driver.get("https://www.tiketa.lt/EN/search");
	        waitUntilElementIsClickable("[id=\"cookiescript_accept\"]");
	    }
	    
	    @When("^user writes Corteo in Caption field$")
	    public void user_writes_corteo_in_caption_field() throws Throwable {
	        driver.findElement(By.cssSelector("[name='sf_TextFilter']")).sendKeys("Corteo");
	        driver.findElement(By.xpath("//*[text()='"+Labels.CAPTION+"']")).click();	    
	    }
	    
	    @When("^user selects avia solutions group arena event place$")
	    public void user_selects_arena_place() throws Throwable {
	        driver.findElement(By.cssSelector("[id='arenaCaption']")).click();	 
	        driver.findElement(By.cssSelector("[id='search-location'] [data-id=\"1\"]")).click();
	    }
	    
	    @When("^user selects date by input")
	    public void user_selects_date_by_input() throws Throwable {
	    	driver.findElement(By.cssSelector("[name='sf_DateTo']")).sendKeys(Dates.DATE_TO);
	    	driver.findElement(By.cssSelector("[name='sf_DateTo']")).clear();	    
	    }
	    
	    @When("^user selects date by elements")
	    public void user_selects_date_by_elements() throws Throwable {
	        driver.findElement(By.xpath("//*[text()='"+Labels.DATE+"']")).click();	    
	    	driver.findElement(By.cssSelector("[name='sf_DateTo']")).click();
	    	waitUntilElementIsClickable("[title='Next']");
	    	
	    	for (int i = 0;i<monthDifference(); i++) {
	    		driver.findElement(By.cssSelector("[title='Next']")).click();
	    	}
	    	driver.findElement(By.xpath("//td[@data-month=\""+ Dates.MONTH +"\"]/a[text()=\""+ Dates.DAY +"\"]")).click();
	    }
	    
	    @When("^user presses search button")
	    public void user_presses_search_button() throws Throwable {
	    	driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
	    }
	    
	    @When("^user clicks buy")
	    public void user_clicks_buy() throws Throwable {
	        waitUntilElementIsClickable("[id=\"btnBuy-22551\"]");
	    	driver.findElement(By.cssSelector("[id=\"btnBuy-22551\"]")).click(); //22551 unique event id
	    }
	    
	    @When("^user verifies list of tickets")
	    public void user_verifies_list_of_tickets() throws Throwable {
	    	List<WebElement> tickets = driver.findElements(By.xpath("//div[@class=\"page-content col-xs-12\"]"));
	    	if(tickets.size()!= EventAmount.EVENT_AMOUNT) {
	    		throw new Exception("Too much events returned");
	    	}
	    	for(int i=0;i<tickets.size();i++) {
		    	if(tickets.get(i).getText().contains("CIRQUE DU SOLEIL - CORTEO")) {
		    		continue;
		    	} else {
		    		throw new Exception("Random event got mixed up in the list.");
		    	}
		    }
	    }
	    
		@Then("^user quits")
	    public void user_quit() throws Throwable {
			driver.quit();
	    }
}
