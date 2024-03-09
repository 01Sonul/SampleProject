package Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Amazon_Brand_Incomplete {
	
	@Test
	public void main() {
		
		String Phone = "Samsung";
		String brandName = "Samsung";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		
		//searching Phone
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(""+Phone+"");
		driver.findElement(By.id("nav-search-submit-button")).click();

		//scrolling to Deals & Discounts
		Actions a = new Actions(driver);
		WebElement dealsAndDiscounts = driver.findElement(By.xpath("//div[@class='s-desktop-width-max s-desktop-content s-opposite-dir s-wide-grid-style sg-row']/div[2]/div/div[3]/span/div/div/div/descendant::span[text()='Deals & Discounts']"));
		a.scrollToElement(dealsAndDiscounts);
		System.out.println("Scrolled");
		
		//Ticking CheckBox of the given brandName
		//div[@class='s-desktop-width-max s-desktop-content s-opposite-dir s-wide-grid-style sg-row']/div[2]/div/div[3]/span/div/div/div/descendant::span[text()='Brand']/parent::div/following-sibling::ul/span/span/li/span/a/span[contains(.,'Apple')]/preceding-sibling::div/descendant::input[@type='checkbox']
		WebElement brand = driver.findElement(By.xpath("//div[@class='s-desktop-width-max s-desktop-content s-opposite-dir s-wide-grid-style sg-row']/div[2]/div/div[3]/span/div/div/div/descendant::span[text()='Brand']/parent::div/following-sibling::ul/span/span/li/span/a/span[contains(.,'"+brandName+"')]/preceding-sibling::div/descendant::input[@type='checkbox']"));
		brand.click();
		
		driver.quit();
	
	}

}
