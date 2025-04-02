package com.stepDef;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kart.com.pages.Search;

public class SearchDef {

	 WebDriver driver = TestHooks.driver;
	 Search search =new Search(driver);
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 
	@Given("the user is on the Flipkart homepage")
	public void the_user_is_on_the_flipkart_homepage() {
		driver.get("https://www.flipkart.com/");
	}
	
	@When("the user searches for {string} based on {string}")
	public void the_user_searches_for_based_on(String string,String row) throws Exception {	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		//search.enterSearchProduct(string);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));   
	    ArrayList<String> searchValues = TestHooks.provider(string,row); 
	    for (String product : searchValues) {
	        System.out.println("Searching for: " + product);
	        Thread.sleep(1500);
	        search.enterSearchProduct(product);
	        Thread.sleep(1500);
	    }
	}
	@Then("the product results should be displayed")
	public void the_product_results_should_be_displayed() {
		String cururl=driver.getCurrentUrl();
		Assert.assertNotEquals(cururl, "https://www.flipkart.com/");
	}

	@Then("a message should be displayed stating {string}")
	public void a_message_should_be_displayed_stating(String string) {
		
		String curmsg=search.displayerrormsg();
		Assert.assertEquals(string, curmsg);
	}
}
