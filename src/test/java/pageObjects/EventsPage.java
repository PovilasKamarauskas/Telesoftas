package pageObjects;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Constants.contants.EventAmount;

public class EventsPage {
	WebDriver driver;
	public EventsPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//div[@class=\"page-content col-xs-12\"]")
	})
	private List<WebElement> EventsColumn;
	
	public int returnEventCount() {
		return EventsColumn.size();
	}
	
	public void checkAmountOfEvents() throws Exception {
    	if(returnEventCount()!= EventAmount.EVENT_AMOUNT) {
    		throw new Exception("Too much events returned");
    	}
	}
	
	public void checkContent() throws Exception {
		Iterator<WebElement> itr = EventsColumn.iterator();
		while(itr.hasNext()) {
		    if(itr.next().getText().contains("CIRQUE DU SOLEIL - CORTEO")) {
	    		continue;
	    	} else {
	    		throw new Exception("Random event got mixed up in the list.");
	    	}
		}
	}
}
