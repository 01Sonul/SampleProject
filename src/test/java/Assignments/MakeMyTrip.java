package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTrip {
	
	@Test
	public void main(){
		String City1 = "Bengaluru";
		String City2 = "Bhubaneswar";
		String Date = "25";
		String Month = "July";
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		
		
		//Handling Frame
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(iframe);
		WebElement X = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
		X.click();
		driver.switchTo().defaultContent();
		
		
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
		
		//for scrolling down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions a= new Actions(driver);
		
		for(;;) {
			try {
				WebElement scrollToTop = driver.findElement(By.xpath("//font[text()='SCROLL TO TOP']"));
				a.scrollToElement(scrollToTop);
				
				//fetching prices
				List<WebElement> totalFlightPrices = driver.findElements(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
				//System.out.println("Total Flight Prices are " + totalFlightPrices.size());
				
				//fetching names
				List<WebElement> totalFlightNames = driver.findElements(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']/ancestor::div[@class='makeFlex spaceBetween']/descendant::p[@class='boldFont blackText airlineName']"));
				//System.out.println("Total Flight Names are " + totalFlightNames.size());
				
				for(int j=0; j<totalFlightPrices.size(); j++) {
					String txtPrice = "";
					String Price = totalFlightPrices.get(j).getText();
					
					for(int i = 0; i<Price.length();i++) {
						if(Price.charAt(i)>= '0' && Price.charAt(i)<= '9') {
							txtPrice = txtPrice + Price.charAt(i);
						}
					}
					
					int intPrice = Integer.parseInt(txtPrice);
					String strName = totalFlightNames.get(j).getText();
					System.out.println(strName +" -> "+ intPrice);
				}
				break;
			}
			
			catch(Exception e){
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
			}
		}
		driver.quit();
	}	
}
