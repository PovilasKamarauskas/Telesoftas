package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Constants.contants.Labels;

public class InitialScreen {
	
	WebDriver driver;

	public InitialScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	By CaptionField = By.cssSelector("[name='sf_TextFilter']");
	By CaptionLabel = By.xpath("//*[text()='"+Labels.CAPTION+"']");
	
	public void writeCorteo() {
		driver.findElement(CaptionField).sendKeys("Corteo");
		driver.findElement(CaptionLabel).click();
	}
}
