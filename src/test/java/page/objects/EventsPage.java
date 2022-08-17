package page.objects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import constants.Constants.EventAmount;
import constants.Constants.Labels;

public class EventsPage {
    public EventsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(how = How.XPATH, using = "//div[@class=\"page-content col-xs-12\"]") //column of events div's
    })
    private List<WebElement> EventsColumn;

    public int returnEventCount() {
        return EventsColumn.size();
    }

    public void checkAmountOfEvents() {
        assert returnEventCount() == EventAmount.EVENT_AMOUNT;
    }

    public void checkContent() {
        Iterator<WebElement> itr = EventsColumn.iterator();
        while (itr.hasNext()) {
            assert itr.next().getText().contains(Labels.FULL_CAPTION);
        }
    }
}
