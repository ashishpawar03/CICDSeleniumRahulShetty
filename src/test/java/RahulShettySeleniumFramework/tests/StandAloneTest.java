package RahulShettySeleniumFramework.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Optional;

public class StandAloneTest {

	public static void main(String[] args) {
		
	    String addProduct ="IPHONE 13 PRO";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("ashishpawar1@gmail.lcl");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("@Shishpawar1");
		driver.findElement(By.cssSelector("#login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		
		 // Using java streams
	     //	WebElement prod = products.stream().filter(product->
	     // product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
	     // prod.findElement(By.xpath(".//i[@class='fa fa-shopping-cart']")).click();
			
		for(WebElement product:products)
		{
			
			  String productName=product.findElement(By.xpath(".//b")).getText();
		   // String productName=product.findElement(By.xpath(".//div[@class='card']/child::div/child::h5/child::b")).getText();
			    
	 	     //  . (dot) at the beginning of ".//b" ensures that Selenium only searches inside the current product element, 
			 //    instead of scanning the entire DOM.
	    	 //    This way, each product gets its own name correctly.
		    
		    System.out.println(productName);
		    
			    if(productName.equals(addProduct))
			    {
			    	product.findElement(By.xpath(".//i[@class='fa fa-shopping-cart']")).click();
			    }
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@class='ng-tns-c31-0 ng-star-inserted']")));
		
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
	
		List <WebElement> allProd =driver.findElements(By.cssSelector(".cartSection h3"));
	 // Using java stream	
	 //	boolean match =allProd.stream().anyMatch(prodname -> prodname.getText().equals(addProduct));	
	 //	Assert.assertTrue(match);
		
		for(WebElement prod:allProd)
		{
			System.out.println("Cart Prod text ="+prod.getText());
			String txt=prod.getText();
					
			if(txt.equals(addProduct))
			{
				Assert.assertEquals(txt, addProduct);
			}
		}
		
		
		driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']/descendant::button")).click();
		
		driver.findElement(By.cssSelector("[class=field] input.txt.text-validated")).clear();
		driver.findElement(By.cssSelector("[class=field] input.txt.text-validated")).sendKeys("2222 3333 4444 5555");
		driver.findElement(By.xpath("//div[@class='field small']//input[@type='text' and @class='input txt']")).sendKeys("1234");
	    driver.findElement(By.xpath("//div[@class='field']//input[@type='text' and @class='input txt']")).sendKeys("Ashish Pawar");
	    driver.findElement(By.cssSelector("[placeholder='Select Country']")).click();
	    driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
	    
	  
	    List <WebElement> allCountry = driver.findElements(By.xpath("//button[contains(@class,'ta-item')]/span"));
	   
	   
	   // Using java streams
	   
//	     Optional<WebElement> countryToSelect = allCountry.stream()
//	    .filter(country -> country.getText().equalsIgnoreCase("India"))
//	    .findFirst();
//	     countryToSelect.ifPresent(WebElement::click);
	
	   for(WebElement Country:allCountry)
	   {
		   String countryName=Country.getText();
		   System.out.println(countryName);
		   
		   if(Country.getText().trim().equalsIgnoreCase("India"))
		   {
			   Country.click();
			   break;
		   }
	   }
	
	   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnn.action__submit ")));
	   driver.findElement(By.cssSelector(".btnn.action__submit ")).click();
	   String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	   Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	 
	   
	}

}
