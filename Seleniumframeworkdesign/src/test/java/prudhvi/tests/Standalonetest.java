package prudhvi.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productname = "ZARA COAT 3";
		
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/prudhvirajgopilli/Desktop/prudhvi/chromedriver_mac_arm64");
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		Landingpage landingpage = new Landingpage(driver);

		
		driver.findElement(By.id("userEmail")).sendKeys("zraj231640@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dreambig@2023");
		
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		
		
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartitems = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		
		boolean match = cartitems.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button ")).click();
		
		/*driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(By.cssSelector(".ta-results"));
		
		for(WebElement option: options)	
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}*/
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		 String confirmmesssage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		 Assert.assertTrue(confirmmesssage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 driver.quit();
		
		

	}

}
