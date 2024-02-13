package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart {
	
	@Test
	public void main() {
		String phone = "IPhone 15";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		
		
		WebElement searchTxtBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));	//search TextBox
		searchTxtBox.sendKeys(""+phone+"");;
		searchTxtBox.sendKeys(Keys.ENTER);
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;		//for scrolling down to next
		Actions a= new Actions(driver);
		
		int count = 0;
		for(;;){
			//all Names of the Product
			List<WebElement> totalProducts = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

			for(WebElement e : totalProducts){
				count++;
			}
			
			try {
				WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
				a.scrollToElement(nextButton).click();
				Thread.sleep(2000);
				nextButton.click();
				
			} catch (Exception e) {
				
				break;		
			}
		}
		System.out.println("Total products are " + count);
		driver.quit();	
	}
}
