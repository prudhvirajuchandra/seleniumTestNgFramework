package prudhvi.Abstractomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import prudhvi.Seleniumframeworkdesign.pageobjects.CartPage;
import prudhvi.Seleniumframeworkdesign.pageobjects.OrderPage;

public class AbstarctComponents  {
	protected WebDriver driver;


	public AbstarctComponents(WebDriver driver) 
	{
		this.driver = driver;	
		PageFactory.initElements(driver, this);

	}
	@FindBy(css ="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css ="[routerlink*='myorders']")
	WebElement Orderheader;
	
	
	
	

	public void waitforElementtoAppear( By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitforWebElementtoAppear( WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public  CartPage goToCartPage() 
	{
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;

	}
	public  OrderPage goToOrdersPage() 
	{
		Orderheader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;

	}
	
	
	

	public void waitforElementtoDisAppear( WebElement ele) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	

}
