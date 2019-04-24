package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumPages.Page_HomePage;

public class StepDef {
	Page_HomePage homepage= new Page_HomePage();
	
	@Given("^I am a new user$")
	public void i_am_a_new_user() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		homepage.launchBrowser();
		homepage.openURL();
		homepage.gotoURLRegister();
		homepage.WaitAMoment();
	}

	@Then("^I should get a welcome message\\.$")
	public void i_should_get_a_welcome_message() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		homepage.WaitAMoment();
		homepage.verifyWelcomMsg();
		homepage.GetOut();
		
	}
	@When("^I register my data username as \"([^\"]*)\"$")
	public void i_register_my_data_username_as(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		homepage.InsertUser(arg1);
	    
	}

	@When("^password as \"([^\"]*)\" correctly in the page for a new user$")
	public void password_as_correctly_in_the_page_for_a_new_user(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		homepage.InsertPassword(arg1);
		homepage.RegisterUser();

	}
	
}
