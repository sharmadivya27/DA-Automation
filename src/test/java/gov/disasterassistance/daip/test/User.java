package gov.disasterassistance.daip.test;

import org.junit.Assert;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import gov.disasterassistance.daip.test.pageObject.DAFederalAgency;
import gov.disasterassistance.daip.test.pageObject.DAHomepage;
import gov.disasterassistance.daip.test.pageObject.DALandingPage;
import gov.disasterassistance.daip.test.pageObject.DAPage;
import gov.disasterassistance.daip.test.pageObject.DAQuestionnaire;
import gov.disasterassistance.daip.test.pageObject.DrupalPage;
import net.thucydides.core.annotations.Step;

/*************************************************************************
 * The "user" that is performing all of the actions on the web page. Provides an
 * extra layer of abstraction so all the functions called are named to emulate
 * actions that a real user would perform.
 * 
 * @author Chris Viqueira
 * @author Divya Sharma
 ************************************************************************/
public class User {
	DAPage dapage;
	DAHomepage daHomepage;
	DAQuestionnaire daQuesPage;
	DALandingPage daLanding;
	DAFederalAgency daFedAgency;
	DrupalPage drupalPage;

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
		if ((mainLink.equals("find assistance")) || (mainLink.equals("encontrar ayuda"))) {
			daHomepage.clickAssistanceMainLink();
			daHomepage.pause(2000);
		} else if ((mainLink.equals("apply online")) || (mainLink.equals("solicitar asistencia"))) {
			daHomepage.clickApplyOnlineMainLink();
			daHomepage.pause(2000);
		} else if ((mainLink.equals("check status")) || (mainLink.equals("revisar estatus"))) {
			daHomepage.clickCheckStatusMainLink();
			daHomepage.pause(2000);
		}
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
		case "community leaders":
		case "líderes comunitarios":
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
	public void clickOnSpanishImmediateNeedsTitle(String subTitle) {
		if (subTitle.equals("Evacuación")) {
			daLanding.clickEvacuate();
			daHomepage.pause(1000);
		} else if (subTitle.equals("Permanezca Donde Está y Refúgiese")) {
			daLanding.clickShelterInPlace();
		} else if (subTitle.equals("Búsqueda de familiares y amigos perdidos")) {
			daLanding.clickFindingLostFamily();
		} else if (subTitle.equals("Búsqueda y cuidado de mascotas")) {
			daLanding.clickFindingPets();
		} else if (subTitle.equals("Busque un Lugar Seguro Donde Ir")) {
			daLanding.clickFindSafePlace();
		}
	}

	@Step
	public void clickGetAssistanceMenuLinks(String menuLinks) {
		// daHomepage.clickMobileMenu();
		if ((menuLinks.equals("address look-up")) || (menuLinks.equals("buscar dirección"))) {
			daHomepage.clickAddressLookUp();
		} else if ((menuLinks.equals("find assistance")) || (menuLinks.equals("encuentre asistencia"))) {
			daHomepage.clickFindAssistance();
		} else if ((menuLinks.equals("apply online")) || (menuLinks.equals("solicitar asistencia"))) {
			daHomepage.clickApplyOnline();
		} else if ((menuLinks.equals("check your status")) || (menuLinks.equals("revisar estatus"))) {
			daHomepage.clickCheckYourStatus();
		} else if ((menuLinks.equals("assistance by category")) || (menuLinks.equals("asistencia por categoría"))) {
			daHomepage.clickAssistanceCategory();
		} else if ((menuLinks.equals("assistance by federal agency"))
				|| (menuLinks.equals("asistencia por agencia federal"))) {
			daHomepage.clickAssistanceFederal();
		} else if ((menuLinks.equals("other recovery help")) || (menuLinks.equals("otra ayuda para recuperación"))) {
			daHomepage.clickOtherHelp();
		} else if ((menuLinks.equals("community leaders"))) {
			daHomepage.clickCommLeaders();
		} else if ((menuLinks.equals("application checklist"))
				|| (menuLinks.equals("lista de verificación para aplicarse"))) {
			daHomepage.clickApplicationChecklist();
		} else if ((menuLinks.equals("forms")) || (menuLinks.equals("formularios"))) {
			daHomepage.clickForms();
		}
	}

