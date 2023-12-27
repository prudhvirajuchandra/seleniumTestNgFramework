package prudhvi.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import prudhvi.Seleniumframeworkdesign.pageobjects.landingpage;

public class BaseTest {
	public WebDriver driver ;
	public landingpage landingpage;
	
	public  WebDriver  intializeDriver() throws IOException 
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//prudhvi//resources//GlobalData.properties");
		prop.load(fis);
		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.contains("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
				
			if(BrowserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			
			driver.manage().window().setSize(new Dimension(1440,990));
			//System.setProperty("webdriver.chrome.driver", "/Users/prudhvirajgopilli/Desktop/prudhvi/chrome-mac-arm64");
			
		}
	
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			//FirefoxDriver driver = new FirefoxDriver();
			//System.setProperty("webdriver.firefox.driver", "/Users/prudhvirajgopilli/Desktop/prudhvi/chromedriver_mac_arm64");
		}	
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			//EdgeDriver driver = new EdgeDriver();
			//System.setProperty("webdriver.edge.driver", "/Users/prudhvirajgopilli/Desktop/prudhvi/chromedriver_mac_arm64");
		}	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		return driver;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	

	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}

	
	@BeforeMethod(alwaysRun=true)
	
	public landingpage launchApplication() throws IOException 
	{
		 driver = intializeDriver();
		 landingpage = new landingpage(driver);
		landingpage.goTo();
		return landingpage;
	
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
		

	}
