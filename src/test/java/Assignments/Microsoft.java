package Assignments;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Microsoft {
	
	@Test
	public void main() throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.microsoft.com/en-in/");
		
		//parent window Id
		String pWid = driver.getWindowHandle();
		
		//scroll To "Windows 11 for business"
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int Y = driver.findElement(By.xpath("//h3[contains(.,'Windows 11 for business')]")).getLocation().getY();
		js.executeScript("window.scrollBy(0,"+Y+")");

				
		//Right clicking on learnMore Url
		WebElement target = driver.findElement(By.xpath("//h3[contains(.,'Windows 11 for business')]/parent::div[@class='card-body  pt-3']/following-sibling::div/div/a[contains(.,'Learn more')]"));
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
		
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_T);
		
		//all window Ids
		Set<String> allWid = driver.getWindowHandles();
		
		for(String wid : allWid) {
			if(!wid.equals(pWid)) {
				driver.switchTo().window(wid);		//switching id
			}
		}
		
		String expectedTitle = "Windows for Business | Microsoft";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);			//comparing
		
		//switching control back to parent frame
		driver.switchTo().window(pWid);	
				
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 	//scroll to the bottom of a webpage
		//js.executeScript("window.scrollTo(0,0)");				//scroll to the top of a webpage
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Back to top')]")).click();		//Clicking on BackToTop button
		
		driver.quit();
	}
}
