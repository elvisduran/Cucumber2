package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumPages.Page_CreateTrip;


public class StepDef {
	Page_CreateTrip homepage= new Page_CreateTrip();
	@Given("^I am an user to book a first class round trip for three passengers on December/nineteenth in Unifer Airlines$")
	public void i_am_an_user_to_book_a_first_class_round_trip_for_three_passengers_on_December_nineteenth_in_Unifer_Airlines() throws InterruptedException {
		homepage.launchBrowser();
		homepage.openURL();
		homepage.InsertUser("mercury");
		homepage.InsertPassword("mercury");
		homepage.Sign_In();
		homepage.waitForLoad("passCount");;
		homepage.SelectOptionsTrip();
		homepage.waitForLoad("outFlight");
		homepage.SelectFly();
		homepage.waitForLoad("billCountry");
		
	}

	@And("^departing from Paris$")
	public void departing_from_Paris() {
	    // Write code here that turns the phrase above into concrete actions
		homepage.SelectFrom();
	}

	@And("^Arriving to Acapulco$")
	public void arriving_to_Acapulco() {
		homepage.SelectTo();
	}

	@When("^I register my data to book a trip correctly in the page$")
	public void i_register_my_data_to_book_a_trip_correctly_in_the_page() {
	    // Write code here that turns the phrase above into concrete actions
		homepage.FillNames();
		homepage.FillCreditCard();
	}

	@Then("^I should get confirmation message for my trip\\.$")
	public void i_should_get_confirmation_message_for_my_trip() throws InterruptedException {
		homepage.WaitAMoment();
	    homepage.GetConfirm();
	}
}
