package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	
	public static Properties prop;
	
	public static Properties loadPropertyFile() throws Exception  {
		
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C://Users//IT//eclipse-workspace//policyboss-carinsurance//src//main//resources//configfile//config.properties");
		prop.load(fi);
		return prop;
		
	}
}
