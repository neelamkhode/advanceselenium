package Campaige;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import POMRepo.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaige extends BaseClass {
	
	@Test(groups="RegressionTesting")
	
public void createCampaige() throws Throwable {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//FileInputStream fis=new FileInputStream("./src/test/resources/commondatafile.properties");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		//frompomlogin
		Login login=new Login(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);

		FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("campaign");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		
		String excelData = cel.getStringCellValue()+RanNum;
        driver.findElement(By.name("campaignname")).sendKeys(excelData);
        
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		 
		 
		 
//		if(actData.contains(excelData))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		
		WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(data).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		}
	
	

}
