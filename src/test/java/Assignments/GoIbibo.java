package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoIbibo {

	@Test
	public  void main() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		//ctrl+shift+i
		//ctrl+f
		driver.findElement(By.xpath("//span[@class='sc-gsFSXq bGTcbn']")).click();	//closing X(login/signup)
		
		Actions a = new Actions(driver);
		WebElement from= driver.findElement(By.xpath("//div[@class='sc-12foipm-34 iHoHRr'][1]"));	//from
		a.click(from).pause(Duration.ofMillis(500)).sendKeys("Bengaluru").perform();
		WebElement Bengaluru = driver.findElement(By.xpath("//span[text()=\"Bengaluru, India\"]"));
		a.click(Bengaluru).perform();	
		
		WebElement to= driver.findElement(By.xpath("//div[@class='sc-12foipm-34 iHoHRr'][2]"));	//to
		a.click(to).pause(Duration.ofMillis(500)).sendKeys("Bhubaneswar").perform();
		WebElement Bhubaneswar = driver.findElement(By.xpath("//span[text()=\"Bhubaneswar, India\"]"));
		a.click(Bhubaneswar).perform();
		
		WebElement departure = driver.findElement(By.xpath("//div[text()='March 2024']/ancestor::div[@class='DayPicker-Month']//p[text()='25']")); 	//departure
		departure.click();
		
		WebElement doneButton = driver.findElement(By.xpath("//span[text()='Done']"));	//doneButton
		doneButton.click();
		
		//WebElement plusAdults = driver.findElement(By.xpath(" //span[@class='sc-12foipm-65 dqoXYl' and text()='2']"));	//plusAdults
		//plusAdults.click();
		
		WebElement doneTAC = driver.findElement(By.linkText("Done")); 	//doneTAC(Travellers & Class)
		doneTAC.click();
		
		WebElement searchFlights = driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']"));	//searchFlights
		searchFlights.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		//using jsExecutor to scroll to travel_resources
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight"); //used for fast scrolling
		
		WebElement travel_resources = driver.findElement(By.xpath("//li[text()='travel resources']"));	//travel resources
		int y = travel_resources.getLocation().getY();		//fetching location of travel resources
		
		for (int i = 1; i <= y; i++) {
			js.executeScript("window.scrollBy(0," + i + ")");
		}
		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='srp-card-uistyles__Price-sc-3flq99-17 kxwFaC alignItemsCenter dF f600']"));	//allPrices
		System.out.println("Total Elements --> " + allPrices.size());
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (WebElement prc : allPrices) {
			String Price = prc.getText();
			String strPrice = Price.replaceAll(",", "");
			int intPrice = Integer.parseInt(strPrice);
			System.out.println(intPrice);
			al.add(intPrice);
		}
		
		Collections.sort(al);
		System.out.println("Least Flight Price-->" + al.get(0));

		driver.quit();
				
	}
	
}


