package gov.disasterassistance.daip.test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import net.thucydides.core.annotations.Steps;

/*************************************************************************
 * Starting point of the program; more or less. Scenarios from the .story files
 * are matched with the annotation in this file.
 *
 * @author Chris Viqueira
 * @author Divya Sharma
 ************************************************************************/
public class DailyRegression {
	@Steps
	User user;

	/*********************************************/

	@Given("I am on the homepage")
	public void given_homepage() {
		user.home();
	}

	@When("I click the icon")
	public void click_icon() {
		user.clickIcon();
	}

	@Then("I should still be on the homepage")
	public void see_home() {
		user.seeHome();
	}

	/*********************************************/

	// Scenario: Verify all of the navbar tabs to assert that the pages open
	// correctly
	@Given("I am on the Disaster Assistance homepage")
	public void given_I_am_on_the_disaster_assistance_homepage() {
		// Homepage
		user.open_page("");
	}

	@Given("I am on the Disaster Assistance mobile page")
	public void given_I_am_on_the_disaster_assistance_mobile_page() {
		user.openMobilePage("");
	}
	
	@Given("I am on the Spanish Disaster Assistance mobile page")
	public void given_I_am_on_the_spanish_disaster_assistance_mobile_page() {
		user.openMobilePage("/es");
	}

	@Given("I am on the Spanish Disaster Assistance homepage")
	public void given_I_am_on_the_Spanish_disaster_assistance_homepage() {
		user.open_page("/es");
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

	// Scenario: Verify all of the quick links to assert that the pages open
	// correctly
	// given see above

	@When("I click on <quickLinkItem> within the quick links bar")
	public void when_I_click_on_each_quicklink_in_the_quick_links_bar(@Named("quickLinkItem") String quickLinkItem) {
		user.clickQuickLink(quickLinkItem);
	}

	@Then("the <quickLinkItem> page should open correctly")
	public void then_the_quicklink_page_should_open_correctly(@Named("quickLinkItem") String quickLinkItem) {
		user.shouldSeePage(quickLinkItem);
	}

	// Scenario: Verify the main links on homepage to assert that the pages open
	// correctly
	// given see above

	@When("I click on <mainLinksItem> within the main links bar")
	public void when_I_click_on_each_mainlink_in_the_main_links_bar(@Named("mainLinksItem") String mainLinksItem) {
		user.clickMainLink(mainLinksItem);
	}
	
	@When("I click on the <mainLinksItem> within the main links bar on mobile")
	public void when_I_click_on_each_mainlink_in_the_mobile_main_links_bar(@Named("mainLinksItem") String mainLinksItem) {
		user.clickMobileMainLink(mainLinksItem);
	}

	@Then("the <mainLinksItem> page should open correctly")
	public void then_the_mainlink_page_should_open_correctly(@Named("mainLinksItem") String mainLinksItem) {
		user.shouldSeePage(mainLinksItem);
	}

	// Scenario: Verify all the menu links on the "Get Assistance" tab
	// given see above

	@When("I click on the <menuLinks> in the Get Assistance tab")
	public void click_on_menu_links_in_get_assistance_tab(@Named("menuLinks") String menuLinks) {
		user.clickGetAssistanceMenuLinks(menuLinks);
	}

	@When("I click on the <menuLinks> in the Spanish Get Assistance tab")
	public void click_on_menu_links_spanish_in_get_assistance_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishGetAssistanceTab(menuLinks);
	}
	
	@When("I click on the <menuLinks> in the Get Assistance tab on mobile")
	public void click_on_menu_links_in_get_assistance_mobile_tab(@Named("menuLinks") String menuLinks) {
		user.clickMobileGetAssistanceMenuLinks(menuLinks);
	} 
	
