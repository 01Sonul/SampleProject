package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class BigBasket {
	
	@Test
	public void main() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.bigbasket.com/");
		
		//Catagory Button
		driver.findElement(By.id("headlessui-menu-button-:R5bab6:")).click();
		
		Actions actions = new Actions(driver);

		//1st Block
		List<WebElement> targetBlock1 = driver.findElements(By.xpath("//header[2]/descendant::div/nav/ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/li[@class='jsx-1259984711']/a"));		
		
		for(WebElement target1 : targetBlock1) {
			actions.moveToElement(target1).perform();
			System.out.println(target1.getText());
			//2nd Block
			List<WebElement> targetBlock2 = driver.findElements(By.xpath("//header[2]/descendant::div/nav/ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']/li[@class='jsx-1259984711']/a"));
			
			for(WebElement target2 : targetBlock2) {
				actions.moveToElement(target2).perform();
				System.out.println(target2.getText());
				//3rd Block
				List<WebElement> targetBlock3 = driver.findElements(By.xpath("//header[2]/descendant::div/nav/ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']/li[@class='jsx-1259984711']/a"));
				
				for(WebElement target3 : targetBlock3) {
					actions.moveToElement(target3).perform();
					System.out.println(target3.getText());
				}
			}	
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
