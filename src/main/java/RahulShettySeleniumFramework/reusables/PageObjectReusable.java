package RahulShettySeleniumFramework.reusables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettySeleniumFramework.pageobjects.CartPage;

public class PageObjectReusable {
	
	WebDriver driver;
	
	public PageObjectReusable(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	By cartButton1 = By.cssSelector("[routerlink='/dashboard/cart']");
	
	
	public void waitForElementToAppear(By object)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(6000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(object));
	}
	
	public void waitForWebElementToAppear(WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(6000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitForInvisibilityOfElement(By object) 
	{  
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(6000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(object));
	}
	
	
	public void waitForElementToClickable(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	 public CartPage goToCartPage()
     {
	   waitForElementToAppear(cartButton1);	 
	   waitForElementToClickable(cartButton1);
  	   cartButton.click();
  	   CartPage cartPage = new CartPage(driver);
  	   return cartPage;
     }
	
	
	 public void scrollByPixels(int x, int y) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
		}
	

}
