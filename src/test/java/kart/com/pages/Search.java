package kart.com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	WebDriver driver;
	
	// Constructor
	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@placeholder,'Search for')]")
	private WebElement searchBar;
	
	@FindBy(xpath="//div[@class='xFpzYq']//following::div[@class='BHPsUQ']")
	private WebElement errormsg;


	public void enterSearchProduct(String productName) {
		searchBar.sendKeys(productName,Keys.ENTER);
	}
	
	public String displayerrormsg() {
		return errormsg.getText();
	}

	


}
