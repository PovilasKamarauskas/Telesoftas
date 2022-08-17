package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[id=\"btnBuy-22551\"]") //static event id
    private WebElement CorteoEvent;

    public void pressCorteoEvent() {
        CorteoEvent.click();
    }
}
