package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver ldriver;
	public SearchPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	@CacheLookup
	WebElement searchbar;
	
	@FindBy(xpath = "//*[text()=\"Newphoria\"]")
	@CacheLookup
	WebElement item;
	
	@FindBy(xpath = "//*[@aria-label=\"Amazon.in\"]")
	@CacheLookup
	WebElement siteName;
	
	@FindBy (xpath = "//*[text()=\"mobile\"]")
	@CacheLookup
	WebElement searchList;
	
	
	
	public void searchBox(String itemName) throws InterruptedException
	{
		searchbar.click();
		searchbar.sendKeys(itemName);
		Thread.sleep(500);
	}
	
	public void clickOnOption()
	{
		searchList.click();
	}
	
	public void verifySerachResults()
	{
		System.out.println("Search Result for mobile keyword is ="+item.getText());
	}

}
