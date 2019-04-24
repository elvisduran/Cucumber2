Feature: Create trip newtours
	Create a new user
	
Scenario:
Given I am an user to book a first class round trip for three passengers on December/nineteenth in Unifer Airlines
And departing from Paris
And Arriving to Acapulco
When I register my data to book a trip correctly in the page
Then I should get confirmation message for my trip.
