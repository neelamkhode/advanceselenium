package Campaige;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import GenericUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import GenericUtility.WebDriverUtility;
import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import POMRepo.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMRepo.Login;

import POMRepo.OrganizationCreationPage;



//@Listeners(GenericUtility.ListenerImp.class)
public class CreateOrganization extends BaseClass{

	@Test(groups="SmokeTesting")
	public void createOrganization() throws Throwable


{
	
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	WebDriverUtility wlib=new WebDriverUtility();
	wlib.getWindowMax(driver);
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//FileInputStream fis=new FileInputStream("./src/test/resources/commondatafile.properties");
	//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	//Properties pro=new Properties();
	//pro.load(fis);
	//String URL = pro.getProperty("url");
	//String USERNAME = pro.getProperty("username");
	//String PASSWORD = pro.getProperty("password");
	
	
	//import the above from PropertyUtility
	PropertyUtility plib=new PropertyUtility();
	String URL=plib.getStringKeyAndValue("url");
	String USERNAME=plib.getStringKeyAndValue("username");
	String PASSWORD=plib.getStringKeyAndValue("password");
	
	
	
	driver.get(URL);
	
	//from pom login
	Login login=new Login(driver);
	login.loginToApp(USERNAME, PASSWORD);
	
	
	
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
	//fromHomepage
	HomePage home=new HomePage(driver);
	home.clickOrganizationsLinkText();
//	driver.findElement(By.linkText("Organizations")).click();
	
	//from organisationcreation page
	OrganizationCreationPage org=new OrganizationCreationPage(driver);
	org.clickOrganizationCreateImage();
	
	
//	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//Random ran=new Random();
	//int ranNum = ran.nextInt(1000);
	//random from javaUtility
	JavaUtility jlib=new JavaUtility();
	int ranNum=jlib.getrandomNum();
	
	//excelUtility to fetch data
	ExcelUtility elib=new ExcelUtility();
	String Exceldata=elib.getExceldata("Organisation",1,2)+ranNum;
	String phoneNum = elib.getExcelDataFormatter("Organisation", 2, 0);
	
	
	
	/*FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet("Organisation");
	Row row = sheet.getRow(1);
	Cell cel = row.getCell(2);
	String Exceldata = cel.getStringCellValue()+ranNum;*/
	
	driver.findElement(By.name("accountname")).sendKeys(Exceldata);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	Thread.sleep(1000);


	String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 
	if(actData.contains(Exceldata))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
	WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(data).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	}
  
}

