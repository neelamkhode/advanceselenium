package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderex {
	@Test(dataProvider="dataProviderMethod")
	
	
	public void bookTickets(String src,String des) {
	

		System.out.println("book tickets from "+src+ " to " +des);
	}

	@DataProvider
	public Object[][] dataProviderMethod()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="bang";
		obj[0][1]="goa";
		
		obj[1][0]="bang";
		obj[1][1]="hyd";
		return obj;
		
		
	}
	
	

	
}
