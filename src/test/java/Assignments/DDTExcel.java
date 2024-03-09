package Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DDTExcel {
	
	@Test
	public void main() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver. manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.nseindia.com/market-data/live-equity-market?symbol=NIFTY%2050");
		
		//company names
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@id='equityStockTable']/tbody/tr[@class='freezed-row']/following-sibling::tr/td[1]/a"));			
		//high values
		List<WebElement> highVals = driver.findElements(By.xpath("//table[@id='equityStockTable']/tbody/tr[@class='freezed-row']/following-sibling::tr/td[3]"));
		
		//for scrolling down the table
		Actions a = new Actions(driver);
		WebElement scrollToNote = driver.findElement(By.xpath("//div[@id='marketWatchEquityCmsNote']/descendant::span[contains(.,'Note')]"));
		a.scrollToElement(scrollToNote).perform();	
		
		//getting the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT.xlsx");
		//Creating the Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		for(int i =1; i< companyNames.size(); i++) {
			String company = companyNames.get(i).getText();
			wb.getSheet("Sheet1").createRow(0).createCell(0).setCellValue("*Company*");
			wb.getSheet("Sheet1").getRow(i).getCell(0).setCellValue(company);
			wb.getSheet("Sheet1").getRow(0).createCell(1).setCellValue("*High Value*");
			wb.getSheet("Sheet1").getRow(i).getCell(1).setCellValue(highVals.get(i).getText());
			
			//getting the physical file toh java represantaion object
			FileOutputStream fos = new FileOutputStream("./src/test/resources/DDT.xlsx");
			wb.write(fos);
			
		}
		driver.quit();
	}
}

