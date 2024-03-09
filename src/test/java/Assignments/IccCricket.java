package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IccCricket {
	
	@Test
	public void main() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.icc-cricket.com/rankings");
		driver.manage().deleteAllCookies();
		
		//Accepting Cookies
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@class='ot-sdk-container']/descendant::button[contains(.,'Accept All Cookies')]")).click();
				break;
			}catch(Exception e){
				continue;
			}
		}
		
		//clicking on Men's batting ranking link
		driver.findElement(By.xpath("//a[@alt='mens-batting-rankings']")).click();
		
		//ODI - BATTING RANKINGS
		//Common xpath of 4th player
		//div[@id='mens-batting-rankings']/descendant::div[@class='si-table-head odi']/parent::div[@class='si-table swiper-slide']/div[2]/div[4]

		//4th player's name
		WebElement playerName = driver.findElement(By.xpath("//div[@id='mens-batting-rankings']/descendant::div[@class='si-table-head odi']/parent::div[@class='si-table swiper-slide']/div[2]/div[4]/div[2]/descendant::a[@class='si-player-name-wrap']"));
		String name = playerName.getText();
		
		//4th player's rank
		WebElement playerRank = driver.findElement(By.xpath("//div[@id='mens-batting-rankings']/descendant::div[@class='si-table-head odi']/parent::div[@class='si-table swiper-slide']/div[2]/div[4]/div[3]/span[@class='si-text']"));
		String rank = playerRank.getText();
		
		System.out.println("4th player's name is "+ name);
		System.out.println("4th player's rank is "+ rank);
		
		driver.quit();
	}

}

