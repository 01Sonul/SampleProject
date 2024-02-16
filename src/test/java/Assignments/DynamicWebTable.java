package Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DynamicWebTable {
	
	@Test
	public void main() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/HP/eclipse-workspace/SampleProject/src/test/java/Assignments/dynamicWebTable.html");
		
		
		WebElement msg2 = driver.findElement(By.xpath("//table/tbody/tr[2]/th[2]"));

		WebElement msg2CheckBox = driver.findElement(By.xpath("//table/tbody/tr[2]/th[1]"));

		WebElement msg2Delete = driver.findElement(By.xpath("//table/tbody/tr[2]/th[3]/a"));

		
		if(msg2.isDisplayed()) {
			System.out.println("msg2 available");
			msg2CheckBox.click();
			Thread.sleep(2000);
			msg2Delete.click();
			Thread.sleep(2000);
		}
		else {
			System.out.println("msg2 not available");
		}	
		driver.quit();
	}
}


