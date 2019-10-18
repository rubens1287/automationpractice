package br.com.core.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.core.asserts.Verifications;

public class FrameActions  {
	/**
	 * Switches from one frame to other
	 * 
	 * @author Rubens Lobo 
	 * @param by Type of "By"
	 * @param seconds Waits for the defined time set as parameter
	 */
	 public static void switchToFrame(WebDriver driver, By by, int seconds) {
		 Verifications.wait(2);
		 WebElement iFrame = Action.getClickableElement(driver, by, seconds);
		 driver.switchTo().frame(iFrame);
	 }
	 
	 public static void swtichToPreviousFrame(WebDriver driver) {
		 String firstFrame = driver.getWindowHandle();
		 driver.switchTo().window(firstFrame);
	 }
}
