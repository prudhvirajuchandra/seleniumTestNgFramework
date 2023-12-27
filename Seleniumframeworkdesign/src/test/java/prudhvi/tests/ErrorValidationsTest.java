package prudhvi.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import prudhvi.Seleniumframeworkdesign.pageobjects.CartPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.CheckoutPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ConfirmationPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ProductCatalogue;
import prudhvi.Seleniumframeworkdesign.pageobjects.landingpage;
import prudhvi.TestComponents.BaseTest;
import prudhvi.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {
	
@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	
	public  void LoginPageErrorValidation() throws InterruptedException, IOException  {
		// TODO Auto-generated method stub


	
		
		//String productName = "IPHONE 13 PRO";
		landingpage.loginApplication("zraj0@gmail.com","Dream2023");
		//System.out.println(landingpage.geterrrorMessage());
		Assert.assertEquals("Incorrect email or password.", landingpage.geterrrorMessage());
				
}
@Test

public  void ProductErrorValidation() throws InterruptedException, IOException  {
	// TODO Auto-generated method stub
	
	String productName = "IPHONE 13 PRO";
	//landingpage landingpage = launchApplication();
	ProductCatalogue productcatalogue = landingpage.loginApplication("zraj231640@gmail.com","Dreambig@2023");
	//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
	List<WebElement>products =  productcatalogue.getproductList();	
	productcatalogue.addProductToCart(productName);
	CartPage cartpage = productcatalogue.goToCartPage();
	//CartPage cartpage = new CartPage(driver);
	Boolean Match = cartpage.verifyProductDisplay("IPHONE 113 PRO");
	Assert.assertFalse(Match);
	
}
}
