package gov.disasterassistance.daip.test;

import org.junit.Assert;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import gov.disasterassistance.daip.test.pageObject.DALandingPage;
import gov.disasterassistance.daip.test.pageObject.DAFederalAgency;
import gov.disasterassistance.daip.test.pageObject.DAHomepage;
import gov.disasterassistance.daip.test.pageObject.DAPage;
import gov.disasterassistance.daip.test.pageObject.DAQuestionnaire;
import net.thucydides.core.annotations.Step;

/*************************************************************************
 * The "user" that is performing all of the actions on the web page. Provides an
 * extra layer of abstraction so all the functions called are named to emulate
 * actions that a real user would perform.
 * 
 * @author Chris Viqueira
 ************************************************************************/
public class User {
	DAPage dapage;
	DAHomepage daHomepage;
	DAQuestionnaire daQuesPage;
	DALandingPage daLanding;
	DAFederalAgency daFedAgency;

	/*********************************************/

	@Step
	public void home() {
		daHomepage.getDriver().get("https://www.disasterassistance.gov");
	}

	@Step
	public void clickIcon() {
		dapage.clickIcon();
	}

	@Step
	public void seeHome() {
		Assert.assertEquals("Home | DisasterAssistance.gov | Access to Disaster Help and Resources",
				dapage.shouldSeeHome());
	}

	/*********************************************/

	@Step
	public void open_page(String directoryPath) {
		dapage.clearCookies();

		String url = dapage.defaultUrl + directoryPath;
		if (dapage.defaultUrl.contains("staging")) {
			url += "?mobile=unL9HuS";
		}

		daHomepage.openAt(url);
	}

	@Step
	public void clickNavNode(String node) {
		daLanding.clickNavNode(node);
	}

	@Step
	public void clickQuickLink(String quickLink) {
		daHomepage.clickQuickLink(quickLink);
	}

	@Step
	public void clickMainLink(String mainLink) {
		daHomepage.clickMainLink(mainLink);
	}

	@Step
	public void shouldSeeLandingPageNodes(short expected) {
		Assert.assertEquals(expected, daHomepage.numberOfLandingPageNodes());
	}

