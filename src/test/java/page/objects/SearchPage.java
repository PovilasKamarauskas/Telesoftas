package page.objects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import constants.Constants.Dates;
import constants.Constants.Labels;

public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[name='sf_TextFilter']")
    private WebElement CaptionField;

    @FindBy(how = How.XPATH, using = "//*[text()='" + Labels.CAPTION + "']")
    private WebElement CaptionLabel;

    @FindBy(how = How.CSS, using = "[id='arenaCaption']")
    private WebElement ArenaInput;

    @FindBy(how = How.CSS, using = "[id='search-location'] [data-id=\"1\"]")
    private WebElement DropdownList;

    @FindBy(how = How.CSS, using = "[name='sf_DateTo']")
    private WebElement DateTo;

    @FindBy(how = How.XPATH, using = "//*[text()='" + Labels.DATE + "']")
    private WebElement DateLabel;

    @FindBy(how = How.CSS, using = "[title='Next']")
    private WebElement NextMonth;

    @FindBy(how = How.XPATH, using = "//td[@data-month=\"" + Dates.MONTH + "\"]/a[text()=\"" + Dates.DAY + "\"]")
    private WebElement Day;

    @FindBy(how = How.XPATH, using = "//button[text()=\"Search\"]")
    private WebElement SearchButton;

    @FindBy(how = How.CSS, using = "[id=\"cookiescript_accept\"]")
    private WebElement AcceptAll;

    public void acceptCookie() {
        AcceptAll.click();
    }

    public void inputCaption(String caption) {
        CaptionField.sendKeys(caption);
    }

    public void loseCaptionFocus() {
        CaptionLabel.click();
    }

    public void openArenaList() {
        ArenaInput.click();
    }

    public void selectAviaSolutionsArena() {
        DropdownList.click();
    }

    public void fillDateTo(String date) {
        DateTo.sendKeys(date);
    }

    public void clearDateTo() {
        DateTo.clear();
    }

    public void clickDateLabel() {
        DateLabel.click();
    }

    public void pressDateTo() {
        DateTo.click();
    }

    public void pressNext() {
        NextMonth.click();
    }

    public void pressDay() {
        Day.click();
    }


    public Long countMonths() {
        LocalDate todayDate = LocalDate.now();
        long monthsBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse(todayDate.toString()).withDayOfMonth(1),
                LocalDate.parse(Dates.DATE_TO).withDayOfMonth(1));
        return monthsBetween;
    }

    public void navigateToDecember(Long long1) {
        for (int i = 0; i < long1; i++) {
            pressNext();
        }
    }

    public void pressSearch() {
        SearchButton.click();
    }
}
