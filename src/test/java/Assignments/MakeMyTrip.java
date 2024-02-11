package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
	
	@Test
	public void main(){									// ElementClickInterceptedException
		String City1 = "Bengaluru";
		String City2 = "Bhubaneswar";
		String Date = "25";
		String Month = "July";
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		
		
		//driver.findElement(By.xpath("//a[@class='close']/child::i[@class='wewidgeticon we_close']")).click();	//closing X
		
		
		//From
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(""+City1+"");
		driver.findElement(By.xpath("//p[contains(.,'" + City1 + "')]")).click();
				
		
		//To
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(""+City2+"");
		driver.findElement(By.xpath("//p[contains(.,'" + City2 + ", India')]")).click();
		
		
		//Departure
		for(;;) {
			try {
				//driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'July')]/descendant::p[text()='25']")).click();
				driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+Month+"')]/descendant::p[text()='"+Date+"']")).click();
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				continue; 
			}
		}
		
		
		//Travellers & Class
		driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
		//Increasing Adult to 2
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		//Apply Button
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		//Search Button
		driver.findElement(By.xpath("//p[contains(.,'Search')]")).click();
		
		
		//closing X
		for(;;) {
			try {
				driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
				break;
			}
			catch(Exception e) {
				continue;
			}	
		}
		
		

	}	
}




