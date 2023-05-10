package GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
		String testname=result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("./Screenshot/"+testname+".png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