	/************************************************************************
	 * Runs the assertions to make sure a page is valid using simple checks such
	 * as comparing the page title.
	 *
	 * @param expectedPageName
	 *            : name of the page being tested
	 *************************************************************************/
	@Step
	public void shouldSeePage(String expectedPageName) {

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
			// TODO: Should this assertion be done on all pages?
			// If so, delete all cases above this and move this assertion to
			// after switch
			Assert.assertEquals(expectedPageName.toLowerCase(), daHomepage.pullPageTitle().toLowerCase());
			break;

		case "home":
		case "inicio":
		case "address look-up":
		case "buscar dirección":
			Assert.assertEquals(true, daHomepage.addressLookupIsDisplayed());
			break;

		case "find assistance":
			Assert.assertEquals(true, daHomepage.questionnaireIsDisplayed());
			break;
		case "encontrar ayuda":
			Assert.assertEquals(true, daHomepage.questionnaireIsDisplayed());
			break;
		case "revisar estatus":
		case "solicitar asistencia":
		case "check your status":
		case "apply online":
			boolean dacPageVisible = (daHomepage.checkStatusPageIsDisplayed() || daHomepage.dacPageIsDisplayed());
			Assert.assertEquals(true, dacPageVisible);
			break;
		case "assistance by catgory":
			Assert.assertEquals(15, daHomepage.getNumberAccordions());
			break;
		case "asistencia por categoría":
			Assert.assertEquals(15, daHomepage.getNumberAccordions());
			break;
		case "assistance by federal agency":
			Assert.assertEquals(14, daHomepage.getNumberAccordions());
			break;

		case "faqs":
			Assert.assertEquals(28, daHomepage.getNumberAccordions());
			break;
		case "preguntas Comunes":
			Assert.assertEquals(27, daHomepage.getNumberAccordions());
			break;

		case "emails":
			Assert.assertEquals(true, daHomepage.emailFormIsDisplayed());
			break;
		case "correo electrónico":
			Assert.assertEquals(true, daHomepage.emailFormIsDisplayed());
			break;

		default:
			System.err.println("INVALID PAGE SENT");
			break;

		} // end switch
	}

	@Step
	public void clickMore() {
		daLanding.clickMore();
		Assert.assertTrue(daLanding.contentDisplayed());
	}

	@Step
	public void clickOnImmediateNeedsTitle(String subTitle) {
		if (subTitle.equals("Evacuate")) {
			daLanding.clickEvacuate();
			daHomepage.pause(1000);
		} else if (subTitle.equals("Stay Put and Shelter in Place")) {
			daLanding.clickShelterInPlace();
		} else if (subTitle.equals("Finding Lost Family and Friends")) {
			daLanding.clickFindingLostFamily();
		} else if (subTitle.equals("Finding and Caring for Pets")) {
			daLanding.clickFindingPets();
		} else if (subTitle.equals("Find a Safe Place to Go")) {
			daLanding.clickFindSafePlace();
		}
	}

	@Step
	public void clickGetAssistanceMenuLinks(String menuLinks) {
		if (menuLinks.equals("address look-up")) {
			daHomepage.clickAddressLookUp();
		} else if (menuLinks.equals("find assistance")) {
			daHomepage.clickFindAssistance();
		} else if (menuLinks.equals("apply online")) {
			daHomepage.clickApplyOnline();
		} else if (menuLinks.equals("check your status")) {
			daHomepage.clickCheckYourStatus();
		} else if (menuLinks.equals("assistance by category")) {
			daHomepage.clickAssistanceCategory();
		} else if (menuLinks.equals("assistance by federal agency")) {
			daHomepage.clickAssistanceFederal();
		} else if (menuLinks.equals("other recovery help")) {
			daHomepage.clickOtherHelp();
		} else if (menuLinks.equals("application checklist")) {
			daHomepage.clickApplicationChecklist();
		} else if (menuLinks.equals("forms")) {
			daHomepage.clickForms();
		}
	}

	@Step
	public void clickInfoMenuLinks(String menuLinks) {
		if (menuLinks.equals("news feeds")) {
			daHomepage.clickNewsFeeds();
		} else if (menuLinks.equals("immediate needs")) {
			daHomepage.clickImmediateNeeds();
		} else if (menuLinks.equals("moving forward")) {
			daHomepage.clickMovingForward();
		} else if (menuLinks.equals("disabilities or access and functional needs")) {
			daHomepage.clickDisabilities();
		} else if (menuLinks.equals("older americans")) {
			daHomepage.clickOlderAmericans();
		} else if (menuLinks.equals("children and families")) {
			daHomepage.clickChildrenAndFamilies();
		} else if (menuLinks.equals("disaster types")) {
			daHomepage.clickDisasterTypes();
		} else if (menuLinks.equals("foreign disasters")) {
			daHomepage.clickForeignDisasters();
		} else if (menuLinks.equals("fact sheets")) {
			daHomepage.clickFactSheets();
		}
	}

	@Step
	public void clickAboutMenuLinks(String menuLinks) {
		if (menuLinks.equals("overview")) {
			daHomepage.clickOverview();
		} else if (menuLinks.equals("partners")) {
			daHomepage.clickPartners();
		}
	}

	@Step
	public void clickHelpMenuLinks(String menuLinks) {
		if (menuLinks.equals("faqs")) {
			daHomepage.clickFaqs();
		} else if (menuLinks.equals("contact us")) {
			daHomepage.clickContactUs();
		} else if (menuLinks.equals("privacy policy")) {
			daHomepage.clickPrivacyPolicy();
		} else if (menuLinks.equals("accessibility")) {
			daHomepage.clickAccessibility();
		} else if (menuLinks.equals("download plug-ins")) {
			daHomepage.clickDownload();
		}
	}

	@Step
	public void shouldLoadPage(String subTitle) {
		Assert.assertTrue(daLanding.urlOpened());
	}
	
	@Step
	public void shouldSeeTitle() {
		Assert.assertEquals("Recently Declared Disasters", daLanding.disasterTitle());
		Assert.assertEquals("Severe Storms", daLanding.stormTitle());
		Assert.assertEquals("Hurricanes", daLanding.hurricaneTitle());
		Assert.assertEquals("Earthquakes", daLanding.earthquakesTitle());
		Assert.assertEquals("Drought", daLanding.droughtTitle());
		//FIXME
		//Assert.assertEquals("Wildfire", daLanding.wildfireTitle());
	}

	@Step
	public void completeQuestionnaire() {
		daQuesPage.completeFullQuestionnaire();
		daHomepage.pause(1000);
	}

	@Step
	public void checkQuestionnaireResults() {
		daQuesPage.getFOAResultsPage();
		Assert.assertEquals(73, daQuesPage.getNumQuestionnaireResults());
	}

	@Step
	public void checkResults() {
		int i = daQuesPage.getResultsVal();
		daQuesPage.getFOAResultsPage();
		Assert.assertEquals(i, daQuesPage.getNumQuestionnaireResults());
	}

	@Step
	public void getEmploymentResults() {
		daQuesPage.clickEmploymentCheckbox();
	}

	@Step
	public void getSpanishEmploymentResults() {
		daQuesPage.clickSpanishEmploymentCheckbox();
	}

	@Step
	public void verifyEmploymentResultsandVisibility() throws EmploymentException {
		Assert.assertEquals(9, daQuesPage.getNumEmploymentResults());
		daQuesPage.verifyEmploymentVisibility();
	}

	@Step
	public void checkFederalBenefits() throws BenefitCountException {
		daFedAgency.checkFederalBenefits();
	}

	@Step
	public void clickExpandAll() {
		daQuesPage.getFOAResultsPage();
		daQuesPage.expandFOAResults();
	}

	@Step
	public void clickCollapseAll() {
		daQuesPage.collapseFOAResults();
	}

	@Step
	public void verifyFOAExpandedContentVisible() {
		int i = daQuesPage.getResultsVal();
		clickExpandAll();
		Assert.assertEquals(i, daQuesPage.getNumEmploymentResults());
	}

	@Step
	public void verifyFOAExpandedContentIsHidden() {
		Assert.assertEquals(0, daQuesPage.getNumExpandedQuestionnaireResults());
	}

	@Step
	public void checkDisasterMap() throws StateException {
		daHomepage.checkDisasterMap();
	}

	@Step
	public void checkStates() throws StateException {
		daHomepage.checkStates();
	}

	@Step
	public void checkTwitterFeedBlock() throws FeedException {
		daHomepage.checkTwitterFeedBlock();
	}

	@Step
	public void checkTwitterFeed() throws FeedException {
		daHomepage.checkTwitterFeed();
	}

	@Step
	public void lookUpLocation() {
		daHomepage.lookUpLocation();
	}

	@Step
	public void verifyLocalResources() throws LocalResourcesException {
		daHomepage.verifyLocalResourcesResults();
	}

	@Step
	public void verifyNumberOfAdditionalFOA() {
		Assert.assertEquals(6, daQuesPage.getNumAdditionalFOA());
	}

	@Step
	public void verifyNumberOfAdditionalSpanishFOA() {
		Assert.assertEquals(6, daQuesPage.getNumAdditionalSpanishFOA());
	}

	@Step
	public void verifyIndividualAccordionContent() {
		Assert.assertEquals(73, daQuesPage.clickIndividualFOAs());
	}

	@Step
	public void seesFOAFooter() {
		Assert.assertTrue(daQuesPage.foaFooterIsVisible());
	}

	@Step
	public void clicksNextFOA() {
		daQuesPage.clickNextFOA();
	}

	@Step
	public void testsApplyOnlineAccordions() {
		Assert.assertEquals(3, daQuesPage.numApplyOnlineFOAs());
	}

	@Step
	public void clicksApplyOnline() {
		daQuesPage.clickApplyOnline();
	}

	@Step
	public void shouldSeeDAC() {
		daHomepage.pause(2000);
		boolean dacPageVisible = (daQuesPage.checkStatusPageIsDisplayed() || daQuesPage.dacPageIsDisplayed());
		Assert.assertEquals(true, dacPageVisible);
	}

}