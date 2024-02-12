package Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	
	@Test()
	public void iPhone14() {
		
		String Phone = "iPhone 15";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		
		
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(""+Phone+"");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		//fetching price
		//xpath for price(static)
		//WebElement phonePrice = driver.findElement(By.xpath("//span[text()='Sponsored']/ancestor::div[@class='a-row a-spacing-micro']/following-sibling::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[text()='Apple iPhone 15 (256 GB) - Blue']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		//xpath for price(Dynamic)
		WebElement phonePrice = driver.findElement(By.xpath("//span[text()='Sponsored']/ancestor::div[@class='a-row a-spacing-micro']/following-sibling::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[text()='Apple "+Phone+" (256 GB) - Blue']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		String strphonePrice = phonePrice.getText();
		System.out.println("Price of the phone is " + strphonePrice);
		
		driver.quit();
	}
	
}
