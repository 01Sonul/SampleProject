package Assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DDTFaceBook {
	
	@Test
	public void main() throws IOException  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		
		//get the java representative object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/FacebookDDT.xlsx");
		
		//Creating the Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//getting the last row num which contains data
		int count = wb.getSheet("login").getLastRowNum();
		
		//getting the control on row, cell & read the data
		for(int i=1; i<=count; i++) {
			String Un = wb.getSheet("login").getRow(i).getCell(0).getStringCellValue();
			String Pwd = wb.getSheet("login").getRow(i).getCell(0).getStringCellValue();
			
			//un txtBox
			WebElement unTxtBox = driver.findElement(By.xpath("//input[@name='email']"));
			unTxtBox.sendKeys(Un);
			//pwd txtBox
			WebElement pwdTxtBox = driver.findElement(By.xpath("//input[@name='pass']"));
			pwdTxtBox.sendKeys(Pwd);
			
			unTxtBox.clear();
			pwdTxtBox.clear();
			
			System.out.println("Total User Persents: " + count);
			System.out.println(Un + "/t" + Pwd);
		}
		
		driver.quit();
	}

}
