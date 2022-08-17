package page.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntilElementIsClickable {
    WebDriver driver;

    public WaitUntilElementIsClickable(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilClickable(String nextMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(nextMonth)));
    }
}
