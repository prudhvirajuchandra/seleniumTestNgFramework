package prudhvi.Seleniumframeworkdesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prudhvi.Abstractomponents.AbstarctComponents;

public class ConfirmationPage extends AbstarctComponents {
	WebDriver driver ;
	
	//constructor cretae
	
	public ConfirmationPage (WebDriver driver)
	{
		///intializw the web driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement ConfirmationMessage;
	
	public  String getConfirmationMessage() 
	{
		return ConfirmationMessage.getText();
	}
	

}
