package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class SearchPageStepImpl {
	
	public WebDriver driver;
	public SearchPage sp;
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
	   System.setProperty("webdriver.edge.driver", "C:\\Users\\bnallapareddy.CTEWEBAPPS\\eclipse-workspace\\CucumberMavenProject\\Drivers\\chrome.exe");
	   driver= new ChromeDriver();
	   sp = new SearchPage(driver);
	   
	}

	
	@Given("I navigate to {string}")
	public void i_navigate_to(String url) throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("TITLE OD THE PAGE IS === "+driver.getTitle());
	}

	@When("I search for an item {string}")
	public void i_search_for_an_item(String itemname) throws InterruptedException{
		Thread.sleep(1000);
		sp.searchBox(itemname);
//		driver.switchTo().frame(3);
		sp.clickOnOption();
	    
	}

	@Then("I should see items based on my search keyword")
	public void i_should_see_items_based_on_my_search_keyword() throws InterruptedException {
		Thread.sleep(1000);
	   sp.verifySerachResults();
	   
	}

	@Then("I close browser")
	public void i_close_browser() {
	   driver.quit();
	}

}
