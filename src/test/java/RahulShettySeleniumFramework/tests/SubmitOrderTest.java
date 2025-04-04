package RahulShettySeleniumFramework.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettySeleniumFramework.pageobjects.CartPage;
import RahulShettySeleniumFramework.pageobjects.CheckoutPage;
import RahulShettySeleniumFramework.pageobjects.LandingPage;
import RahulShettySeleniumFramework.pageobjects.OrderConfirmationPage;
import RahulShettySeleniumFramework.pageobjects.ProductCatalogue;
import RahulShettySeleniumFramework.testComponents.TestReusable;

import java.util.Optional;

public class SubmitOrderTest extends TestReusable {

	
	@Test(dataProvider = "getData")
	public void submitOrder(String email, String password, String product,String cardNumber, String cvv, String cardName, String country, String confirmMessageTextExpected) throws IOException
	{
		
	    String confirmMessageText="";
	    
		ProductCatalogue productCatalogue = landingPage.loginAppication(email,password);
		productCatalogue.addToCart(product);
//		productCatalogue.addToCart1(product); //Using streams
		CartPage cartPage =productCatalogue.goToCartPage();
		boolean matchFound = cartPage.verifyCartProduct(product);
//		boolean matchFound = cartPage.verifyCartProduct1(product); //Using Streams
		Assert.assertTrue(matchFound);
		CheckoutPage checkoutPage =cartPage.goTocheckout();
		checkoutPage.fillCheckoutPageDetails(cardNumber,cvv,cardName,country);
		checkoutPage.selectCountry(country);
		OrderConfirmationPage orderConfirmationPage = checkoutPage.goToOrderDetailsPage();
//		OrderConfirmationPage orderConfirmationPage = checkoutPage.selectCountryAndGoToOrderDetailsPage1(country); //Using Streams
		confirmMessageText =orderConfirmationPage.verifyOrderDetailsPageText();
		Assert.assertTrue(confirmMessageText.equalsIgnoreCase(confirmMessageTextExpected), "Text is wrong");
	   
	   
	}

	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] 
		{
			{"ashishpawar1@gmail.lcl","@Shishpawar1","ADIDAS ORIGINAL","2222 3333 4444 5555","1234","Ashish Pawar","India","Thankyou for the order."},
			{"ashishpawar1@gmail.lcl","@Shishpawar1","ZARA COAT 3","2222 3333 4444 5555","1234","Ashish Pawar","India","Thankyou for the order."}
		};
	}
	
	
	
	
	//@Test(dataProvider = "getDataOne")
	public void submitOrderUsingHashmap(HashMap<String,String> newmap) throws IOException
	{
		
	    String confirmMessageText="";
	    
		ProductCatalogue productCatalogue = landingPage.loginAppication(newmap.get("email"),newmap.get("password"));
		productCatalogue.addToCart(newmap.get("product"));
//		productCatalogue.addToCart1(newmap.get("product")); //Using streams
		CartPage cartPage =productCatalogue.goToCartPage();
		boolean matchFound = cartPage.verifyCartProduct(newmap.get("product"));
//		boolean matchFound = cartPage.verifyCartProduct1(newmap.get("product")); //Using Streams
		Assert.assertTrue(matchFound);
		CheckoutPage checkoutPage =cartPage.goTocheckout();
		checkoutPage.fillCheckoutPageDetails(newmap.get("cardNumber"),newmap.get("cvv"),newmap.get("cardName"),newmap.get("country"));
		checkoutPage.selectCountry(newmap.get("country"));
		OrderConfirmationPage orderConfirmationPage = checkoutPage.goToOrderDetailsPage();
//		OrderConfirmationPage orderConfirmationPage = checkoutPage.selectCountryAndGoToOrderDetailsPage1(country); //Using Streams
		confirmMessageText =orderConfirmationPage.verifyOrderDetailsPageText();
		Assert.assertTrue(confirmMessageText.equalsIgnoreCase(newmap.get("confirmMessageTextExpected")), "Text is wrong");
	   
	   
	}

	
	
	@DataProvider
	public Object[][] getDataOne()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "ashishpawar1@gmail.lcl");
		map.put("password", "@Shishpawar1");
		map.put("product", "ADIDAS ORIGINAL");
		map.put("cardNumber", "2222 3333 4444 5555");
		map.put("cvv", "1234");
		map.put("cardName", "Ashish Pawar");
		map.put("country", "India");
		map.put("confirmMessageTextExpected", "Thankyou for the order.");
		
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "ashishpawar1@gmail.lcl");
		map1.put("password", "@Shishpawar1");
		map1.put("product", "ZARA COAT 3");
		map1.put("cardNumber", "2222 3333 4444 5555");
		map1.put("cvv", "1234");
		map1.put("cardName", "Ashish Pawar");
		map1.put("country", "India");
		map1.put("confirmMessageTextExpected", "Thankyou for the order.");
		
		return new Object[][] 
		{
			{map},{map1}
		};
	}
	
	
	
	
	//@Test(dataProvider = "getDataTwo")
	public void submitOrderUsingJSON(HashMap<String,String> newmap) throws IOException
	{
		
	    String confirmMessageText="";
	    
		ProductCatalogue productCatalogue = landingPage.loginAppication(newmap.get("email"),newmap.get("password"));
		productCatalogue.addToCart(newmap.get("product"));
//		productCatalogue.addToCart1(newmap.get("product")); //Using streams
		CartPage cartPage =productCatalogue.goToCartPage();
		boolean matchFound = cartPage.verifyCartProduct(newmap.get("product"));
//		boolean matchFound = cartPage.verifyCartProduct1(newmap.get("product")); //Using Streams
		Assert.assertTrue(matchFound);
		CheckoutPage checkoutPage =cartPage.goTocheckout();
		checkoutPage.fillCheckoutPageDetails(newmap.get("cardNumber"),newmap.get("cvv"),newmap.get("cardName"),newmap.get("country"));
		checkoutPage.selectCountry(newmap.get("country"));
		OrderConfirmationPage orderConfirmationPage = checkoutPage.goToOrderDetailsPage();
//		OrderConfirmationPage orderConfirmationPage = checkoutPage.selectCountryAndGoToOrderDetailsPage1(country); //Using Streams
		confirmMessageText =orderConfirmationPage.verifyOrderDetailsPageText();
		Assert.assertTrue(confirmMessageText.equalsIgnoreCase(newmap.get("confirmMessageTextExpected")), "Text is wrong");
	   
	   
	}

	
	
	@DataProvider
	public Object[][] getDataTwo() throws IOException
	{	
		 List<HashMap<String, String>> data =getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//RahulShettySeleniumFramework//data//OrderDetails.json");
		
		return new Object[][] 
		{
			{data.get(0)},{data.get(1)}
		};
	}
	
}
