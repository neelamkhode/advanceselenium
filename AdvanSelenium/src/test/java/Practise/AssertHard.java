package Practise;

import org.testng.annotations.Test;
import org.testng.Assert;

public class AssertHard {
	
	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals(true,true);
		System.out.println("step4");
		
	}

}
