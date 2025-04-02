package kart.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList {

	WebDriver driver;
	
	public ProductList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="(//div[@class='tUxRFH']/a)[1]")
	WebElement searchfiretproduct;
	
	public void searchfiretproduct() {
		searchfiretproduct.click();
	}

	@FindBy(xpath="//ul[@class='row']//li[1]")
	public WebElement addtocart;
	
	public void addtoCart() {
		addtocart.click();
	}
	
	
}
