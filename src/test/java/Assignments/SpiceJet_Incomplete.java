package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpiceJet_Incomplete {
	
	@Test
	public void main() throws InterruptedException {
		
		String City1 = "Blr";
		String City2 = "Del";
		String Date = "10";
		String Month = "June";
		
		ChromeOptions option = new ChromeOptions();
		//option.addArguments("--headless");			//used to execute a program without opening chrome
		option.addArguments("--disable-notifications");		//Ex. of method overloading
		WebDriver driver= new ChromeDriver(option);		//Ex. for constructor overloading
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		
		
		//fromCity
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys(""+City1+"");
		
		//toCity
		driver.findElement(By.xpath("//div[text()='To']")).click();
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys(""+City2+"");
		
		//DepartureDate
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/div/div[contains(.,'"+Month+"')]/parent::div[@class='css-1dbjc4n r-k8qxaj']/following-sibling::div[@class='css-1dbjc4n']/descendant::div[text()='"+Date+"']")).click();
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//div[@class='r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-1i6wzkk r-lrvibr r-184en5c css-1dbjc4n']")).click();
				continue; 
			}
		}
		
		//Passengers
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/div[contains(.,'Adult')]")).click();
		//Increasing Adult to 2
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		
		//For scrolling down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions a= new Actions(driver);
		
		//Click on Done
		WebElement scrollToDone = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']"));
		a.scrollToElement(scrollToDone);
		Thread.sleep(1500);
		scrollToDone.click();
		
		//Selecting Student Radio Button
		driver.findElement(By.xpath("//div[text()='Students']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/div[1]")).click();
		
		//Search Flight Button
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		//driver.findElement(By.xpath("//div[text()='Search Flight']")).click();
		
		
		//Closing X
			//try {
				driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-ubezar r-16dba41']/preceding-sibling::div[@class='css-1dbjc4n r-zso239']")).click();
				
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-f9v2oj r-1a852e4 r-1609sg0 r-1pcd2l5 r-1mdbw0j r-hnxvie']/descendant::div[@class='css-76zvg2 r-jwli3a r-1enofrn r-1kfrs79']")).click();

				//div[@class='css-76zvg2 r-jwli3a r-1enofrn r-1kfrs79']
				//div[@class='css-76zvg2 r-jwli3a r-1enofrn r-1kfrs79' and contains(.,'Continue')]
				//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[contains(.,'Continue')]/div/div[2]
				
				
			//}catch(Exception e) {
				
			//}	
			
		
		//driver.quit();
			
	}

}
