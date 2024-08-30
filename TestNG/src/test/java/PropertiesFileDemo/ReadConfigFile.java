package PropertiesFileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties properties;
	String path="C:\\Users\\vinay\\Desktop\\DemoTestMavenProject\\TestNG\\src\\test\\java\\PropertiesFileDemo\\ConfigText.txt";
     
	public ReadConfigFile() throws IOException {
		
		properties = new Properties();
		
		FileInputStream fis=new FileInputStream(path);
		
		properties.load(fis);
	}
	
	public String getURL()
	{
		String url=properties.getProperty("url");
		if(url!=null)
		{
			return url;
		}
		else
			throw new RuntimeException("url not specified in config file");
		
	}
	
	public String getusername()
	{
		String username=properties.getProperty("username");
		if(username!=null)
		{
			return username;
		}
		else
			throw new RuntimeException("username not specified in config file");
		
	}
	
	public String getpassword()
	{
		String password=properties.getProperty("password");
		if(password!=null)
		{
			return password;
		}
		else
			throw new RuntimeException("password not specified in config file");
		
	}



}
