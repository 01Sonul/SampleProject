package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cricbuzz {
	
	@Test
	public void main() {
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/86728/indu19-vs-ausu19-final-icc-under-19-world-cup-2024");
		
		
		WebElement runsOfHS = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div[6]/div[3]"));		//Runs of Harjas Singh
		WebElement srOfTS = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div[11]/div[7]"));		//SR of Tom Straker
		WebElement dnb = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div[14]/div[2]"));		//did not bat
		
		System.out.println("Runs of Harjas Singh: " + runsOfHS.getText());
		System.out.println("Strike Rate of Tom Straker: " + srOfTS.getText());
		System.out.println("Players who didnot bat: " + dnb.getText());
		
		driver.quit();
	}

}
