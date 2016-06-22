package gov.disasterassistance.daip.test;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
<<<<<<< HEAD
import gov.disasterassistance.daip.test.pageObject.DAPage;
=======
import gov.disasterassistance.daip.test.exceptions.StateException;
import gov.disasterassistance.daip.test.pageObject.*;
>>>>>>> f0ce147b873d9575923aa9f452bdce1aea930262
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
	public void open_page(String url) {
		daPage.clearCookies();
		daPage.openAt(url);
	}

	@Step
	public void clickNavNode(String node) {
		daPage.clickNavNode(node);
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
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
			break;

		case "get assistance":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "information":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "about us":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "help":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		// Get Assistance parent node
		case "address look-up":
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
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

		case "application checklist":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "forms":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		// Information parent node
		case "news feeds":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "immediate needs":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "moving forward":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "community resources":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "disabilities or access and functional needs":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "older americans":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "children and families":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "disaster types":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "foreign disasters":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "fact sheets":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		// About us parent node
		case "overview":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "partners":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		// Help parent node
		case "faqs":
			Assert.assertEquals(27, daPage.getNumberAccordions());
			break;

		case "contact us":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "privacy policy":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "accessibility":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;

		case "download plug-ins":
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
		Assert.assertEquals(73, daPage.getQuestionnaireResults());
	}
	
	@Step
	public void getEmploymentResults() {
		daPage.clickEmploymentCheckbox();
		daPage.getFOAResultsPage();
	}
	
	@Step
	public void verifyEmploymentResults() {
		Assert.assertEquals(9, daPage.getNumEmploymentResults());
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
	public void verifyExpandedMaterial() {
		Assert.assertTrue(daPage.accordVisible());
	}
		
	@Step
	public void checkDisasterMap() throws StateException {
		daPage.checkStates();
	}
}
