package prudhvi.StepDefinitionns;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import prudhvi.Seleniumframeworkdesign.pageobjects.CartPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.CheckoutPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ConfirmationPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.ProductCatalogue;
import prudhvi.Seleniumframeworkdesign.pageobjects.landingpage;
import prudhvi.TestComponents.BaseTest;

public class StepDefinitionimpl extends BaseTest{
	
	
	
	public landingpage landingpage;
	public ProductCatalogue productcatalogue;
	public ConfirmationPage ConfirmationPage;
	@Given("I landed on Ecommerce page")
	
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingpage = launchApplication();
		
	}
	@Given ("^I logged in  with username <.+> and password <.+>$")
	
	public void logged_on_username_and_password(String username , String password)
	{
		productcatalogue = landingpage.loginApplication(username, password);
	}
	
	@When ("^I add product <.+> to cart$")
	
	public void I_add_product_to_cart(String productname) throws InterruptedException
	{
		List<WebElement>products =  productcatalogue.getproductList();	
		productcatalogue.addProductToCart(productname);
	}
	@And ("^checkout <.+> and submit the order$")
	public void checkout_submit_the_order(String productname)
	{
		  CartPage cartpage = productcatalogue.goToCartPage();
		 Boolean Match = cartpage.verifyProductDisplay(productname);
			Assert.assertTrue(Match);
			CheckoutPage Checkoutpage = cartpage.goToCheckout();
			Checkoutpage.SelectCountry("India");
			ConfirmationPage = Checkoutpage.SubmitOrder();
	}
	
	@Then  ("{String} is displayed on confirmation page")
	public void messsage_displayed_on_confirmationpage(String String)
	{
		String ConfirmationMessage = ConfirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(ConfirmationMessage.equalsIgnoreCase(String));
	}
}
