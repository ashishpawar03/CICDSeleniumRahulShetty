package RahulShettySeleniumFramework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettySeleniumFramework.reusables.PageObjectReusable;

public class ProductCatalogue extends PageObjectReusable {

			WebDriver driver;
			String productName="";
			
			
			public ProductCatalogue(WebDriver driver) {
				
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			
	
	
			@FindBy(css=".mb-3")
			List <WebElement> products; // This will have all product list 
			                            // It contains driver.findElement / driver.findElements
			
			@FindBy(css="[routerlink*=cart]")
			WebElement cartButton;
		
			
			By productObject = By.cssSelector(".mb-3");
			By productNameText = By.xpath(".//b");
			By addToCartButton =By.xpath(".//i[@class='fa fa-shopping-cart']");
			By toastMessage= By.cssSelector("#toast-container");
			By spinner = By.xpath("//ngx-spinner[@class='ng-tns-c31-0 ng-star-inserted']");
			
			
			
	
			public List<WebElement> getProductList() {
				
				waitForElementToAppear(productObject);
				return products;
			}

	
			
			public WebElement getProductElement(String prodName1) {
				
				
				for(WebElement product:getProductList())
				{
					 
					  productName=product.findElement(productNameText).getText();
					  
					  if(productName.equals(prodName1))
					  {
						 
						  return product;
						  
					  }
						
				}
				return null;
			}
			
			
	
	
			public void addToCart(String prodName) {
				
			    WebElement productElement = getProductElement(prodName); // Get WebElement
		
			    if (productElement != null) { // Check if product exists
			        productElement.findElement(addToCartButton).click(); // Click the shopping cart button
			        waitForElementToAppear(toastMessage);
			        waitForInvisibilityOfElement(spinner);
			    } else {
			        System.out.println("Product not found: " + productName);
			    }
			}
	
			
			
            public WebElement getProductElement1(String prodName1) {
				
                 WebElement prod = products.stream().filter(product->
   		         product.findElement(By.cssSelector("b")).getText().equals(prodName1)).findFirst().orElse(null);
				
				 return prod;
			}
			
            public void addToCart1(String prodName) {
				
            	 WebElement prod = getProductElement1(prodName);
            	 prod.findElement(addToCartButton).click();
            	 waitForElementToAppear(toastMessage);
            	 waitForInvisibilityOfElement(spinner);
			}
            
          
            
}


