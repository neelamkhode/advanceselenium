package New;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyBrowser {
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		//WebDriver driver=WebDriverManager.chromedriver().create();
		
		
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys("qsp");
		
		//to generate random numbers along with organisation name so that it should not show error
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		//to fetch name from xl sheet
		FileInputStream fos=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book=WorkbookFactory.create(fos);
		Sheet sheet=book.getSheet("organisation");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(2);
		
		//+ranNum is added along with name
		String Exceldata=cell.getStringCellValue()+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(Exceldata);
		
		//to save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		
		//to compare the header when created new
		String getdata=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(getdata.contains(Exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
		//logout
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	
		
		
		
	}

}
