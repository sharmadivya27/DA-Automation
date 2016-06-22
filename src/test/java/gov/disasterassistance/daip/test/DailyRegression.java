package gov.disasterassistance.daip.test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import net.thucydides.core.annotations.Steps;

/*************************************************************************
 *	Starting point of the program; more or less. Scenarios
 *	from the .story files are matched with the annotation in this file.
 *
 * @author Chris Viqueira
 ************************************************************************/
public class DailyRegression {
	@Steps
	User user;

	//Scenario 1: Verify all of the navbar tabs to assert that the pages open correctly
	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() {
		user.open_home_page();
	}

	@When("I click on <navMenuItem> within the top navigation bar")
	public void when_I_click_on_each_link_in_the_top_navigation_bar(@Named("navMenuItem") String navMenuItem) {
		user.clickNavNode(navMenuItem);
	}

	@Then("the <navMenuItem> page should open correctly")
	public void then_the_navigation_tab_should_open_correctly(@Named("navMenuItem") String navMenuItem) {
		user.shouldSeePage(navMenuItem);
	}

	@Then("there should be <numNodes> landing page nodes")
	public void and_the_number_of_landing_page_nodes_should_match(@Named("numNodes") short numNodes) {
		user.shouldSeeLandingPageNodes(numNodes);
	}

	
	//Scenario 2: Verify all of the nodes on the "Get Assistance" landing page
	@Given("I am on the Get Assistance landing page")
	public void given_I_am_on_the_Get_Assistance_landing_page() {
		user.open_page("https://www.disasterassistance.gov/get-assistance");
	}

	@When("I click on the <landingPageNode> landing page node")
	public void when_I_click_on_the_landing_page_node(@Named("landingPageNode") String landingPageNode) {
		user.clickNavNode(landingPageNode);
	}

	@Then("the <landingPageNode> page should open correctly")
	public void then_the_landing_page_node_should_open_correctly(@Named("landingPageNode") String landingPageNode) {
		user.shouldSeePage(landingPageNode);
	}
	

	//Scenario 3: Verify all of the nodes on the "Information" landing page
	@Given("I am on the Information landing page")
	public void given_I_am_on_the_Information_landing_page() {
		user.open_page("https://www.disasterassistance.gov/information");
	}

	// when see scenario 2
	// then see scenario 2

	
	//Scenario 4: Verify all of the nodes on the "About Us" landing page
	@Given("I am on the About Us landing page")
	public void given_I_am_on_the_About_Us_landing_page() {
		user.open_page("https://www.disasterassistance.gov/about-us");
	}

	// when see scenario 2
	// then see scenario 2

	//Scenario 5: Verify all of the nodes on the "Help" landing page
	@Given("I am on the Help landing page")
	public void given_I_am_on_the_Help_landing_page() {
		user.open_page("https://www.disasterassistance.gov/help");
	}

	// when see scenario 2
	// then see scenario 2
	
	
	//Scenario 6: Verify results of the questionnaire on the "Find Assistance" page
	@Given("I am on the Find Assistance page")
	public void given_I_am_on_the_Find_Assistance_page() {
		user.open_page("https://www.disasterassistance.gov/get-assistance/find-assistance");
	}

	@When("I fully complete the questionnaire")
	public void when_I_answer_Yes_on_all_questions() {
		user.completeQuestionnaire();
	}

	@Then("I should accumulate 73 results")
	public void I_should_accumulate_73_results() {
		user.checkQuestionnaireResults();
	}
	
	
	
	//Scenario 7: Verify benefits results display according to use cases page
	
	// Given see scenario 6
	
	@When("I choose only Employment")
	public void when_I_choose_only_Employment() {
		user.getEmploymentResults();
	}

	@Then("I should obtain 9 results")
	public void then_I_should_obtain_9_results() {
		user.verifyEmploymentResults();
	}
	
	 //Scenario 8: Verify benefits results display according to use cases page
	
	@Given("I am on the Assistance by Federal Agency page")
	public void given_I_am_on_the_Assistance_by_Federal_Agency_page() {
		user.open_page("https://www.disasterassistance.gov/get-assistance/assistance-by-federal-agency");
	}
	@When("I check on each Federal Agency accordion")
	public void when_I_check_each_Federal_Agency_accordion() {
		//user.getEmploymentResults();
	}

	@Then("the number of benefits should match with its count")
	public void then_the_number_of_benefits_should_match_with_its_count() throws BenefitCountException {
		user.checkFederalBenefits();
	}
	
	//Scenario 9: Verify all the functionality of the FOA questionnaire
	
	// given on the FOA page, declared above
	// when I complete the questionnaire, declared above
	
	@When("expand all the accordions")
	public void and_expand_all_the_accordions() {
//		user.clickExpandAll();
	}
	
	@Then("I should see all of the content under the accordions")
	public void then_I_should_see_all_content_under_accordions() {
		
	}
}
