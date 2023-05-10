package GenericUtility;

import java.util.Iterator;

import java.util.Set;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;



public class WebDriverUtility {
	public void getWindowMax(WebDriver driver) 
	{	
		// TODO Auto-generated method stub
		driver.manage().window().maximize();	
	}
	
	public void switchingWindow(WebDriver driver,String partialtext)
	{
	Set<String> allWin=driver.getWindowHandles();
    Iterator<String> id=allWin.iterator();
    while(id.hasNext())
    {
    	String wid=id.next();
    	driver.switchTo().window(wid);
    	String title=driver.getTitle();
    	if(title.contains(partialtext))
    	{
    		break;
    	}
    }

	}
	public void alertAccept(WebDriver driver)
	{
		 Alert alt = driver.switchTo().alert();
         alt.accept();
	}
	public void alertDismiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
        alt.dismiss();
	}
	
	//sweitchframe
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	
	//dropdown
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	//mouse over action
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	//right click element
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	//move by offset
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	
	//screenshot
public  String takeScreenshot(WebDriver sDriver, String methodName) {
		
		Date date=new Date();
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}
	

}
