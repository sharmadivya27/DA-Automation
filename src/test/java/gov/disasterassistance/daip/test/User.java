package gov.disasterassistance.daip.test;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import gov.disasterassistance.daip.test.pageObject.DAPage;
import gov.disasterassistance.daip.test.pageObject.DAPageParent;
import gov.disasterassistance.daip.test.pageObject.aboutUs.DAOverview;
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

	DAPageParent page;
	
	@Step
	public void openTestPage() {
		page.openTestPage();
	}	
	
	@Step
	public void goToNewPage() {
		page.switchToPage(DAOverview.class);
		page.openTestPage();
	}

	@Step
	public void seeTitle() {
		Assert.assertEquals("Wrong", page.getPageTitle());
 	}	
	
	
	
	/*******************************************************************************/

	@Step
	public void open_page(String directoryPath) {
		daPage.clearCookies();
		
		String url = daPage.defaultUrl + directoryPath;
		if(daPage.defaultUrl.contains("staging")) {
			url += "?mobile=unL9HuS";
		}
		
		daPage.openAt(url);
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
		case "get assistance":
		case "obtener asistencia":
		case "information":
		case "información":
		case "about us":
		case "acerca de":
		case "help":
		case "ayuda":
		case "other recovery help":
		case "otra ayuda para recuperación":
		case "application checklist":
		case "lista de verificación para aplicarse":
		case "forms":
		case "formularios":
		case "news feeds":
		case "canales de noticias \"feeds\"":
		case "immediate needs":
		case "necesidades inmediatas":
		case "moving forward":
		case "community resources":
		case "próximo paso":
		case "disabilities or access and functional needs":
		case "discapacidades o necesidades funcionales y de acceso":
		case "older americans":
		case "adultos mayores estadounidenses":
		case "children and families":
		case "niños y familias":
		case "disaster types":
		case "los Recursos del desastre":
		case "foreign disasters":
		case "desastres en el extranjero":
		case "fact sheets":
		case "hojas de datos":
		case "overview":
		case "descripción general":
		case "partners":
		case "socios":
		case "contact us":
		case "contáctenos":
		case "privacy policy":
		case "política de privacidad":
		case "accessibility":
		case "accesibilidad":
		case "download plug-ins":
		case "descargar plug-ins":
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
		
		case "home":
		case "inicio":
		case "address look-up":
		case "buscar dirección":
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
			break;
			
		case "find assistance":
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
			break;
		case "encontrar ayuda" :
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
			break;
		case "revisar estatus":
		case "solicitar asistencia":
		case "check your status":
		case "apply online":
			boolean dacPageVisible = (daPage.checkStatusPageIsDisplayed() || daPage.dacPageIsDisplayed());
			Assert.assertEquals(true, dacPageVisible);
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
		
		case "faqs":
			Assert.assertEquals(28, daPage.getNumberAccordions());
			break;
		case "preguntas Comunes":
			Assert.assertEquals(27, daPage.getNumberAccordions());
			break;
		
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
		daPage.pause(1000);
	}

	@Step
	public void checkQuestionnaireResults() {
		daPage.getFOAResultsPage();
		Assert.assertEquals(73, daPage.getNumQuestionnaireResults());
	}
	
	@Step
	public void checkResults() {
		int i = daPage.getResultsVal();
		daPage.getFOAResultsPage();
		Assert.assertEquals(i, daPage.getNumQuestionnaireResults());
	}
	
	@Step
	public void getEmploymentResults() {
		daPage.clickEmploymentCheckbox();
	}
	
	@Step
	public void getSpanishEmploymentResults() {
		daPage.clickSpanishEmploymentCheckbox();
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
		daPage.getFOAResultsPage();
		daPage.expandFOAResults();
	}
	
	@Step
	public void clickCollapseAll() {
		daPage.collapseFOAResults();
	}
	
	@Step
	public void verifyFOAExpandedContentVisible() {
		int i = daPage.getResultsVal();
		clickExpandAll();
		Assert.assertEquals(i, daPage.getNumEmploymentResults());
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
		daPage.pause(2000);
		boolean dacPageVisible = (daPage.checkStatusPageIsDisplayed() || daPage.dacPageIsDisplayed());
		Assert.assertEquals(true, dacPageVisible);
	}
}
