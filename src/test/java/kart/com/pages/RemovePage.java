package kart.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemovePage {
	
	WebDriver driver;
	public RemovePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[contains(text(),'Remove')]")
	public WebElement removebtn;
	
	public void removeBtn() {
		removebtn.click();
	}
	
	@FindBy(xpath="//div[@class='gRTtwM f-DWwy']/child::div[text()='Remove']")
	public WebElement removeacceptbtn;
	
	public void removeacceptbtn() {
		removeacceptbtn.click();
	}
}
