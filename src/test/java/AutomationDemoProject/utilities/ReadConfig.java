package AutomationDemoProject.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	
	//object of properties class
	
	Properties properties;
	String path="C:\\Users\\user\\eclipse-workspace\\AutomationDemoProject\\Configuration\\config.properties";
	
	
	//Object of FileInput stream and Properties -----Load the config file-----Constructor
	
	//Constructor
	
	public ReadConfig()  {
		try{properties=new Properties();
		FileInputStream fis=new FileInputStream(path);
		properties.load(fis);
	}catch(Exception e) {
		e.printStackTrace();
	}

}
	public String getBaseUrl() {
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in the config file");
	}
	
	public String getBrowser() {
		String browserValue=properties.getProperty("browser");
		if(browserValue!=null)
			return browserValue;
		else
			throw new RuntimeException("browser not specified in the config file");
	}
	
	public String getEmail() {
		String email=properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in the config file");
	}
	
	public String getPassword() {
		String password=properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in the config file");
	}
	
	
	
}
