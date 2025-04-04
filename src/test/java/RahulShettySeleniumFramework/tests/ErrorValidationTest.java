package RahulShettySeleniumFramework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettySeleniumFramework.pageobjects.CartPage;
import RahulShettySeleniumFramework.pageobjects.ProductCatalogue;
import RahulShettySeleniumFramework.testComponents.TestReusable;
import RahulShettySeleniumFramework.testComponents.RetryFailedTest;


public class ErrorValidationTest extends TestReusable{
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer = RetryFailedTest.class)
	public void loginErrorValidation() throws IOException
	{
	    
		landingPage.loginAppication("ashishpawar@gmail.lcl","@Shishpawar");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

                // Ignore this. This comment added to ru Jenkins job through CICD.
	
	}	
	
	
	@Test(groups= {"ErrorHandlingProduct"})
	public void productErrorValidation() throws IOException
	{
	    
		    String addProduct ="ADIDAS ORIGINAL";

			ProductCatalogue productCatalogue = landingPage.loginAppication("ashishpawar1@gmail.lcl","@Shishpawar1");
			productCatalogue.addToCart(addProduct);
//			productCatalogue.addToCart1(addProduct); //Using streams
			CartPage cartPage =productCatalogue.goToCartPage();
			boolean matchFound = cartPage.verifyCartProduct("PUMA");
//			boolean matchFound = cartPage.verifyCartProduct1(addProduct); //Using Streams
			Assert.assertFalse(matchFound);
	
	}
}
