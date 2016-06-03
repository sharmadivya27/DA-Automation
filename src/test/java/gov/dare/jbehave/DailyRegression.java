package gov.dare.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.dare.users.User;
import net.thucydides.core.annotations.Steps;

/**
 * More or less the starting point of the program. The flow of Serenity is as follows:
 * 		- DAREAcceptanceSuite.java looks into the .story files
 * 		- .story files run sequentially looking for the matching given, when, then
 * 			annotations in this file.
 * 		- "User" is the class that does human like things, such as the assertions
 * 		- Back-end of web code happens in the pageObject classes
 * 
 * @author Chris Viqueira
 */
public class DailyRegression 
{
	@Steps
	User user;

	/** Scenario 1: Verify all of the navbar tabs to assert that the pages open correctly **/
	
	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() 
	{
		user.open_home_page();
	}
	
	@When("I click on <navMenuItem> within the top navigation bar")
	public void when_I_click_on_each_link_in_the_top_navigation_bar(@Named("navMenuItem") String navMenuItem) 
	{
		user.clickParentNavigationTab(navMenuItem);
	}
	
	@Then("the <navMenuItem> page should open correctly")
	public void then_the_navigation_tab_should_open_correctly(@Named("navMenuItem") String navMenuItem) 
	{
		if(navMenuItem.equalsIgnoreCase("home"))
		{
			user.shouldSeeAddressLookup();
		}
		else
		{
			user.shouldSeeText(navMenuItem);
		}
	}
	
	@Then("there should be <numNodes> landing page nodes")
	public void and_the_number_of_landing_page_nodes_should_match(@Named("numNodes") short numNodes)
	{
		user.shouldSeeXLandingPageNodes(numNodes);
	}
	
	
	/** Scenario 2: Verify all of the nodes on the "Get Assistance" landing page **/
		
	@Given("I am on the Get Assistance landing page")
	public void given_I_am_on_the_Get_Assistance_landing_page()
	{
		user.open_page("https://www.disasterassistance.gov/get-assistance");
	}
	
	@When("I click on the <landingPageNode> landing page node")
	public void when_I_click_on_the_landing_page_node(@Named("landingPageNode") String landingPageNode)
	{
		user.clickLandingPageNode(landingPageNode);
	}
	
	@Then("the <landingPageNode> page should open correctly")
	public void then_the_landing_page_node_should_open_correctly(@Named("landingPageNode") String landingPageNode)
	{
		user.shouldSeePage(landingPageNode);
	}
	
	/** Scenario 3: Verify all of the nodes on the "Information" landing page **/
}
