package gov.disasterassistance.daip.test;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import gov.disasterassistance.daip.test.pageObject.DAPage;
import net.thucydides.core.annotations.Step;

/*************************************************************************
 * 	The "user" that is performing all of the actions on the web page.
 * 	Provides an extra layer of abstraction so all the functions called
 *  are named to emulate actions that a real user would perform.
 * 
 * @author Chris Viqueira
 ************************************************************************/
public class User {
	DAPage daPage;

	@Step
	public void open_home_page() {
		daPage.clearCookies();
		daPage.open();
	}

	@Step
	public void open_page(String directoryPath) {
		daPage.clearCookies();
		daPage.openAt(daPage.defaultUrl + directoryPath);
	}

	@Step
	public void clickNavNode(String node) {
		daPage.clickNavNode(node);
	}

	@Step
	public void clickQuickLink(String quickLink) {
		daPage.clickQuickLink(quickLink);
	}
	
	@Step
	public void shouldSeeLandingPageNodes(short expected) {
		Assert.assertEquals(expected, daPage.numberOfLandingPageNodes());
	}


	/************************************************************************
	* 	Runs the assertions to make sure a page is valid using
	* 	simple checks such as comparing the page title.
	*
	*	@param expectedPageName : name of the page being tested
	*************************************************************************/	
	@Step
	public void shouldSeePage(String expectedPageName) {
		String pageTitle = "";
		try {
			pageTitle = daPage.pullPageTitle();
		} catch (NoSuchElementException e) {
			// do nothing
		}

		switch (expectedPageName) {
		case "home":
		case "inicio":
		case "address look-up":
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
			break;

		case "get assistance":
		case "information":
		case "about us":
		case "help":
		case "application checklist":
		case "forms":
		case "news feeds":
		case "immediate needs":
		case "moving forward":
		case "community resources":
		case "disabilities or access and functional needs":
		case "older americans":
		case "children and families":
		case "disaster types":
		case "foreign disasters":
		case "fact sheets":
		case "overview":
		case "partners":
		case "contact us":
		case "privacy policy":
		case "accessibility":
		case "download plug-ins":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "find assistance":
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
			break;

		case "apply online":
			Assert.assertEquals(true, daPage.textCaptchaIsDisplayed());
			break;

		case "check your status":
			Assert.assertEquals(true, daPage.checkStatusPageIsDisplayed());
			break;

		case "assistance by catgory":
			Assert.assertEquals(15, daPage.getNumberAccordions());
			break;

		case "assistance by federal agency":
			Assert.assertEquals(14, daPage.getNumberAccordions());
			break;

		
		
		// Help parent node
		case "faqs":
			Assert.assertEquals(27, daPage.getNumberAccordions());
			break;
		case "emails":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		default:
			System.err.println("INVALID PAGE SENT");
			break;

		} // end switch
	}

	@Step
	public void completeQuestionnaire() {
		daPage.completeFullQuestionnaire();
		daPage.getFOAResultsPage();
	}

	@Step
	public void checkQuestionnaireResults() {
		Assert.assertEquals(73, daPage.getNumQuestionnaireResults());
	}
	
	@Step
	public void getEmploymentResults() {
		daPage.clickEmploymentCheckbox();
		daPage.getFOAResultsPage();
	}
	
	@Step
	public void getSpanishEmploymentResults() {
		daPage.clickSpanishEmploymentCheckbox();
		daPage.getFOAResultsPage();
	}
	
	@Step
	public void verifyEmploymentResultsandVisibility() throws EmploymentException {
		Assert.assertEquals(9, daPage.getNumEmploymentResults());
		daPage.verifyEmploymentVisibility();
	}
	
	@Step
	public void checkFederalBenefits() throws BenefitCountException {
		daPage.checkFederalBenefits();
	}
	
	@Step
	public void clickExpandAll() {
		daPage.expandFOAResults();
	}
	
	@Step
	public void clickCollapseAll() {
		daPage.collapseFOAResults();
	}
	
	@Step
	public void verifyFOAExpandedContentVisible() {
		Assert.assertEquals(73, daPage.getNumEmploymentResults());
	}
	
	@Step
	public void verifyFOAExpandedContentIsHidden() {
		Assert.assertEquals(0, daPage.getNumExpandedQuestionnaireResults());
	}
		
	@Step
	public void checkDisasterMap() throws StateException {
		daPage.checkDisasterMap();
	}
	
	@Step
	public void checkStates() throws StateException {
		daPage.checkStates();
	}
	
	@Step
	public void checkTwitterFeedBlock() throws FeedException {
		daPage.checkTwitterFeedBlock();
	}
	
	@Step
	public void checkTwitterFeed() throws FeedException {
		daPage.checkTwitterFeed();
	}
	
	@Step
	public void lookUpLocation() {
		daPage.lookUpLocation();
	}
	
	@Step
	public void verifyLocalResources() throws LocalResourcesException {
		daPage.verifyLocalResourcesResults();
	}
	
	@Step
	public void verifyNumberOfAdditionalFOA() {
		Assert.assertEquals(6, daPage.getNumAdditionalFOA());
	}
	
	@Step
	public void verifyNumberOfAdditionalSpanishFOA() {
		Assert.assertEquals(6, daPage.getNumAdditionalSpanishFOA());
	}
	
	@Step
	public void verifyIndividualAccordionContent() {
		Assert.assertEquals(73, daPage.clickIndividualFOAs());
	}
	
	@Step
	public void seesFOAFooter() {
		Assert.assertTrue(daPage.foaFooterIsVisible());
	}
	
	@Step
	public void clicksNextFOA() {
		daPage.clickNextFOA();
	}
	
	@Step
	public void testsApplyOnlineAccordions() {
		Assert.assertEquals(3, daPage.numApplyOnlineFOAs());
	}
	
	@Step
	public void clicksApplyOnline() {
		daPage.clickApplyOnline();
	}
	
	@Step
	public void shouldSeeDAC() {
		Assert.assertTrue(daPage.textCaptchaIsDisplayed());
	}
}
