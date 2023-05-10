package New;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		FileInputStream fos=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book=WorkbookFactory.create(fos);
		Sheet sheet=book.getSheet("contact");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(2);
		
		String Exceldata=cell.getStringCellValue()+ranNum;
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Exceldata);
		
		
		//to save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(Exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		//WebElement data=driver.findElement(By.xpath("//input[@src='themes/softed/images/user.PNG']")).click();
		//Actions act=new Actions(driver);
		//act.moveToElement(data).perform();
		
		
		

	}

}
