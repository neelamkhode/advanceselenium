package Practise;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(priority=1)
	public void createcontact()
	{
		System.out.println("created");
	}
	@Test(priority=0)
	public void modifycontact()
	{
		System.out.println("created");
	}
	
}
