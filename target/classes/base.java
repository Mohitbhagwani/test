package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{

	//defining complete machine path is bad practise so use user.dir
prop= new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");

prop.load(fis);
//String browserName=prop.getProperty("browser");
String browserName=System.getProperty("browser");
System.out.println(browserName);

if(browserName.contains("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java/resources//chromedriver");
	ChromeOptions option=new ChromeOptions();

	 /*WebDriverManager.chromedriver().setup();*/
	// driver = new ChromeDriver();

	
	if(browserName.contains("headless")) {
	option.addArguments("headless");
	 
	}
	driver= new ChromeDriver(option);
	
		//execute in chrome driver    // //WebDriverManager.chromedriver().setup(); 
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}


}