	@When("I click on the <menuLinks> in the Get Assistance tab on mobile in spanish")
	public void click_on_spanish_menu_links_in_get_assistance_mobile_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishMobileGetAssistanceMenuLinks(menuLinks);
	}
 
	@Then("the <menuLinks> page should open correctly")
	public void then_the_menu_links_page_should_open_correctly(@Named("menuLinks") String menuLinks) {
		user.shouldSeePage(menuLinks);
	}

	// Scenario: Verify all of the nodes on the "Get Assistance" landing page
	@Given("I am on the Get Assistance landing page")
	public void given_I_am_on_the_Get_Assistance_landing_page() {
		user.open_page("/get-assistance");
	}

	@Given("I am on the Get Assistance Spanish landing page")
	public void given_I_am_on_the_Get_Assistance_Spanish_landing_page() {
		user.open_page("/es/obtener-asistencia");
	}

	@When("I click on the <landingPageNode> landing page node")
	public void when_I_click_on_the_landing_page_node(@Named("landingPageNode") String landingPageNode) {
		user.clickNavNode(landingPageNode);
	}

	@Then("the <landingPageNode> page should open correctly")
	public void then_the_landing_page_node_should_open_correctly(@Named("landingPageNode") String landingPageNode) {
		user.shouldSeePage(landingPageNode);
	}

	// Scenario: Verify all the menu links on the "Information" tab
	// given see above

	@When("I click on the <menuLinks> in the Information tab")
	public void when_i_click_on_the_menu_links_in_information_tab(@Named("menuLinks") String menuLinks) {
		user.clickInfoMenuLinks(menuLinks);
	}
	
	@When("I click on the <menuLinks> in the Information tab on mobile")
	public void when_i_click_on_the_menu_links_in_mobile_information(@Named("menuLinks") String menuLinks) {
		user.clickMobileInfoMenuLinks(menuLinks);
	}
	
	@When("I click on the <menuLinks> in the Information tab on mobile in spanish")
	public void when_i_click_on_the_spanish_menu_links_in_mobile_information(@Named("menuLinks") String menuLinks) {
		user.clickSpanishMobileInfoMenuLinks(menuLinks);
	}

	@When("I click on the <menuLinks> in the Spanish Information tab")
	public void when_i_click_on_the_menu_links_in_spanish_information_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishInfoMenuLinks(menuLinks);
	}

	// then see above

	// Scenario: Verify all of the nodes on the "Information" landing page
	@Given("I am on the Information landing page")
	public void given_I_am_on_the_Information_landing_page() {
		user.open_page("/information");
	}

	@Given("I am on the Information Spanish landing page")
	public void given_I_am_on_the_Information_Spanish_landing_page() {
		user.open_page("/es/información");
	}
	// when see above
	// then see above

	// Scenario: Verify the More/Less button is on each of the landing page
	// nodes under the "Information" landing page
	// given see above
	// when see above

	@Then("I click on the more button and content should appear under the title of the <landingPageNode>")
	public void click_on_more_button_on_each_landing_page_node(@Named("landingPageNode") String landingPageNode) {
		user.clickMore();
	}

	// Scenario: Verify all of the titles on the "News Feeds" landing page node
	// given see above
	// when see above

	@When("I am on the News Feeds landing page node")
	public void on_news_feeds_page() {
		user.open_page("/information/news-feeds");
	}

	@Then("all of the sub-titles should show on the page")
	public void all_sub_titles_should_show_on_the_page() {
		user.shouldSeeTitle();
	}

	@Then("all of the Spanish sub-titles should show on the page")
	public void all_spanish_sub_titles_should_show_on_the_page() {
		user.shouldSeeSpanishTitle();
	}

	// Scenario: Verify all of the titles on the "Immediate Needs" landing page
	// node
	@Given("I am on the Immediate Needs landing page node")
	public void i_am_on_the_immediate_needs_landing_page_node() {
		user.open_page("/information/immediate-needs");
	}

	@Given("I am on the Immediate Needs Spanish landing page node")
	public void i_am_on_the_immediate_needs_spanish_landing_page_node() {
		user.open_page("/es/información/necesidades-inmediatas");
	}

	@When("I click on the link under each <subTitle> on the Immediate Needs page")
	public void click_on_link_under_subtitle_on_immediate_needs_page(@Named("subTitle") String subTitle) {
		user.clickOnImmediateNeedsTitle(subTitle);
	}

	@When("I click on the link under each <subTitle> on the Immediate Needs Spanish page")
	public void click_on_link_under_subtitle_on_immediate_needs_spanish_page(@Named("subTitle") String subTitle) {
		user.clickOnSpanishImmediateNeedsTitle(subTitle);
	}

	@Then("the link under the <subTitle> should open")
	public void then_the_link_under_the_subtitle_open(@Named("subTitle") String subTitle) {
		user.shouldLoadPage(subTitle);
	}

	// Scenario: Verify all the menu links on the "About Us" tab
	// given see above

	@When("I click on the <menuLinks> in the About Us tab")
	public void click_on_menu_links_in_about_us_tab(@Named("menuLinks") String menuLinks) {
		user.clickAboutMenuLinks(menuLinks);
	}

	@When("I click on the <menuLinks> in the About Us tab on mobile")
	public void click_on_mobile_about_us(@Named("menuLinks") String menuLinks) {
		user.clickMobileAboutUsMenuLinks(menuLinks);
	}
	
	@When("I click on the <menuLinks> in the About Us tab on mobile in spanish")
	public void click_on_mobile_spanish_about_us(@Named("menuLinks") String menuLinks) {
		user.clickSpanishMobileAboutUsMenuLinks(menuLinks);
	}

	@When("I click on the <menuLinks> in the Spanish About Us tab")
	public void click_on_menu_links_in_spanish_about_us_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishAboutMenuLinks(menuLinks);
	}

	// then see above

	// Scenario: Verify all of the nodes on the "About Us" landing page
	@Given("I am on the About Us landing page")
	public void given_I_am_on_the_About_Us_landing_page() {
		user.open_page("/about-us");
	}

	@Given("I am on the About Us Spanish landing page")
	public void given_I_am_on_the_About_Us_Spanish_landing_page() {
		user.open_page("/es/acerca-de");
	}
	// when see above
	// then see above

	// Scenario: Verify all the menu links on the "Help" tab
	// given see above

	@When("I click on the <menuLinks> in the Help tab")
	public void click_on_menu_clicks_in_help_tab(@Named("menuLinks") String menuLinks) {
		user.clickHelpMenuLinks(menuLinks);
	}
	
	@When("I click on the <menuLinks> in the Help tab on mobile") 
	public void when_i_click_on_the_menu_links_in_help_mobile_tab(@Named("menuLinks") String menuLinks) {
		user.clickMobileHelpMenuLinks(menuLinks); 
	}
	
	@When("I click on the <menuLinks> in the Help tab on mobile in spanish")
	public void when_i_click_on_the_spanish_menu_links_in_help_mobile_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishMobileHelpMenuLinks(menuLinks);
	}

	@When("I click on the <menuLinks> in the Spanish Help tab")
	public void click_on_menu_clicks_in_spanish_help_tab(@Named("menuLinks") String menuLinks) {
		user.clickSpanishHelpMenuLinks(menuLinks);
	}

	// then see above

	// Scenario: Verify all of the nodes on the "Help" landing page
	@Given("I am on the Help landing page")
	public void given_I_am_on_the_Help_landing_page() {
		user.open_page("/help");
	}

	@Given("I am on the Help Spanish landing page")
	public void given_I_am_on_the_Help_Spanish_landing_page() {
		user.open_page("/es/ayuda");
	}
	// when see above
	// then see above

	// Scenario: Verify results of the questionnaire on the "Find Assistance"
	// page
	@Given("I am on the Find Assistance page")
	public void given_I_am_on_the_Find_Assistance_page() {
		user.open_page("/get-assistance/find-assistance");
	}

	@Given("I am on the Find Assistance Spanish page")
	public void given_I_am_on_the_Find_Assistance_Spanish_page() {
		user.open_page("/es/obtener-asistencia/encuentre-asistencia");
	}

	@When("I fully complete the questionnaire")
	public void when_I_answer_Yes_on_all_questions() {
		user.completeQuestionnaire();
	}

	@Then("I should accumulate 73 results")
	public void I_should_accumulate_73_results() {
		user.checkQuestionnaireResults();
	}

	// Scenario: Verify benefits results display according to use cases page

	// Given see above
	// Can't expand on mobile test
	// FIXME
	@When("I choose only Employment and expand all the accordions")
	public void when_I_choose_only_Employment_and_expand_all_the_accordions() {
		user.getEmploymentResults();
		user.clickExpandAll();
	}

	@When("I choose only Employment")
	public void when_I_choose_only_Employment() {
		user.getEmploymentResults();
		user.getFOAResultsPage();
	}

	@When("I choose only Empleo and expand all the accordions")
	public void when_I_choose_only_Empleo_and_expand_all_the_accordions() {
		user.getSpanishEmploymentResults();
		user.clickExpandAll();
	}

	@Then("I should obtain 9 results and see all the content under the accordions")
	public void then_I_should_obtain_9_results_and_see_all_the_content_under_the_accordions()
			throws EmploymentException {
		user.verifyEmploymentResultsandVisibility();
	}

	@Then("I should obtain 9 results")
	public void then_I_should_obtain_9_results() throws EmploymentException {
		user.verifyFOAResultsandVisibility();
	}

	// Scenario: Verify benefits on Assistance by Federal Agency page

	@Given("I am on the Assistance by Federal Agency page")
	public void given_I_am_on_the_Assistance_by_Federal_Agency_page() {
		user.open_page("/get-assistance/assistance-by-federal-agency");
	}

	@Given("I am on the Assistance by Federal Agency Spanish page")
	public void given_I_am_on_the_Assistance_by_Federal_Agency_Spanish_page() {
		user.open_page("/es/obtener-asistencia/asistencia-por-agencia-federal");
	}

	@When("I check on each Federal Agency accordion")
	public void when_I_check_each_Federal_Agency_accordion() {
		// FIXME ??
	}

	@Then("the number of benefits should match with its count")
	public void then_the_number_of_benefits_should_match_with_its_count() throws BenefitCountException {
		user.checkFederalBenefits();
	}

	// Scenario: Verify disaster map is visible

	// Given see above

	@When("I am viewing the declared disaster map")
	public void when_I_an_viewing_the_declared_disaster_map() throws StateException {
		user.checkDisasterMap();
	}

	@Then("states with disasters should be clickable")
	public void then_states_with_disasters_should_be_clickable() throws StateException {
		user.checkStates();
	}

	// Scenario: Verify that the FEMA Twitter feed is present on the homepage

	// Given see above

	@When("I am viewing the FEMA Twitter feed")
	public void when_I_am_viewing_the_FEMA_twitter_feed() throws FeedException {
		user.checkTwitterFeedBlock();
	}

	@Then("the most recent tweets should be displayed")
	public void then_the_most_recent_tweets_should_be_displayed() throws FeedException {
		user.checkTwitterFeed();
	}

	// Scenario: Verify Local Resources flows correctly

	// Given see above

	@When("I am attempting to find local resources")
	public void when_I_am_attempting_to_find_local_resources() {
		user.lookUpLocation();
	}

	@Then("information on resources should be visible")
	public void then_information_on_resources_should_be_visible() throws LocalResourcesException {
		user.verifyLocalResources();
	}

	// Dynamically verify results of the questionnaire on the "Find Assistance"
	// page
	// Given I am on the Find Assistance page
	// When I fully complete the questionnaire

	@Then("I should accumulate the same number of results as the text on the Get Results button")
	public void then_I_should_accumulate_same_number_of_results() {
		user.checkResults();
	}

	// Scenario: Verify all the functionality of the FOA questionnaire

	// given on the FOA page, declared above
	// when I complete the questionnaire, declared above

	@Then("I should expand all the accordions to see all of the content under the accordions")
	public void then_I_should_see_all_content_under_accordions() {
		user.verifyFOAExpandedContentVisible();
	}

	@When("I close all of the accordions")
	public void when_I_close_all_the_accordions() {
		user.clickCollapseAll();
	}

	@Then("none of the accordion content should be visible")
	public void then_none_of_the_accordion_content_should_be_visible() {
		user.verifyFOAExpandedContentIsHidden();
	}

	@Then("the 6 FOAs that everyone qualifies for should be visible under Additional Assistance and Resources")
	public void and_6_foas_should_be_visible_under_Additional_Assistance_Resources() {
		user.verifyNumberOfAdditionalFOA();
	}

	@Then("the 6 Spanish FOAs that everyone qualifies for should be visible under Additional Assistance and Resources")
	public void and_6_Spanish_foas_should_be_visible_under_Additional_Assistance_Resources() {
		user.verifyNumberOfAdditionalSpanishFOA();
	}

	@Then("each FOA should expand and collapse individually")
	public void and_each_FOA_should_expand_and_collapse_individually() {
		user.verifyIndividualAccordionContent();
	}

	@Then("the next and back buttons are displayed")
	public void and_the_next_and_back_buttons_are_displayed() {
		user.seesFOAFooter();
	}

	@When("I click next")
	public void when_user_clicks_next() {
		user.clicksNextFOA();
	}

	@Then("the 3 accordions should expand, collapse, and have content visible when open")
	public void then_the_3_accordions_expand_collapse_and_content_is_visible() {
		user.testsApplyOnlineAccordions();
	}

	@When("I click apply online")
	public void when_user_clicks_apply_online() {
		user.clicksApplyOnline();
	}
	
	@When("I click on apply online quick search item on mobile")
	public void when_i_click_mobile_apply_online_quick_search_item() {
		user.clickMobileApplyOnlineQuickSearch();
	}
	
	@Then("the DAC page should load on mobile")
	public void should_see_mobile_dac_page() {
		user.shouldSeeDACOnMobile();
	}

	@Then("the DAC page should load")
	public void then_DAC_page_should_load() {
		user.shouldSeeDAC();
	}

	// Scenario: Verify the search results on the Community Leaders page

	@Given("I am on the Community Leaders page on Disaster Assistance")
	public void givenOnTheCommunityLeadersPage() {
		user.onCommunityLeadersPage();
	}
	
	@Given("I am on the spanish Community Leaders page on Disaster Assistance")
	public void givenOnSpanishTheCommunityLeadersPage() {
		user.onSpanishCommunityLeadersPage();
	}

	@When("I type those tag words into the Community Leaders search field for the <siteName>")
	public void thenTypeTagWordsIntoCommunityLeadersSearchField(@Named("siteName") String siteName) {
		user.searchTextOnCommunityLeadersPage(siteName);
	}

	@Then("I should see that page in the search results")
	public void thenShouldSeePageInSearchResults() {
		user.searchResults();
	}

	// Scenario: Verify the pages under each site name

	@Given("I am on the drupal DA homepage")
	public void givenTheUserIsOnTheDrupalDAPage() {
		user.onHomepage();
	}

	@When("I log into drupal with username and password")
	public void whenTheUserLogsIntoDrupal() {
		user.fillInLogIn();
	}

	@Then("I click on the Manage Pages tab to pick a <siteName> and click on Get pages")
	public void thenClickOnManagePagesToPickASiteName(@Named("siteName") String siteName) {
		user.onManagePagesTab();
		user.getSiteNamePages(siteName);
	}

	@Then("the url for the <siteName> should be displayed")
	public void thenNumberOfPagesForSiteShouldBeDisplayed(@Named("siteName") String siteName) {
		user.urlOfPages(siteName);
	}

	// Scenario: Verify tag words of a specific page
	// given see above
	// when see above
	// then see above

	@Then("I click Edit on a page to view the tag words of the <siteName>")
	public void thenClickEditToViewTagWords(@Named("siteName") String siteName) {
		user.viewTagWords(siteName);
	}

	// Scenario: Verify the results of the quick search items
	// given see above

	@When("I type the search words into the Community Leaders search field for the <quickSearch> item")
	public void whenTypeSearchWordsForQuickSearchItems(@Named("quickSearch") String quickSearch) {
		user.clickQuickSearch(quickSearch); 
	}

	@Then("the results should include those search words")
	public void thenShouldIncludeSearchWords() {
		user.quickSearchResults();
	}
	
	// Scenario: Verify the declared states on the declared disaster map 
	// given see above 
	// when see above 
	
	@Then("I should be able to view the list of the declared states") 
	public void thenShouldBeAbleToViewListOfDeclaredStates() {
		user.checkDisasterState();
	}
	
	@Then("I should be able to view the list of the declared states in Spanish") 
	public void thenShouldBeAbleToViewListOfDeclaredStatesSpanish() {
		user.checkSpanishDisasterState();
	}
	
	//Scenario: Verify the declared disasters with Address Look-up
	
	@Given("I am on the declared disasters DAC page")
	public void givenOnDeclaredDisastersDACPage() {
		user.openDisasterDACPage();
	}
	
	@When("I type the declared disaster into the address look-up bar")
	public void whenTypeDeclaredDisasterIntoAddressLookUpBar() {
		user.declaredDisasters();
	}
	
	@When("I type the declared disaster into the address look-up bar in Spanish")
	public void whenTypeDeclaredDisasterIntoSpanishAddressLookUpBar() {
		user.declaredSpanishDisasters();
	}
	
	@Then("I should get the results for the given disaster")
	public void thenShouldGetResultsForGivenDisaster() {
		user.disasterResults();
	}
}
