package GenericUtility;

import java.util.Random;

public class JavaUtility {
	public int getrandomNum()
	{
	
	Random ran=new Random();
	int ranNum = ran.nextInt(1000);
	return ranNum;

}
}
