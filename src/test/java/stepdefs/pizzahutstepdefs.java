package stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pizzahutstepdefs {
	
	WebDriver driver = BaseClass.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://pizzahut.co.in/");
	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String location) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement locationtxt = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		locationtxt.sendKeys(location);	
	    
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement locationlst = driver.findElement(By.xpath("//*[contains(text(),'Airport')]"));
		locationlst.click();	
	    
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_deals_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement DealLink = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		DealLink.isDisplayed();	
	    
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String Pizzas) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement PizzaLink = driver.findElement(By.xpath("//a[@data-synth='link--pizzas--side']//span[text()='"+Pizzas+"']"));
		PizzaLink.isDisplayed();		    
		PizzaLink.click();
	    
	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String Pizzaname) {
	    // Write code here that turns the phrase above into concrete actions
		//see the given pizza name
		WebElement Pizzaitem = driver.findElement(By.xpath("//div[text()='"+Pizzaname+"']"));
		Pizzaitem.isDisplayed();	
		
		//click add the same pizza
		WebElement Addpizzaitem = driver.findElement(By.xpath("//div[text()='"+Pizzaname+"']/following::span[text()='Add'][1]"));
		Addpizzaitem.click();
	    
	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Pizzaitemselected = driver.findElement(By.xpath("//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Mazedar Makhni Paneer')]"));
		Pizzaitemselected.isDisplayed();
	    
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement checkoutbutton= driver.findElement(By.xpath("//span[text()='Checkout']"));
		checkoutbutton.click();	
	    
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement checkoutpagetile = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		checkoutpagetile.isDisplayed();	
	    
	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(io.cucumber.datatable.DataTable persdetails) {
	    // Write code here that turns the phrase above into concrete actions
		
		for(int i=0;i<persdetails.height();i++)
		{
			//dynamic element finding and input
			WebElement PersDetail1 = driver.findElement(By.name(persdetails.cell(i,0)));
			PersDetail1.sendKeys(persdetails.cell(i,1));
		}	
	    
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(List<String> Addressdetails) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement AddrDetail1 = driver.findElement(By.name("deliveryAddress.interior"));
		AddrDetail1.sendKeys(Addressdetails.get(0));

		WebElement AddrDetail2 = driver.findElement(By.name("deliveryAddress.notes"));
		AddrDetail2.sendKeys(Addressdetails.get(1));
	    
	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> PaymentOptions) {
		for(String value:PaymentOptions) 
		{
			//dynamic element find and check whether present or not
			WebElement PaymentOption = driver.findElement(By.xpath("//span[text()='"+value+"']"));
			PaymentOption.isDisplayed();	
		}	
	    
	}

	@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement CashpaymentOption = driver.findElement(By.xpath("//span[text()='Cash']/preceding::i[2]"));
		CashpaymentOption.click();	
	    
	}

}