	@Step
	public void clickSpanishGetAssistanceTab(String menuLinks) {
		if (menuLinks.equals("buscar dirección")) {
			daHomepage.clickSpanishAddressLookUp();
		} else if (menuLinks.equals("encuentre asistencia")) {
			daHomepage.clickSpanishFindAssistance();
		} else if (menuLinks.equals("solicitar asistencia")) {
			daHomepage.clickSpanishApplyOnline();
		} else if (menuLinks.equals("revisar estatus")) {
			daHomepage.clickSpanishCheckStatus();
		} else if (menuLinks.equals("asistencia por categoría")) {
			daHomepage.clickSpanishAssistanceCategory();
		} else if (menuLinks.equals("asistencia por agencia federal")) {
			daHomepage.clickSpanishAssistanceFederal();
		} else if (menuLinks.equals("otra ayuda para recuperación")) {
			daHomepage.clickSpanishOtherHelp();
		} else if (menuLinks.equals("lista de verificación para aplicarse")) {
			daHomepage.clickSpanishApplicationChecklist();
		} else if (menuLinks.equals("formularios")) {
			daHomepage.clickSpanishForms();
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
	public void clickSpanishInfoMenuLinks(String menuLinks) {
		if (menuLinks.equals("canales de noticias")) {
			daHomepage.clickSpanishNewsFeeds();
		} else if (menuLinks.equals("necesidades inmediatas")) {
			daHomepage.clickSpanishImmediateNeeds();
		} else if (menuLinks.equals("próximo paso")) {
			daHomepage.clickSpanishMovingForward();
		} else if (menuLinks.equals("discapacidades o necesidades funcionales y de acceso")) {
			daHomepage.clickSpanishDisabilities();
		} else if (menuLinks.equals("adultos mayores estadounidenses")) {
			daHomepage.clickSpanishOlderAmericans();
		} else if (menuLinks.equals("niños y familias")) {
			daHomepage.clickSpanishChildrenAndFamilies();
		} else if (menuLinks.equals("los recursos del desastre")) {
			daHomepage.clickSpanishDisasterTypes();
		} else if (menuLinks.equals("desastres en el extranjero")) {
			daHomepage.clickSpanishForeignDisasters();
		} else if (menuLinks.equals("hojas de datos")) {
			daHomepage.clickSpanishFactSheets();
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
	public void clickMobileAboutMenuLinks(String menuLinks) {
		if (menuLinks.equals("overview")) {
			daHomepage.clickMobileMenu();
			daHomepage.pause(3000);
			daHomepage.clickMobileOverview();
		} else if (menuLinks.equals("partners")) {
			daHomepage.clickMobileMenu();
			daHomepage.clickMobilePartners();
		}
	}

	@Step
	public void clickSpanishAboutMenuLinks(String menuLinks) {
		if (menuLinks.equals("descripción general")) {
			daHomepage.clickSpanishOverview();
		} else if (menuLinks.equals("socios")) {
			daHomepage.clickSpanishPartners();
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
	public void clickSpanishHelpMenuLinks(String menuLinks) {
		if (menuLinks.equals("preguntas comunes")) {
			daHomepage.clickSpanishFaqs();
		} else if (menuLinks.equals("contáctenos")) {
			daHomepage.clickSpanishContactUs();
		} else if (menuLinks.equals("política de privacidad")) {
			daHomepage.clickSpanishPrivacyPolicy();
		} else if (menuLinks.equals("accesibilidad")) {
			daHomepage.clickSpanishAccessibility();
		} else if (menuLinks.equals("descargar plug-ins")) {
			daHomepage.clickSpanishDownload();
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
		// FIXME
		// Assert.assertEquals("Wildfire", daLanding.wildfireTitle());
	}

	@Step
	public void shouldSeeSpanishTitle() {
		Assert.assertEquals("Desastres Declarados Recientemente (en inglés)", daLanding.disasterTitle());
		Assert.assertEquals("Tormentas Severas (en inglés)", daLanding.stormTitle());
		Assert.assertEquals("Huracanes (en inglés)", daLanding.hurricaneTitle());
		Assert.assertEquals("Terremotos (en inglés)", daLanding.earthquakesTitle());
		Assert.assertEquals("Sequía (en inglés)", daLanding.droughtTitle());
		// Assert.assertEquals("Incendios Forestales (en inglés)",
		// daLanding.wildfireTitle());
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
	public void getFOAResultsPage() {
		daQuesPage.getFOAResultsPage();
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
	public void verifyFOAResultsandVisibility() throws EmploymentException {
		Assert.assertEquals(9, daQuesPage.getNumQuestionnaireResults());
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

	@Step
	public void onCommunityLeadersPage() {
		drupalPage.openAt("https://www.disasterassistance.gov/get-assistance/community-leaders");
	}

	@Step
	public void searchTextOnCommunityLeadersPage(String siteName) {
		if (siteName.equals("Grants")) {
			drupalPage.searchGrantsText();
		} else if (siteName.equals("Fema")) {
			drupalPage.searchFemaText();
		}
		
	}

	@Step
	public void searchResults() {
		drupalPage.showResults();
	}

	@Step
	public void onHomepage() {
		drupalPage.open();
	}

	@Step
	public void fillInLogIn() {
		drupalPage.logIntoDrupal();
	}

	@Step
	public void onManagePagesTab() {
		drupalPage.onElasticSearchPage();
		drupalPage.clickManagePages();
		// drupalPage.getGrantPages();
	}

	@Step
	public void getSiteNamePages(String siteName) {
		if (siteName.equals("DisasterAssistance")) {
			drupalPage.getDAPages();
		} else if (siteName.equals("Benefits")) {
			drupalPage.getBenefitsPages();
		} else if (siteName.equals("Ready")) {
			drupalPage.getReadyPages();
		} else if (siteName.equals("NRN")) {
			drupalPage.getNRNPages();
		} else if (siteName.equals("Grants")) {
			drupalPage.getGrantPages();
		} else if (siteName.equals("USA.gov")) {
			drupalPage.getUSAGovPages();
		} else if (siteName.equals("Fema")) {
			drupalPage.getFemaPages();
		} else if (siteName.equals("CFDA")) {
			drupalPage.getCFDAPages();
		} else if (siteName.equals("DHS")) {
			drupalPage.getDHSPages();
		} else if (siteName.equals("Redcross")) {
			drupalPage.getRedcrossPages();
		} else if (siteName.equals("HHS")) {
			drupalPage.getHHSPages();
		} else if (siteName.equals("SBA")) {
			drupalPage.getSBAPages();
		} else if (siteName.equals("FCC")) {
			drupalPage.getFCCPages();
		} else if (siteName.equals("HUD")) {
			drupalPage.getHUDPages();
		} else if (siteName.equals("EPA")) {
			drupalPage.getEPAPages();
		} else if (siteName.equals("Energy")) {
			drupalPage.getEnergyPages();
		} else if (siteName.equals("CDC")) {
			drupalPage.getCDCPages();
		}
	}

	@Step
	public void urlOfPages(String siteName) {
		if (siteName.equals("DisasterAssistance")) {
			Assert.assertEquals("https://www.disasterassistance.gov/get-assistance/application-checklist", drupalPage.getFirstUrl());
		} else if (siteName.equals("Benefits")) {
			Assert.assertEquals("https://www.benefits.gov/benefits/benefit-details/1504", drupalPage.getFirstUrl());
		} else if (siteName.equals("Ready")) {
			Assert.assertEquals("https://www.ready.gov/american-red-cross", drupalPage.getFirstUrl());
		} else if (siteName.equals("NRN")) {
			Assert.assertEquals("http://www.nationalresourcenetwork.org/en/Page/19/Communities_Eligible_for_311_for_Cities_", drupalPage.getFirstUrl());
		} else if (siteName.equals("Grants")) {
			Assert.assertEquals("https://www.grants.gov/web/grants/applicants/applicant-eligibility.html", drupalPage.getFirstUrl());
		} else if (siteName.equals("USA.gov")) {
			Assert.assertEquals("No pages available.", drupalPage.noPages());
		} else if (siteName.equals("Fema")) {
			Assert.assertEquals("https://www.fema.gov/media-library-data/1448917365279-3a7949605bd9e03633af2473a5741aa9/Section_0_PM_Combined.pdf", drupalPage.getFirstUrl());
		} else if (siteName.equals("CFDA")) {
			Assert.assertEquals("https://www.cfda.gov/downloads/CFDA_2016.pdf", drupalPage.getFirstUrl());
		} else if (siteName.equals("DHS")) {
			Assert.assertEquals("https://www.dhs.gov/sites/default/files/publications/2014%20National%20Emergency%20Communications%20Plan_October%2029%202014.pdf", drupalPage.getFirstUrl());
		} else if (siteName.equals("Redcross")) {
			Assert.assertEquals("http://maps.redcross.org/website/", drupalPage.getFirstUrl());
		} else if (siteName.equals("HHS")) {
			Assert.assertEquals("https://search.hhs.gov/search?q=community+disaster+recovery&HHS=Search&site=HHS&entqr=3&ud=1&sort=date%3AD%3AL%3Ad1&output=xml_no_dtd&ie=UTF-8&oe=UTF-8&lr=lang_en&client=HHS&proxystylesheet=HHS", drupalPage.getFirstUrl());
		} else if (siteName.equals("SBA")) {
			Assert.assertEquals("https://www.sba.gov/sites/default/files/articles/FINAL_2016_SBA_Disaster_Preparedness_Plan_v_3-0.pdf", drupalPage.getFirstUrl());
		} else if (siteName.equals("FCC")) {
			Assert.assertEquals("https://www.fcc.gov/consumers/guides/emergency-communications", drupalPage.getFirstUrl());
		} else if (siteName.equals("HUD")) {
			Assert.assertEquals("https://www.hudexchange.info/programs/cdbg-dr/", drupalPage.getFirstUrl());
		} else if (siteName.equals("EPA")) {
			Assert.assertEquals("https://www.epa.gov/fedfunds", drupalPage.getFirstUrl());
		} else if (siteName.equals("Energy")) {
			Assert.assertEquals("https://www.energy.gov/oe/community-guidelines-energy-emergencies/local-leaders-respond-energy-emergency", drupalPage.getFirstUrl());
		} else if (siteName.equals("CDC")) {
			Assert.assertEquals("https://www.atsdr.cdc.gov/hac/phamanual/ch4.html", drupalPage.getFirstUrl());
		} 
	}

	@Step
	public void viewTagWords(String siteName) {
		if (siteName.equals("Grants")) {
			drupalPage.editGrantsPage();
			Assert.assertEquals(
					("FAQs" + "\n" + "Grants" + "\n" + "Application" + "\n" + "Frequently Asked Grant Questions"),
					drupalPage.viewTagWords());
		} else if (siteName.equals("Fema")) {
			drupalPage.editFemaPage();
			Assert.assertEquals(("Youth" + "\n" + "Kids" + "\n" + "Family" + "\n" + "Preparedness" + "\n" + "Counseling"
					+ "\n" + "Training"), drupalPage.viewTagWords());
		}
	}
	
	@Step
	public void clickQuickSearch(String quickSearch) {
		if (quickSearch.equals("Community Preparedness")) {
			drupalPage.clickCommunityPreparedness();
		} else if (quickSearch.equals("Disaster Recovery Resources")) {
			drupalPage.clickDisasterRecoveryResources();
		} else if (quickSearch.equals("Emergency Shelter and Housing")) {
			drupalPage.clickEmergencyShelterHousing();
		} else if (quickSearch.equals("How Can You Help?")) {
			drupalPage.clickHowCanYouHelp();
		} else if (quickSearch.equals("Infrastructure, Utilities, and Other Public Assistance")) {
			drupalPage.clickInfrastructure();
		}
	}
	
	@Step
	public void quickSearchResults() {
		Assert.assertTrue(drupalPage.communityResults());
	}
	
	@Step 
	public void checkDisasterState() {
		//Assert.assertEquals(daHomepage.checkDACDisasterStateFeed(), daHomepage.checkDisasterStates());
		Assert.assertEquals(daHomepage.checkDisasterStatesEdit(), daHomepage.checkDisasterStates());
	}
	
	@Step 
	public void checkSpanishDisasterState() {
		//Assert.assertEquals(daHomepage.checkDACDisasterStateFeed(), daHomepage.checkDisasterStates());
		Assert.assertEquals(daHomepage.checkSpanishDisasterStatesEdit(), daHomepage.checkDisasterStates());
	}
	
	@Step
	public void checkDisasterCounty() {
		Assert.assertEquals (daHomepage.clickDisasterStates(), daHomepage.clickDisasterStatesEdit());
	} 
	
	@Step
	public void checkSpanishDisasterCounty() {
		Assert.assertEquals (daHomepage.clickDisasterStates(), daHomepage.clickSpanishDisasterStatesEdit());
	}

}