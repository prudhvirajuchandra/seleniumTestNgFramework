package prudhvi.Seleniumframeworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prudhvi.Abstractomponents.AbstarctComponents;

public class OrderPage extends AbstarctComponents 
{
	@FindBy(css =".totalRow button")
	WebElement Checkoutele;
	@FindBy(css= "tr td:nth-child(3)")
	
	 private List<WebElement> ProductNames;
	
	public OrderPage(WebDriver driver)
	{
		///Initialize the web driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyOrderDisplay(String productName)
	{
	
	boolean match = ProductNames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	return match;
	}
	
}

