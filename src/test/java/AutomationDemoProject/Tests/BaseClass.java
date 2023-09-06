package AutomationDemoProject.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import AutomationDemoProject.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readconfig= new ReadConfig();
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	String useremail=readconfig.getEmail();
	String passwrd=readconfig.getPassword();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("C:\\Users\\user\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
	public void captureScreenshot() throws IOException {
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("/Users/user/eclipse-workspace/AutomationDemoProject/Screenshots/" + "fail" + this.getClass().getName() + "_" + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	

}
