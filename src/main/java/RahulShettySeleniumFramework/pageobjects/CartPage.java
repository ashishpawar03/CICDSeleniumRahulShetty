package RahulShettySeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
     @FindBy(css=".cartSection h3")
     List<WebElement> allCartProduct;
     
     @FindBy(xpath="//div[@class='subtotal cf ng-star-inserted']/descendant::button")
     WebElement checkoutButton;
     
     
     
		     public boolean verifyCartProduct(String prodName)
		     {
		    	 for(WebElement cartProd:allCartProduct)
		 			{
		 				System.out.println("Cart Prod text ="+cartProd.getText());
		 				String cartProductName=cartProd.getText();
		 						
		 				if(cartProductName.equals(prodName))
		 				{
		 					return true;
		 					
		 				}
		 			}
				return false;
		     }
     
     
		     public CheckoutPage goTocheckout()
		     {
		    	 checkoutButton.click();
		    	 CheckoutPage checkoutPage = new CheckoutPage(driver);
		    	 return checkoutPage;
		     }
		     
		     
		     
		     public boolean verifyCartProduct1(String prodName)
		     {
		    	 return allCartProduct.stream().anyMatch(prodname -> prodname.getText().equals(prodName));	
				 
		     }
		     
		     
}
    
