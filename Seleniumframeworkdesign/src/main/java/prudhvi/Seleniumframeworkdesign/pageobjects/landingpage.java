package prudhvi.Seleniumframeworkdesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prudhvi.Abstractomponents.AbstarctComponents;

public class landingpage extends AbstarctComponents  {

		// TODO Auto-generated method stub

		WebDriver driver ;
		
		//constructor cretae
		
		public landingpage(WebDriver driver)
		{
			///intializw the web driver
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;
		
		@FindBy(id="login")
		WebElement Submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement ErrorMessage;
		
		
		public ProductCatalogue loginApplication(String Email ,String Password)
		
		{
			userEmail.sendKeys(Email);
			userPassword.sendKeys(Password);
			Submit.click();
			ProductCatalogue productcatalogue = new ProductCatalogue(driver);
			return productcatalogue;
		}
		
		public String geterrrorMessage() 
		{
			ErrorMessage.getText();
			waitforWebElementtoAppear(ErrorMessage);
			return ErrorMessage.getText();
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");

		}
	}


