Feature: newtours Homepage
	Create a new user

Scenario:
Given I am a new user
When I register my data username as "Elvis" 
And password as "Duran" correctly in the page for a new user
Then I should get a welcome message.
