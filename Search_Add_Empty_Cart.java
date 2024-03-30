package com.webstaurant;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;  
/*
 * Java, Selenium, Chrome browser and WebDriverManager
 * Testcase:
 * Go to site 
 * Search for 'stainless work table'
 * Check the search result ensuring every product has the word 'Table' in its title
 * Add the last found item to cart
 * Empty cart
*/
public class Search_Add_Empty_Cart {
	public static  void main (String [] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
	
		
		driver.get("https://www.webstaurantstore.com/");
		
		driver.manage().window().maximize();
		
		
		WebElement searchvalue = driver.findElement(By.id("searchval"));
		searchvalue.sendKeys("stainless work table");
		
		WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button"));
		searchbtn.click();	
		
		
		List<WebElement> elements = driver.findElements(By.cssSelector(".details .description"));
		  
	    Thread.sleep(5000);
	  
	    
	    
	    for (int i=0; i<elements.size();i++){    	  
		  if (elements.get(i).getText().contains("Table")) {		  
		 	} else{
		      System.out.println("Search result do not contain keyword-table" );
		 	}    
	    }
	    
	    List<WebElement> addtocart = driver.findElements(By.cssSelector(".cartAndQuantity .btn"));
	    WebElement lastone = addtocart.get(addtocart.size() -1);
	    lastone.click();
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("View Cart")));
	    
	    WebElement cart = driver.findElement(By.id("cartItemCountSpan"));
	    cart.click();
	    
	    WebElement emptycart = driver.findElement(By.cssSelector(".emptyCartButton"));
	    emptycart.click();
	    

	    WebDriverWait prompt = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	    prompt.until(ExpectedConditions.visibilityOfElementLocated(By.id("empty-cart-title")));
	
	    WebElement emptycartconfirm = driver.findElement(By.xpath("//*[@class=\"ReactModalPortal\"]/div/div/div/footer/button[1]"));
	    emptycartconfirm.click();
	     
	    //driver.quit();


}
}