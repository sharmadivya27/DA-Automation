package gov.daip.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import gov.daip.steps.HomepageRegressionSteps;

public class HomepageRegression {
	
	HomepageRegressionSteps homeSteps;

	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() {
		
	}
	
	@When("I click on each link in the top navigation bar")
	public void when_I_click_on_each_link_in_the_top_navigation_bar() {
		
	}
	
	@Then("the <navTabName> should open correctly")
	public void then_the_navigation_tab_should_open_correctly(@Named("navTabName") String navTabName) {
		homeSteps.clickExample(navTabName);
		Assert.assertTrue(true);
	}
	
	//Scenario: Verify all of the sub-tabs within each top navigation bar
}
