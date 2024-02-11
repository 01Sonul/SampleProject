package Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicHtml {
	
	@Test
	public void main() {
		
		String name1 = "Sonul";
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/HP/eclipse-workspace/SampleProject/src/test/java/Assignments/dynamic.html");	//filePath
		
		WebElement n1 = driver.findElement(By.xpath("//a[contains(.,'"+name1+"')]/following-sibling::input"));	//textbox
		n1.sendKeys("admin");			
	}

}


