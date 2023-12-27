package prudhvi.Seleniumframeworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prudhvi.Abstractomponents.AbstarctComponents;

public class CartPage extends AbstarctComponents 
{
	@FindBy(css =".totalRow button")
	WebElement Checkoutele;
	@FindBy(xpath= "//*[@class='cartSection']/h3")
	
	 private List<WebElement> ProductTiles;
	
	public CartPage(WebDriver driver)
	{
		///Initialize the web driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productName)
	{
	
	boolean match = ProductTiles.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public CheckoutPage  goToCheckout()
	{
		Checkoutele.click();
		return new CheckoutPage(driver);
		
	}
}

