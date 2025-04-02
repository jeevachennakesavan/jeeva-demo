package com.stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.TestHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import kart.com.pages.RemovePage;

public class RemoveDef {

	
	WebDriver driver=TestHooks.driver;
	RemovePage remove=new RemovePage(driver);
	String text=null;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@When("the user removes the product from the cart")
	public void the_user_removes_the_product_from_the_cart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the "Remove" button using scrollIntoView
		js.executeScript("arguments[0].scrollIntoView();", remove.removebtn);
		
		remove.removeBtn();
		remove.removeacceptbtn();

	}

	@Then("a message should be displayed {string}")
	public void a_message_should_be_displayed(String string) {
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully removed')]")));
		String messageText = toastMessage.getText();
		System.out.println("Toast message: " + messageText);
		Assert.assertTrue(messageText.contains(string));

	}


}
