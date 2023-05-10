package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smokeTesting","RegressionTesting"})
	public void BS()
	{
		System.out.println("Data connection");
	}
	
	@BeforeTest(groups= {"smokeTesting","RegressionTesting"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	//@Parameter(BROWSER)
	@BeforeClass(groups= {"smokeTesting","RegressionTesting"})
	public void BC()
	{
		sdriver=driver;
		System.out.println("Launching the browser");
//		if(BROWSER.equalsIgnoreCase("Chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new FirefoxDriver();
//		}
	}
	
	@BeforeMethod(groups= {"smokeTesting","RegressionTesting"})
	public void BM()
	{
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups= {"smokeTesting","RegressionTesting"})
	public void AM()
	{
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups= {"smokeTesting","RegressionTesting"})
	public void AC()
	{
		System.out.println("close the browser");
	}
	
	@AfterTest(groups= {"smokeTesting","RegressionTesting"})
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	
	@AfterSuite(groups= {"smokeTesting","RegressionTesting"})
	public void AS()
	{
		System.out.println("database closed");
	}
	
	
}
