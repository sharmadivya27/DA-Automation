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
	public void clickMainLink(String mainLink) {
		daPage.clickMainLink(mainLink);
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
			
		// Get Assistance
		case "get assistance":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "obtener asistencia":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "address look-up":
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
			break;
		case "buscar dirección":
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
			break;
		case "find assistance":
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
			break;
		case "encontrar ayuda" :
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
			break;
		case "apply online":
			Assert.assertEquals(true, daPage.textCaptchaIsDisplayed());
			break;
		case "solicitar asistencia":
			Assert.assertEquals(true, daPage.textCaptchaIsDisplayed());
			break;
		case "check your status":
			Assert.assertEquals(true, daPage.checkStatusPageIsDisplayed());
			break;
		case "revisar estatus":
			Assert.assertEquals(true, daPage.checkStatusPageIsDisplayed());
			break;
		case "assistance by catgory":
			Assert.assertEquals(15, daPage.getNumberAccordions());
			break;
		case "asistencia por categoría":
			Assert.assertEquals(15, daPage.getNumberAccordions());
			break;
		case "assistance by federal agency":
			Assert.assertEquals(14, daPage.getNumberAccordions());
			break;
		case "other recovery help":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "otra ayuda para recuperación":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "application checklist":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "lista de verificación para aplicarse":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "forms":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "formularios":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
			
		// Information
		case "information":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "información":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "news feeds":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "canales de noticias":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "immediate needs":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "necesidades inmediatas":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "moving forward":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "próximo paso":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "disabilities or access and functional needs":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "discapacidades o necesidades funcionales y de acceso":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "older americans":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "adultos mayores estadounidenses":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "children and families":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "niños y familias":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "disaster types":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "los Recursos del desastre":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "foreign disasters":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "desastres en el extranjero":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "fact sheets":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "hojas de datos":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
			
		// About Us
		case "about us":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "acerca de":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "overview":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "descripción general":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "partners":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			Assert.assertEquals(true, daPage.emailNewsletterFormIsDisplayed());
			break;
		case "socios":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			Assert.assertEquals(true, daPage.emailNewsletterFormIsDisplayed());
			break;
			
		// Help
		case "help":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "ayuda":
			Assert.assertEquals(true, daPage.landingPageNodeIsDisplayed());
			break;
		case "faqs":
			Assert.assertEquals(27, daPage.getNumberAccordions());
			break;
		case "preguntas Comunes":
			Assert.assertEquals(27, daPage.getNumberAccordions());
			break;
		case "contact us":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			Assert.assertEquals(true, daPage.emailNewsletterFormIsDisplayed());
			break;
		case "contáctenos":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			Assert.assertEquals(true, daPage.emailNewsletterFormIsDisplayed());
			break;
		case "privacy policy":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "política de privacidad":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "accessibility":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "accesibilidad":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "download plug-ins":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		case "descargar plug-ins":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		
		// Email quick link
		case "emails":
			Assert.assertEquals(true, daPage.emailFormIsDisplayed());
			break;
		case "correo electrónico":
			Assert.assertEquals(true, daPage.emailFormIsDisplayed());
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
