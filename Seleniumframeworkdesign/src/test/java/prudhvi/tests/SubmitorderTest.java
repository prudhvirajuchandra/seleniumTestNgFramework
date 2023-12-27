package prudhvi.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import prudhvi.Seleniumframeworkdesign.pageobjects.CartPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.CheckoutPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ConfirmationPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.OrderPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ProductCatalogue;
import prudhvi.TestComponents.BaseTest;

public class SubmitorderTest  extends BaseTest{
	String product = "IPHONE 13 PRO";

	@Test(dataProvider = "getData",groups = "Purchase")	
	public  void Submitorder(HashMap<String,String> input) throws InterruptedException, IOException  {
		// TODO Auto-generated method stub
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"),input.get("Password"));
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement>products =  productcatalogue.getproductList();	
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartpage = productcatalogue.goToCartPage();
		//CartPage cartpage = new CartPage(driver);
		Boolean Match = cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(Match);
		CheckoutPage Checkoutpage = cartpage.goToCheckout();
		Checkoutpage.SelectCountry("India");
		ConfirmationPage ConfirmationPage = Checkoutpage.SubmitOrder();
		String ConfirmationMessage = ConfirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods = {"Submitorder"})
	
	public void OrderHistoryTest()
	{
		// Once you add the order we cancheck yhe My order History Page while corrrect order can add the Orders or not
		ProductCatalogue productcatalogue = landingpage.loginApplication("zraj231640@gmail.com","Dreambig@2023");
		OrderPage orderspage = productcatalogue.goToOrdersPage();
		Assert.assertTrue(orderspage.VerifyOrderDisplay(product));
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	
	{
		
		 List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//prudhvi//data/PurchaseOrder.json");
		
		
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	/*HashMap<String,String> map = new  HashMap<String,String>();
		map.put( "email","anshika@gmail.com");
		map.put("Password","Iamking@000");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new  HashMap<String,String>();
		map1.put( "email","zraj231640@gmail.com");
		map1.put("Password","Dreambig@2023");
		map1.put("product", "ZARA COAT 3");*/
	
	//@DataProvider
	//public Object[][] getData()
	
	//{
		
	//	return new Object[][] {{"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"},{"zraj231640@gmail.com","Dreambig@2023","IPHONE 13 PRO"}};
	//}
}
	
		
		
		//ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "/Users/prudhvirajgopilli/Desktop/prudhvi/chromedriver_mac_arm64");
				
				
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client");
		//landingpage landingpage = launchApplication();
				

		
		//driver.findElement(By.id("userEmail")).sendKeys("zraj231640@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Dreambig@2023");
		
		//driver.findElement(By.id("login")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		
		
		
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b"))
			//	.getText().equals(productname)).findFirst().orElse(null);
		
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//Thread.sleep(2000);
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//List<WebElement> cartitems = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		
		//boolean match = cartitems.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		
		//Assert.assertTrue(match);
		
		//driver.findElement(By.cssSelector(".totalRow button ")).click();
		
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
		//Actions a = new Actions(driver);
		//a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		//driver.findElement(By.cssSelector(".action__submit")).click();
		 //String confirmmesssage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		 //Assert.assertTrue(confirmmesssage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 //driver.quit();
		
		

	


