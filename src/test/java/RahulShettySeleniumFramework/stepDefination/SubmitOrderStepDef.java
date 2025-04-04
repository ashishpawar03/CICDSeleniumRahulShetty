package RahulShettySeleniumFramework.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import RahulShettySeleniumFramework.pageobjects.CartPage;
import RahulShettySeleniumFramework.pageobjects.CheckoutPage;
import RahulShettySeleniumFramework.pageobjects.LandingPage;
import RahulShettySeleniumFramework.pageobjects.OrderConfirmationPage;
import RahulShettySeleniumFramework.pageobjects.ProductCatalogue;
import RahulShettySeleniumFramework.reusables.PageObjectReusable;
import RahulShettySeleniumFramework.testComponents.TestReusable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderStepDef extends TestReusable {
	
	public CartPage cartPage;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;
	public ProductCatalogue productCatalogue;
	public PageObjectReusable pageObjectReusable;
	public OrderConfirmationPage orderConfirmationPage;
	
	String confirmMessageText="";
	
	 @Given ("User land on Ecommerce website")
	 public void user_Land_On_Ecommerce_Website() throws IOException
	 {
		 landingPage=launchApplication();
	 }
	 
     @Given("^User enter username (.+) and password (.+)$")
     public void user_Enter_Username_And_Password(String username, String password)
     {
    	 productCatalogue=landingPage.loginAppication(username,password);
     }
     
     
     @When("^User search and add product (.+) in cart$")
     public void user_search_and_add_product_in_cart(String product)
     {
    	 productCatalogue.addToCart(product);
     }
     
     @And("User click on cart button")
     public void user_click_on_cart_button()
     {
    	 cartPage = productCatalogue.goToCartPage();
    	 
     }
     
     @Then("^User land on cart page and verify added product (.+)$")
     public void user_land_on_cart_page_and_verify_added_product(String product)
     {
    	 boolean matchFound = cartPage.verifyCartProduct(product);
// 		boolean matchFound = cartPage.verifyCartProduct1(product); //Using Streams
 		Assert.assertTrue(matchFound);
    	 
     }
     
     @When("User click on checkout button")
     public void user_click_on_checkout_button()
     {
    	 checkoutPage=cartPage.goTocheckout();
     }
     
     
     @And ("^User land on checkout page and fill all the details (.+), (.+), (.+), (.+) of checkout page$")
     public void user_land_on_checkout_page_and_fill_all_the_details_of_checkout_page(String cardNumber, String cvv, String cardName, String country)
     {
    	 checkoutPage.fillCheckoutPageDetails(cardNumber,cvv,cardName,country);
    	 checkoutPage.selectCountry(country);
     }
     
     
     @And("user click on place order button")
     public void user_click_on_place_order_button()
     {
    	 orderConfirmationPage = checkoutPage.goToOrderDetailsPage();
     }
     
     @Then("User land on order details page and verify order detail text message {string}")
     public void user_land_on_order_details_page_and_verify_order_detail_text_message(String message)
     {
    	 confirmMessageText =orderConfirmationPage.verifyOrderDetailsPageText();
 		Assert.assertTrue(confirmMessageText.equalsIgnoreCase(message), "Text is wrong");
 		 driver.close();
     }
     
     @Then("User verify error {string} message for login")
     public void user_verify_error_message_for_login(String message)
     {
    	 Assert.assertEquals(message, landingPage.getErrorMessage());
     }
    
     
}
