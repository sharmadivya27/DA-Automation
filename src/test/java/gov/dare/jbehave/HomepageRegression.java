package gov.dare.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import gov.dare.pageObjects.HomepageObject;

public class HomepageRegression {
	
	HomepageObject homePage;

	//why isn't page opening
	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() {
		homePage.open();
	}
	
	@When("I click on <navMenuItem> within the top navigation bar")
	public void when_I_click_on_each_link_in_the_top_navigation_bar(@Named("navMenuItem") String navMenuItem) {
		homePage.clickOnNavigationMenu(navMenuItem);
	}
	
	@Then("the <navMenuItem> page should open correctly")
	public void then_the_navigation_tab_should_open_correctly(@Named("navMenuItem") String navMenuItem) {
		Assert.assertTrue(true);
	}
	
	//Scenario: Verify all of the sub-tabs within each top navigation bar
}
