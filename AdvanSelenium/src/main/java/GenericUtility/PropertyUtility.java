package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	public String getStringKeyAndValue(String Key) throws IOException {
		/**
		 * this methode to launch application
		 */
		
		
		//to import from here to all pgms
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String value=pro.getProperty(Key);
				return value;
		// TODO Auto-generated method stub

	}

}
