package com.stepDef;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Base.TestHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kart.com.pages.ProductList;

public class AddSearchedProduct {
	
	WebDriver driver=TestHooks.driver;
	ProductList list=new ProductList(driver);
	
	@When("selects the product from the results")
	public void selects_the_product_from_the_results() throws Exception {
	   
	    list.searchfiretproduct();
	    Thread.sleep(2000);
	}
	
	@When("clicks on Add to Cart.")
	public void clicks_on_add_to_cart() throws InterruptedException {
	    String parentWindow = driver.getWindowHandle(); 
	    Set<String> allWindows = driver.getWindowHandles();

	    // Wait for the new window to open
	    while (allWindows.size() == 1) {
	        allWindows = driver.getWindowHandles();
	    }
	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) { 
	            driver.switchTo().window(window);
	            break;
	        }
	    }
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Scroll to Add to Cart button
	    js.executeScript("arguments[0].scrollIntoView();", list.addtocart);
	    // Click the Add to Cart button
	    list.addtoCart();
	    Thread.sleep(1500);
	}




	@Then("the product should be added to the cart successfully")
	public void the_product_should_be_added_to_the_cart_successfully() {
	}



}
