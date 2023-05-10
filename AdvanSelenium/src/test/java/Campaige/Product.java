package Campaige;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Product {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		
		//to login
		driver.get(url);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Random ran=new Random();
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		//to fetch name from xl sheet
		FileInputStream fos=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book=WorkbookFactory.create(fos);
		Sheet sheet=book.getSheet("campaign");
		Row row=sheet.getRow(0);
		Cell cell=row.getCell(1);
		
		//+ranNum is added along with name
		String Exceldata=cell.getStringCellValue()+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys("Exceldata");
		
		//fetching + from page
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//switching to new page
		Set<String> allwin=driver.getWindowHandles();
		Iterator<String> id=allwin.iterator();
		while(id.hasNext())
				{
			String wid=id.next();
			driver.switchTo().window(wid);
			String title=driver.getTitle();
			if(title.contains("product&actions"))
			{
				break;
			}
				}
		
		driver.findElement(By.name("search")).click();
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		

	}

}
