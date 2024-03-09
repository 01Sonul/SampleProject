package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TokyoOlympics_Incomplete {
	
	@Test
	public void main() {
		
		String country = "India";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		//Handling Cookies
		for(;;) {
			try {
				WebElement acceptCookies = driver.findElement(By.xpath("//button[text()='Yes, I am happy']"));
				acceptCookies.click();
				break;
			} catch (Exception e) {
				continue;
			}
		}
		
		//scrolling to India
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions a = new Actions(driver);
		
		WebElement scrollToIndia = driver.findElement(By.xpath("//span[text()='India']"));
		a.scrollToElement(scrollToIndia);

		 
		//driver.findElement(By.xpath(""));
		
		//driver.quit();
		
	}
}
