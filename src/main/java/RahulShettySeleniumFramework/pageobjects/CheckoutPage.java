package RahulShettySeleniumFramework.pageobjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettySeleniumFramework.reusables.PageObjectReusable;

import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageObjectReusable{

		WebDriver driver;
		
		public CheckoutPage(WebDriver driver) {
			
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}
		
		@FindBy(css="[class=field] input.txt.text-validated")
		WebElement creditCardNumberTxtbox;
		
		@FindBy(xpath="//div[@class='field small']//input[@type='text' and @class='input txt']")
		WebElement cvvTxtbox;
		
		@FindBy(xpath="//div[@class='field']//input[@type='text' and @class='input txt']")
		WebElement cardName;
		
		@FindBy(css="[placeholder='Select Country']")
		WebElement countryDropdown;
		
		@FindBy(xpath="//button[contains(@class,'ta-item')]/span")
		List<WebElement> countryList;
		
		@FindBy(css=".btnn.action__submit ")
		WebElement placeOrderButton1;
		
		By placeOrderButton= By.cssSelector(".btnn.action__submit ");
		
		
		
		public void fillCheckoutPageDetails(String cardNumber, String cvv, String NameOnCard, String country)
		{
			creditCardNumberTxtbox.clear();
			creditCardNumberTxtbox.sendKeys(cardNumber);
			cvvTxtbox.sendKeys(cvv);
			cardName.sendKeys(NameOnCard);
			countryDropdown.click();
			countryDropdown.sendKeys(country);
			

		}
	
	    public void selectCountry(String country)
	    {
	   	 for(WebElement Country:countryList)
	 	   {
	 		   String countryName=Country.getText();
	 		   System.out.println(countryName);
	 		   
	 		   if(Country.getText().trim().equalsIgnoreCase(country))
	 		   {
	 			   Country.click();
	 			   break;
	 		   }
	 	   }
	    }
	
	
        public OrderConfirmationPage goToOrderDetailsPage()
        {
        	scrollByPixels(0,800);
        	waitForElementToClickable(placeOrderButton);
        	placeOrderButton1.click();
        	OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        	return orderConfirmationPage;
        }
	

        public Optional<WebElement> selectCountry1(String country1)
	    {
        	Optional<WebElement> countryToSelect = countryList.stream()
        		   .filter(country -> country.getText().equalsIgnoreCase(country1))
        		   .findFirst();
        	   return countryToSelect;
	    }
        
        public OrderConfirmationPage selectCountryAndGoToOrderDetailsPage1(String country)
        {
        	
        	selectCountry1(country).ifPresent(WebElement::click);
        	scrollByPixels(0,800);
        	//waitForElementToClickable(placeOrderButton);
        	placeOrderButton1.click();
        	OrderConfirmationPage orderDetailsPage = new OrderConfirmationPage(driver);
        	return orderDetailsPage;
        }
        
}
