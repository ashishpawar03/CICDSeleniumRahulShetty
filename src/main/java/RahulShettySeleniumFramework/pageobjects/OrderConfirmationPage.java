package RahulShettySeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	    WebDriver driver;
	    String confirmMessage="";

		public OrderConfirmationPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(css=".hero-primary")
		WebElement orderConfirmationText;
		
		
		 public String verifyOrderDetailsPageText()
		 {
			 confirmMessage = orderConfirmationText.getText().trim();
			 return confirmMessage;
		 }

}
