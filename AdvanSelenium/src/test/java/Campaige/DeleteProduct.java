package Campaige;
import java.io.FileInputStream;

import java.util.List;
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
import org.openqa.selenium.edge.EdgeDriver;

import POMRepo.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import GenericUtility.WebDriverUtility;


public class DeleteProduct {
	
	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
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
		
		//from pom login
		Login login=new Login(driver);
		login.loginToApp(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Products");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String Exceldata = cel.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("productname")).sendKeys(Exceldata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
        
       driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+Exceldata+"']/../preceding-sibling::td[2]")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        
        
        //from Webdriverutility
        WebDriverUtility wlib=new WebDriverUtility();
        wlib.alertAccept(driver);
        
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
//    
       List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
        
        boolean flag=false;
        for(WebElement wb:Lists)
        {
        	String act = wb.getText();
        	if(act.contains(Exceldata))
        	{
        		flag=true;
        		break;
        	}
        	}
        if(flag)
        {
        	System.out.println("deleted");
        	 }
        else
        {
        	System.out.println("not deleted");
        }
        }
        }
	
	

