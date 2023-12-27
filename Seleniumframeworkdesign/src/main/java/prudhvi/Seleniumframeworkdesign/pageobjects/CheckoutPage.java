package prudhvi.Seleniumframeworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import prudhvi.Abstractomponents.AbstarctComponents;

public class CheckoutPage extends AbstarctComponents 
{
	WebDriver driver ;
	
	public CheckoutPage(WebDriver driver)
	{
		///Initialize the web driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css =".action__submit")
	
	WebElement Submit;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	public void SelectCountry(String CountryName) 
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country,CountryName).build().perform();
		
		waitforElementtoAppear(By.cssSelector(".ta-results"));
		SelectCountry.click();
	
	}
	
	public ConfirmationPage  SubmitOrder()
	{
		Submit.click();
		return new ConfirmationPage(driver);
	}
}
