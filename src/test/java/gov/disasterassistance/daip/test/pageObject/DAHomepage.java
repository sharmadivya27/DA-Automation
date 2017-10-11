package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import gov.disasterassistance.daip.test.exceptions.FeedException;
import gov.disasterassistance.daip.test.exceptions.LocalResourcesException;
import gov.disasterassistance.daip.test.exceptions.StateException;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DAHomepage extends PageObject {

	// *************************************************************************
	// FindBy / private variables section

	@FindBy(xpath = "//div[@class[contains(., 'accordion') and not(contains(., 'name'))]]")
	private List<WebElementFacade> accordionBlocks;

	@FindBy(xpath = "//*[@id='pageContent']")
	private WebElementFacade checkStatusPageContent;

	@FindBy(xpath = "//span[contains(., 'Disaster Assistance Center') or contains(.,'Centro de Asistencia por Desastre')]")
	private WebElementFacade dacPage; 

	@FindBy(xpath = "//div[@id='block-daip-responsive-questionnaire-responsive-questionnaire-block']")
	private WebElementFacade questionnaire;

	@FindBy(xpath = "//*//div[@id='address-lookup-container']")
	private WebElementFacade addressLookup;

	@FindBy(id = "benefit-counter-count") 
	private WebElementFacade benefitCounter;

	@FindBy(xpath = "//*[@class='page__title title']")
	private WebElementFacade pageTitle;

	@FindBy(xpath = "//div[@id='landing-page-container']/a")
	private List<WebElementFacade> landingPageNode;

	@FindBy(xpath = "//div//ul//li//a[@class='print-email-search-icon' or @class='print-mail print-email-search-icon']")
	private List<WebElementFacade> quickLinks;

	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[1]/article/a/span")
	private WebElementFacade assistanceMainLink;
	
	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[1]/article/div[2]/div/div/a")
	private WebElementFacade assistanceMobileMainLink;

	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[2]/article/a/span")
	private WebElementFacade applyOnlineMainLink;
	
	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[2]/article/div[2]/div/div/a")
	private WebElementFacade applyOnlineMobileMainLink;
	
	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[3]/article/a/span")
	private WebElementFacade checkStatusMainLink;
	
	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[3]/article/div[2]/div/div/a")
	private WebElementFacade checkStatusMobileMainLink;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
	private WebElementFacade spanishGetAssistanceTab;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/a")
	private WebElementFacade getAssistanceTab;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
	private WebElementFacade spanishAddressLookup;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[1]/a")
	private WebElementFacade addressLookUpMenu;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/a")
	private WebElementFacade getAssistanceMobile;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[1]/a")
	private WebElementFacade addressLookUpMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
	private WebElementFacade spanishFindAssistance;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[2]/a")
	private WebElementFacade findAssistance;

	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[2]/a")
	private WebElementFacade findAssistanceMobile;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[3]/a")
	private WebElementFacade spanishApplyOnline;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[3]/a")
	private WebElementFacade applyOnline;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[3]/a")
	private WebElementFacade applyOnlineMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[4]/a")
	private WebElementFacade spanishCheckStatus;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[4]/a")
	private WebElementFacade checkYourStatus;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[4]/a")
	private WebElementFacade checkYourStatusMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[5]/a")
	private WebElementFacade spanishAssistanceCategory;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[5]/a")
	private WebElementFacade assistanceByCategory;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[5]/a")
	private WebElementFacade assistanceByCategoryMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[6]/a")
	private WebElementFacade spanishAssistanceFederal;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[6]/a")
	private WebElementFacade assistanceByFederalAgency;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[6]/a")
	private WebElementFacade assistanceByFederalAgencyMobile;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[7]/a")
	private WebElementFacade communityLeaders;
	
	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[8]/a")
	private WebElementFacade spanishCommunityLeaders;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[7]/a")
	private WebElementFacade communityLeadersMobile;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[8]/a")
	private WebElementFacade spanishMobileCommunityLeaders;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[7]/a")
	private WebElementFacade spanishOtherHelp;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[8]/a")
	private WebElementFacade otherHelp;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[8]/a")
	private WebElementFacade mobileOtherHelp;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[7]/a")
	private WebElementFacade spanishMobileOtherHelp;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[9]/a")
	private WebElementFacade spanishApplicationChecklist;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[9]/a")
	private WebElementFacade applicationChecklist;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[9]/a")
	private WebElementFacade mobileApplicationChecklist;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[9]/a")
	private WebElementFacade mobileSpanishApplicationChecklist;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[10]/a")
	private WebElementFacade spanishForms;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[10]/a")
	private WebElementFacade forms;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[10]/a")
	private WebElementFacade mobileForms;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-get-assistance']/ul/li[10]/a")
	private WebElementFacade spanishMobileForms;

	@FindBy(xpath = "//*[@id='menu-info']/a")
	private WebElementFacade informationTab;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/a")
	private WebElementFacade informationMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
	private WebElementFacade spanishInfoTab;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[1]/a")
	private WebElementFacade newsFeeds;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[1]/a")
	private WebElementFacade newsFeedsMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
	private WebElementFacade spanishNewsFeeds;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[2]/a")
	private WebElementFacade immediateNeeds;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[2]/a")
	private WebElementFacade immediateNeedsMobile; 

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
	private WebElementFacade spanishImmediateNeeds;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[3]/a")
	private WebElementFacade movingForward;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[3]/a")
	private WebElementFacade movingForwardMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
	private WebElementFacade spanishMovingForward;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[4]/a")
	private WebElementFacade disabilities;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[4]/a")
	private WebElementFacade disabilitiesMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[4]/a")
	private WebElementFacade spanishDisabilities;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[5]/a")
	private WebElementFacade olderAmericans;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[5]/a")
	private WebElementFacade olderAmericansMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[5]/a")
	private WebElementFacade spanishOlderAmericans;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[6]/a")
	private WebElementFacade childrenFamilies;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[6]/a")
	private WebElementFacade childrenFamiliesMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[6]/a")
	private WebElementFacade spanishChildrenFamilies;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[7]/a")
	private WebElementFacade disasterTypes;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[7]/a")
	private WebElementFacade disasterTypesMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[7]/a")
	private WebElementFacade spanishDisasterTypes;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[8]/a")
	private WebElementFacade foreignDisasters;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[8]/a")
	private WebElementFacade foreignDisastersMobile;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[8]/a")
	private WebElementFacade spanishForeignDisasters;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[9]/a")
	private WebElementFacade factSheets;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-info']/ul/li[9]/a")
	private WebElementFacade factSheetsMobile;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[9]/a")
	private WebElementFacade spanishFactSheets;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
	private WebElementFacade spanishAboutUsTab;

	@FindBy(xpath = "//*[@id='menu-about']/a")
	private WebElementFacade aboutUsTab;

	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/a")
	private WebElementFacade aboutUsMobile;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[1]/a")
	private WebElementFacade spanishOverview;

	@FindBy(xpath = "//*[@id='menu-about']/ul/li[1]/a")
	private WebElementFacade overview;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/ul/li[1]/a")
	private WebElementFacade overviewMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[2]/a")
	private WebElementFacade spanishPartners;

	@FindBy(xpath = "//*[@id='menu-about']/ul/li[2]/a")
	private WebElementFacade partners;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/ul/li[2]/a")
	private WebElementFacade partnersMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/a")
	private WebElementFacade spanishHelpTab;

	@FindBy(xpath = "//*[@id='menu-help']/a")
	private WebElementFacade helpTab;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/a")
	private WebElementFacade helpMobile;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[1]/a")
	private WebElementFacade spanishFaqs;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/ul/li[1]/a")
	private WebElementFacade faqsMobile;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[1]/a")
	private WebElementFacade faqs;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[2]/a")
	private WebElementFacade spanishContactUs;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/ul/li[2]/a")
	private WebElementFacade contactUsMobile;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[2]/a")
	private WebElementFacade contactUs;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[3]/a")
	private WebElementFacade spanishPrivacyPolicy;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/ul/li[3]/a")
	private WebElementFacade privacyPolicyMobile;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[3]/a")
	private WebElementFacade privacyPolicy;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[4]/a")
	private WebElementFacade spanishAccessibility;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/ul/li[4]/a")
	private WebElementFacade accessibilityMobile;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[4]/a")
	private WebElementFacade accessibility;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[5]/a")
	private WebElementFacade spanishDownloadPlugIns;
	
	@FindBy(xpath = "//*[@id='sidr-id-menu-help']/ul/li[5]/a")
	private WebElementFacade downloadPlugInsMobile;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[5]/a")
	private WebElementFacade downloadPlugIns;

	@FindBy(xpath = "//*[@class='state selected single-state-group']")
	private List<WebElementFacade> disasterStates;
	
	@FindBy(xpath = "//*[@class='state selected single-state-group']")
	private List<WebElementFacade> disasterStates2;

	@FindBy(xpath = "//*[@class='state']")
	private List<WebElementFacade> greyStates;

	@FindBy(xpath = "//*[@id='svg2']")
	private WebElementFacade disasterMap;

	@FindBy(xpath = "//*[@id='block-twitter-block-1']")
	private WebElementFacade twitterFeedBlock;

	@FindBy(xpath = "//*[@id=\"local-resources-input\"]")
	private WebElementFacade localResourcesTextbox;

	@FindBy(xpath = "//*[@class='location-item clickable']")
	private List<WebElementFacade> localResourcesResults;
	
	@FindBy(xpath = "//*[@id='local-resources-button']")
	private WebElementFacade localResourcesSearch;

	@FindBy(xpath = "//*[@id='email-form-wrapper']")
	private WebElementFacade emailLinkForm;

	@FindBy(xpath = "//*[@id='responsive-menu-button']")
	private WebElementFacade mobileMenu;

	@FindBy(xpath = "/html/body")
	private WebElementFacade stateDAC;

	@FindBy(xpath = "//*[@id='disaster-results-container']")
	private WebElementFacade declaredCounties;
	
	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[2]/article/div[2]/div/div/a")
	private WebElementFacade applyOnlineQuickSearch;

	@FindBy(xpath = "/html/body/pre")
	private WebElementFacade declaredDisasterDAC;
	
	@FindBy(xpath = "//*[@id='address-text-field']")
	private WebElementFacade addressLookUpTextField;
	
	@FindBy(xpath = "//*[@id='disaster-results-table-body']/tr/td[1]/div/a")
	private WebElementFacade disasterName;
	
	@FindBy(xpath = "//*[@id='address-lookup-submit']")
	private WebElementFacade addressLookUpButton;
	
	private List<WebElementFacade> allElements = new ArrayList<WebElementFacade>();

	// *************************************************************************
	// Functions

	/*************************************************************************
	 * Searches through the quick links to find the element with the same name
	 * that was passed. Once it finds the link it will click on the button.
	 * 
	 * @param link
	 *            : Name of the link to be clicked on
	 *************************************************************************/

	public void clickQuickLink(String link) {
		allElements.clear();
		allElements.addAll(quickLinks);
		Iterator<WebElementFacade> iter = allElements.iterator();
		WebElementFacade element = null;
		while (iter.hasNext()) {
			WebElementFacade tempElement = iter.next();
			String tempTitle = tempElement.getText();

			if (tempTitle.toLowerCase().contains(link)) {
				element = tempElement;
				break;
			}
		}
		element.click();
	}

	/*************************************************************************
	 * Checks if all states with disasters are clickable on the disaster map and
	 * if all other states are visible.
	 * 
	 *************************************************************************/
	public void checkStates() throws StateException {
		Iterator<WebElementFacade> disasterStateIter = disasterStates.iterator();
		Iterator<WebElementFacade> greyStateIter = greyStates.iterator();
		while (disasterStateIter.hasNext()) {
			WebElementFacade state = disasterStateIter.next();
			if (!state.isEnabled()) {
				throw new StateException("Unclickable state.");
			}
		}
		while (greyStateIter.hasNext()) {
			WebElementFacade state = greyStateIter.next();
			if (!state.isVisible()) {
				throw new StateException("State not visible.");
			}
		}
	}

	/*************************************************************************
	 * Verifies that the disaster map is visible on the homepage.
	 * 
	 *************************************************************************/
	public void checkDisasterMap() throws StateException {
		this.evaluateJavascript("arguments[0].scrollIntoView(true);", disasterMap);

		if (!disasterMap.isVisible()) {
			throw new StateException("Disaster map not visible");
		}
	}

	/*************************************************************************
	 * Checks that the twitter feed is visible with the most recent tweets.
	 * 
	 *************************************************************************/
	public void checkTwitterFeed() throws FeedException {
		this.evaluateJavascript("window.scrollTo(0,document.body.scrollHeight)");

		int expected = 3;

		// NOTE(Chris):
		// Have to switch iframe to see element could cause other issues (maybe)
		List<WebElement> recentTweets = this.getDriver().switchTo().frame("twitter-widget-0")
				.findElements(By.xpath("//ol[@class='timeline-TweetList']/li"));
		Iterator<WebElement> twiterator = recentTweets.iterator();

		if (recentTweets.size() != expected) {
			throw new FeedException("Expected: <" + expected + ">, actual value: <" + recentTweets.size() + ">");
		}
		while (twiterator.hasNext()) {
			if (!twiterator.next().isDisplayed()) {
				throw new FeedException("Twitter feed not visible");
			}
		}
	}

	/*************************************************************************
	 * Verifies that the FEMA twitter feed is visible on the homepage.
	 * 
	 *************************************************************************/
	public void checkTwitterFeedBlock() throws FeedException {
		if (!twitterFeedBlock.isVisible()) {
			throw new FeedException("Twitter feed not visible");
		}
	}

	/*************************************************************************
	 * Verifies that local resources results are visible and appear on the
	 * homepage.
	 * 
	 *************************************************************************/
	public void verifyLocalResourcesResults() throws LocalResourcesException {
		Iterator<WebElementFacade> localResourcesIter = localResourcesResults.iterator();
		while (localResourcesIter.hasNext()) {
			WebElementFacade resource = localResourcesIter.next();
			if (!resource.isVisible()) {
				throw new LocalResourcesException("Local resource not visible");
			}
		}
	}
	
	/*************************************************************************
	 * Checks the currently declared disasters in prod.  
	 * 
	*************************************************************************/
	String state; 

	public String checkDisasterStates() {   
		for (int i = 0; i < disasterStates.size(); i++) {
			state += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return state;
	}
	
	/*************************************************************************
	 * Checks the currently declared disasters in edit.  
	 * 
	*************************************************************************/
	String editState; 
	
	public String checkDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/");
		for (int i = 0; i < disasterStates.size(); i++) {
			editState += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return editState;
	}
	
	/*************************************************************************
	 * Checks the currently declared disasters in edit in Spanish.  
	 * 
	*************************************************************************/
	public String checkSpanishDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/es");
		for (int i = 0; i < disasterStates.size(); i++) {
			editState += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return editState;
	}
 
	
	/*************************************************************************
	 * Finds the second declared disaster state on the DAC feed. 
	 * 
	*************************************************************************/
	public String getDeclaredDisasterState() {
		String declaredStates =  declaredDisasterDAC.getText();
		String[] states = declaredStates.split(",");
		state = states[1].replaceAll("\"", "");
		this.openAt("https://www.disasterassistance.gov/drupal_api/declaredCounties/" + state);
		return state;
	}
	
	/*************************************************************************
	 * Finds the second declared disaster county on the DAC feed. 
	 * 
	*************************************************************************/
	public String getDeclaredDisasterCounty() {
		String declaredCounties = declaredDisasterDAC.getText();
		String[] counties = declaredCounties.split(",");
		return counties[1].replaceAll("\"", "");
	}
	
	/*************************************************************************
	 * Types the declared disaster state and county into the Address Look-up
	 * search field. 
	 * 
	*************************************************************************/
	public void typeAddressLookUp() {
		String state = getDeclaredDisasterState();
		String county = getDeclaredDisasterCounty();
		this.openAt("https://www.disasterassistance.gov/");
		addressLookUpTextField.click();
		addressLookUpTextField.type(county + "," + state);
		addressLookUpButton.click();
		pause(4000);
	}
	
	/*************************************************************************
	 * Types the declared disaster state and county into the Spanish Address 
	 * Look-up search field. 
	 * 
	*************************************************************************/
	public void typeSpanishAddressLookUp() {
		String state = getDeclaredDisasterState();
		String county = getDeclaredDisasterCounty();
		this.openAt("https://www.disasterassistance.gov/es");
		addressLookUpTextField.click();
		addressLookUpTextField.type(county + "," + state);
		addressLookUpButton.click();
		pause(4000);
	}
	
	/*************************************************************************
	 * Checks if the state and county typed has a current disaster. 
	 * 
	*************************************************************************/
	public boolean disasterAppears() {
		return disasterName.isDisplayed();
	}

	public void clickAssistanceMainLink() {
		assistanceMainLink.click();
	}
	
	public void clickMobileAssistanceMainLink() {
		assistanceMobileMainLink.click();
	}

	public void clickApplyOnlineMainLink() {
		applyOnlineMainLink.click();
	}
	
	public void clickMobileApplyOnlineMainLink() {
		applyOnlineMobileMainLink.click();
	} 

	public void clickCheckStatusMainLink() {
		checkStatusMainLink.click();
	}
	
	public void clickMobileCheckStatusMainLink() {
		checkStatusMobileMainLink.click();
	}

	public void clickMobileMenu() {
		mobileMenu.click();
	}

	public void clickApplyOnlineQuickSearch() {
		applyOnlineQuickSearch.click();
	}
	
	public void mouseOverGetAssistanceTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(getAssistanceTab).perform();
	}

	public void mouseOverSpanishGetAssistanceTab() { 
		Actions action = new Actions(getDriver());
		action.moveToElement(spanishGetAssistanceTab).perform();
	}

	public void mouseOverInfoTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(informationTab).perform();
	}

	public void mouseOverSpanishInfoTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(spanishInfoTab).perform();
	}

	public void mouseOverAboutTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(aboutUsTab).perform();
	}

	public void mouseOverSpanishAboutTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(spanishAboutUsTab).perform();
	}
	
	public void mouseOverHelpTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(helpTab).perform();
	}

	public void mouseOverSpanishHelpTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(spanishHelpTab).perform();
	}

	public void clickAddressLookUp() {
		mouseOverGetAssistanceTab();
		addressLookUpMenu.click();
	}
	
	public void clickMobileAddressLookUp() {
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		pause(4000);
		addressLookUpMobile.click();
	}

	public void clickSpanishAddressLookUp() {
		mouseOverSpanishGetAssistanceTab();
		spanishAddressLookup.click();
	}

	public void clickFindAssistance() {
		mouseOverGetAssistanceTab();
		findAssistance.click();
	}
	
	public void clickMobileFindAssistance() {
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		pause(4000);
		findAssistanceMobile.click();
	}

	public void clickSpanishFindAssistance() {
		mouseOverSpanishGetAssistanceTab();
		spanishFindAssistance.click();
	}

	public void clickApplyOnline() {
		mouseOverGetAssistanceTab();
		applyOnline.click();
	}

	public void clickMobileApplyOnline() {
		//FIXME
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		pause(4000);
		applyOnlineMobile.click();
	}

	public void clickSpanishApplyOnline() {
		mouseOverSpanishGetAssistanceTab();
		spanishApplyOnline.click();
	}

	public void clickCheckYourStatus() {
		mouseOverGetAssistanceTab();
		checkYourStatus.click();
	}
	
	public void clickMobileCheckYourStatus() {
		//FIXME
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		checkYourStatusMobile.click();
	}

	public void clickSpanishCheckStatus() { 
		mouseOverSpanishGetAssistanceTab();
		spanishCheckStatus.click();
	}

	public void clickAssistanceCategory() {
		mouseOverGetAssistanceTab();
		assistanceByCategory.click();
	}
	
	public void clickMobileAssistanceCategory() {
		pause(2000);
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		assistanceByCategoryMobile.click();
	}

	public void clickSpanishAssistanceCategory() {
		mouseOverSpanishGetAssistanceTab();
		spanishAssistanceCategory.click();
	}

	public void clickAssistanceFederal() {
		mouseOverGetAssistanceTab();
		assistanceByFederalAgency.click();
	}
	
	public void clickMobileAssistanceFederal() {
		pause(3000);
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		assistanceByFederalAgencyMobile.click();
		pause(3000);
	}

	public void clickSpanishAssistanceFederal() {
		mouseOverSpanishGetAssistanceTab();
		spanishAssistanceFederal.click();
	}

	public void clickCommLeaders() {
		mouseOverGetAssistanceTab();
		communityLeaders.click();
	}
	
	public void clickSpanishCommLeaders() {
		mouseOverGetAssistanceTab();
		spanishCommunityLeaders.click();
	}
	
	public void clickMobileCommLeaders() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		communityLeadersMobile.click();
	}
	
	public void clickSpanishMobileCommLeaders() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		spanishMobileCommunityLeaders.click();
	}

	public void clickOtherHelp() {
		mouseOverGetAssistanceTab();
		otherHelp.click();
	}
	
	public void clickMobileOtherHelp() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		mobileOtherHelp.click();
	}

	
	public void clickMobileSpanishOtherHelp() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		spanishMobileOtherHelp.click();
	}
	
	public void clickSpanishOtherHelp() {
		mouseOverSpanishGetAssistanceTab();
		spanishOtherHelp.click();
	}

	public void clickApplicationChecklist() {
		mouseOverGetAssistanceTab();
		applicationChecklist.click();
	}
	
	public void clickMobileApplicationChecklist() {
		clickMobileMenu();
		pause(3000);
		getAssistanceMobile.click();
		pause(4000);
		mobileApplicationChecklist.click();
	}
	
	public void clickSpanishMobileApplicationChecklist() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		mobileSpanishApplicationChecklist.click();
	}

	public void clickSpanishApplicationChecklist() {
		mouseOverSpanishGetAssistanceTab();
		spanishApplicationChecklist.click();
	}

	public void clickForms() {
		mouseOverGetAssistanceTab();
		forms.click();
	}
	
	public void clickMobileForms() {
		clickMobileMenu();
		pause(4000);
		getAssistanceMobile.click();
		pause(4000);
		mobileForms.click();
	}

	public void clickSpanishForms() {
		getDriver().manage().window().maximize(); 
		mouseOverSpanishGetAssistanceTab();
		spanishForms.click();
	}

	public void clickNewsFeeds() {
		mouseOverInfoTab();
		newsFeeds.click();
	}
	
	public void clickMobileNewsFeeds() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		newsFeedsMobile.click();
	}

	public void clickSpanishNewsFeeds() {
		mouseOverSpanishInfoTab();
		spanishNewsFeeds.click();
	}

	public void clickImmediateNeeds() {
		mouseOverInfoTab();
		immediateNeeds.click();
	}
	
	public void clickMobileImmediateNeeds() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		immediateNeedsMobile.click();
	}

	public void clickSpanishImmediateNeeds() {
		mouseOverSpanishInfoTab();
		spanishImmediateNeeds.click();
	}

	public void clickMovingForward() {
		mouseOverInfoTab();
		movingForward.click();
	}
	
	public void clickMobileMovingForward() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		movingForwardMobile.click();
	}

	public void clickSpanishMovingForward() {
		mouseOverSpanishInfoTab();
		spanishMovingForward.click();
	}

	public void clickDisabilities() {
		mouseOverInfoTab();
		disabilities.click();
	}
	
	public void clickMobileDisabilities() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		disabilitiesMobile.click();
	}

	public void clickSpanishDisabilities() {
		mouseOverSpanishInfoTab();
		spanishDisabilities.click();
	}

	public void clickOlderAmericans() {
		mouseOverInfoTab();
		olderAmericans.click();
	}
	
	public void clickMobileOlderAmericans() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		olderAmericansMobile.click();
	}

	public void clickSpanishOlderAmericans() {
		mouseOverSpanishInfoTab();
		spanishOlderAmericans.click();
	}

	public void clickChildrenAndFamilies() {
		mouseOverInfoTab();
		childrenFamilies.click();
	}
	
	public void clickMobileChildrenAndFamilies() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		childrenFamiliesMobile.click();
	}

	public void clickSpanishChildrenAndFamilies() {
		mouseOverSpanishInfoTab();
		spanishChildrenFamilies.click();
	}

	public void clickDisasterTypes() {
		mouseOverInfoTab();
		disasterTypes.click();
	}
	
	public void clickMobileDisasterTypes() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		disasterTypesMobile.click();
	}

	public void clickSpanishDisasterTypes() {
		mouseOverSpanishInfoTab();
		spanishDisasterTypes.click();
	}

	public void clickForeignDisasters() {
		mouseOverInfoTab();
		foreignDisasters.click();
	}
	
	public void clickMobileForeignDisasters() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		foreignDisastersMobile.click();
	}

	public void clickSpanishForeignDisasters() {
		mouseOverSpanishInfoTab();
		spanishForeignDisasters.click();
	}

	public void clickFactSheets() {
		mouseOverInfoTab();
		factSheets.click();
	}
	
	public void clickMobileFactSheets() {
		clickMobileMenu();
		pause(3000);
		informationMobile.click();
		factSheetsMobile.click();
	}

	public void clickSpanishFactSheets() {
		mouseOverSpanishInfoTab();
		spanishFactSheets.click();
	}

	public void clickOverview() {
		mouseOverAboutTab();
		overview.click();
	}
	
	public void clickMobileOverview() {
		clickMobileMenu();
		pause(3000);
		aboutUsMobile.click();
		overviewMobile.click();
	}

	public void clickSpanishOverview() {
		mouseOverSpanishAboutTab();
		spanishOverview.click();
	}

	public void clickPartners() {
		mouseOverAboutTab();
		partners.click();
	}
	
	public void clickMobilePartners() {
		clickMobileMenu();
		pause(3000);
		aboutUsMobile.click();
		this.evaluateJavascript("window.scrollBy(0,50)", "");
		partnersMobile.click();
	}

	public void clickSpanishPartners() {
		mouseOverSpanishAboutTab();
		spanishPartners.click();
	}

	public void clickFaqs() {
		mouseOverHelpTab();
		faqs.click();
	}
	
	public void clickMobileFaqs() {
		clickMobileMenu();
		pause(3000);
		helpMobile.click();
		faqsMobile.click();
	} 

	public void clickSpanishFaqs() {
		mouseOverSpanishHelpTab();
		spanishFaqs.click();
	}

	public void clickContactUs() {
		mouseOverHelpTab();
		contactUs.click();
	}
	
	public void clickMobileContactUs() {
		clickMobileMenu();
		pause(3000);
		helpMobile.click();
		contactUsMobile.click();
	}

	public void clickSpanishContactUs() {
		mouseOverSpanishHelpTab();
		spanishContactUs.click();
	}

	public void clickPrivacyPolicy() {
		mouseOverHelpTab();
		privacyPolicy.click();
	}  
	
	public void clickMobilePrivacyPolicy() {  
		clickMobileMenu();
		pause(3000);
		helpMobile.click();
		privacyPolicyMobile.click();
	}

	public void clickSpanishPrivacyPolicy() {
		mouseOverSpanishHelpTab();
		spanishPrivacyPolicy.click();
	}

	public void clickAccessibility() {
		mouseOverHelpTab();
		accessibility.click();
	}
	
	public void clickMobileAccessibility() {
		clickMobileMenu();  
		pause(3000);
		helpMobile.click();
		accessibilityMobile.click(); 
	}

	public void clickSpanishAccessibility() {
		mouseOverSpanishHelpTab();
		spanishAccessibility.click();
	}

	public void clickDownload() {
		mouseOverHelpTab();
		downloadPlugIns.click();
	}
	
	public void clickMobileDownload() {
		clickMobileMenu();
		pause(3000);
		helpMobile.click();
		downloadPlugInsMobile.click();
	}

	public void clickSpanishDownload() {
		mouseOverSpanishHelpTab();
		spanishDownloadPlugIns.click();
	}

	public int numberOfLandingPageNodes() {
		return landingPageNode.size();
	}

	public String pullPageTitle() {
		return pageTitle.getText();
	}

	public boolean addressLookupIsDisplayed() {
		return addressLookup.isDisplayed();
	}

	public boolean questionnaireIsDisplayed() {
		return questionnaire.isDisplayed();
	}

	public boolean checkStatusPageIsDisplayed() {
		return checkStatusPageContent.isDisplayed();
	}

	public boolean dacPageIsDisplayed() {
		return dacPage.isDisplayed();
	}

	public boolean emailFormIsDisplayed() {
		return emailLinkForm.isDisplayed();
	}

	public int getNumberAccordions() {
		return accordionBlocks.size();
	}

	public int getResultsVal() {
		int i = Integer.parseInt(benefitCounter.getText());
		return i;
	}

	public List<WebElement> getFOAFooter() {
		return this.getDriver()
				.findElements(By.xpath("//*[@class[contains(., 'qButton') and not(contains(., 'session'))]]"));
	}

	public void clickBackFOA() {
		List<WebElement> footer = getFOAFooter();
		footer.get(0).click();
	}

	public void lookUpLocation() {
		pause(4000);
		localResourcesTextbox.sendKeys("New York, NY");
		localResourcesSearch.click();
	}
	
	public void pause(long time) {
		try { 
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
}