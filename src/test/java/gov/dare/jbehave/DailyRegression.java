package gov.dare.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.dare.users.User;
import net.thucydides.core.annotations.Steps;

/**
 * More or less the starting point of the program. The flow of Serenity is as
 * follows: - DAREAcceptanceSuite.java looks into the .story files - .story
 * files run sequentially looking for the matching given, when, then annotations
 * in this file. - "User" is the class that does human like things, such as the
 * assertions - Back-end of web code happens in the pageObject classes
 * 
 * @author Chris Viqueira
 */
public class DailyRegression {
	@Steps
	User user;

	/**
	 * Scenario 1: Verify all of the navbar tabs to assert that the pages open
	 * correctly
	 **/
	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() {
		user.open_home_page();
	}

	@When("I click on <navMenuItem> within the top navigation bar")
	public void when_I_click_on_each_link_in_the_top_navigation_bar(@Named("navMenuItem") String navMenuItem) {
		user.clickParentNavigationTab(navMenuItem);
	}

	@Then("the <navMenuItem> page should open correctly")
	public void then_the_navigation_tab_should_open_correctly(@Named("navMenuItem") String navMenuItem) {
		user.shouldSeePage(navMenuItem);
	}

	@Then("there should be <numNodes> landing page nodes")
	public void and_the_number_of_landing_page_nodes_should_match(@Named("numNodes") short numNodes) {
		user.shouldSeeLandingPageNodes(numNodes);
	}

	/**
	 * Scenario 2: Verify all of the nodes on the "Get Assistance" landing page
	 **/
	@Given("I am on the Get Assistance landing page")
	public void given_I_am_on_the_Get_Assistance_landing_page() {
		user.open_page("https://www.disasterassistance.gov/get-assistance");
	}

	@When("I click on the <landingPageNode> landing page node")
	public void when_I_click_on_the_landing_page_node(@Named("landingPageNode") String landingPageNode) {
		user.clickLandingPageNode(landingPageNode);
	}

	@Then("the <landingPageNode> page should open correctly")
	public void then_the_landing_page_node_should_open_correctly(@Named("landingPageNode") String landingPageNode) {
		user.shouldSeePage(landingPageNode);
	}

	/**
	 * Scenario 3: Verify all of the nodes on the "Information" landing page
	 **/
	@Given("I am on the Information landing page")
	public void given_I_am_on_the_Information_landing_page() {
		user.open_page("https://www.disasterassistance.gov/information");
	}

	// when see scenario 2
	// then see scenario 2

	/** Scenario 4: Verify all of the nodes on the "About Us" landing page **/
	@Given("I am on the About Us landing page")
	public void given_I_am_on_the_About_Us_landing_page() {
		user.open_page("https://www.disasterassistance.gov/about-us");
	}

	// when see scenario 2
	// then see scenario 2

	/** Scenario 5: Verify all of the nodes on the "Help" landing page **/
	@Given("I am on the Help landing page")
	public void given_I_am_on_the_Help_landing_page() {
		user.open_page("https://www.disasterassistance.gov/help");
	}

	// when see scenario 2
	// then see scenario 2
	
	/**
	 * Scenario 6: Verify results of the questionnaire on the "Find Assistance"
	 * page
	 **/
	@Given("I am on the Find Assistance page")
	public void given_I_am_on_the_Find_Assistance_page() {
		user.open_page("https://www.disasterassistance.gov/get-assistance/find-assistance");
	}

	@When("I answer 'Yes' on all questions")
	public void when_I_answer_Yes_on_all_questions() {
		user.completeQuestionnaire();
	}

	@Then("I should accumulate 73 results")
	public void I_should_accumulate_73_results() {
		user.checkAllResults();
	}
	
	/**
	 * Scenario 7: Verify benefits results display according to use cases"
	 * page
	 **/

	@When("I choose only Employment")
	public void when_I_choose_only_Employment() {
		user.getEmploymentResults();
	}

	@Then("I should obtain 9 results")
	public void then_I_should_obtain_9_results() {
		user.verifyEmploymentResults();
	}
}
