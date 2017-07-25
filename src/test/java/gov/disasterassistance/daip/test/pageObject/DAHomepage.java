package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[2]/article/a/span")
	private WebElementFacade applyOnlineMainLink;

	@FindBy(xpath = "//*[@id='block-nodeblock-14948']/div[2]/div[2]/div/div[3]/article/a/span")
	private WebElementFacade checkStatusMainLink;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
	private WebElementFacade spanishGetAssistanceTab;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/a")
	private WebElementFacade getAssistanceTab;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
	private WebElementFacade spanishAddressLookup;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[1]/a")
	private WebElementFacade addressLookUpMenu;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
	private WebElementFacade spanishFindAssistance;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[2]/a")
	private WebElementFacade findAssistance;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[3]/a")
	private WebElementFacade spanishApplyOnline;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[3]/a")
	private WebElementFacade applyOnline;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[4]/a")
	private WebElementFacade spanishCheckStatus;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[4]/a")
	private WebElementFacade checkYourStatus;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[5]/a")
	private WebElementFacade spanishAssistanceCategory;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[5]/a")
	private WebElementFacade assistanceByCategory;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[6]/a")
	private WebElementFacade spanishAssistanceFederal;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[6]/a")
	private WebElementFacade assistanceByFederalAgency;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[7]/a")
	private WebElementFacade communityLeaders;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[7]/a")
	private WebElementFacade spanishOtherHelp;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[8]/a")
	private WebElementFacade otherHelp;

	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[8]/a")
	private WebElementFacade spanishApplicationChecklist;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[9]/a")
	private WebElementFacade applicationChecklist;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[9]/a")
	private WebElementFacade spanishForms;

	@FindBy(xpath = "//*[@id='menu-get-assistance']/ul/li[10]/a")
	private WebElementFacade forms;

	@FindBy(xpath = "//*[@id='menu-info']/a")
	private WebElementFacade informationTab;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
	private WebElementFacade spanishInfoTab;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[1]/a")
	private WebElementFacade newsFeeds;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
	private WebElementFacade spanishNewsFeeds;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[2]/a")
	private WebElementFacade immediateNeeds;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
	private WebElementFacade spanishImmediateNeeds;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[3]/a")
	private WebElementFacade movingForward;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
	private WebElementFacade spanishMovingForward;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[4]/a")
	private WebElementFacade disabilities;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[4]/a")
	private WebElementFacade spanishDisabilities;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[5]/a")
	private WebElementFacade olderAmericans;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[5]/a")
	private WebElementFacade spanishOlderAmericans;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[6]/a")
	private WebElementFacade childrenFamilies;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[6]/a")
	private WebElementFacade spanishChildrenFamilies;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[7]/a")
	private WebElementFacade disasterTypes;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[7]/a")
	private WebElementFacade spanishDisasterTypes;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[8]/a")
	private WebElementFacade foreignDisasters;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[8]/a")
	private WebElementFacade spanishForeignDisasters;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[9]/a")
	private WebElementFacade factSheets;

	@FindBy(xpath = "//*[@id='menu-info']/ul/li[9]/a")
	private WebElementFacade spanishFactSheets;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
	private WebElementFacade spanishAboutUsTab;

	@FindBy(xpath = "//*[@id='menu-about']/a")
	private WebElementFacade aboutUsTab;

	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/a")
	private WebElementFacade mobileAboutUs;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[1]/a")
	private WebElementFacade spanishOverview;

	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/ul/li[1]/a")
	private WebElementFacade mobileOverview;

	@FindBy(xpath = "//*[@id='menu-about']/ul/li[1]/a")
	private WebElementFacade overview;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[2]/a")
	private WebElementFacade spanishPartners;

	@FindBy(xpath = "//*[@id='sidr-id-menu-about']/ul/li[2]/a")
	private WebElementFacade mobilePartners;

	@FindBy(xpath = "//*[@id='menu-about']/ul/li[2]/a")
	private WebElementFacade partners;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/a")
	private WebElementFacade spanishHelpTab;

	@FindBy(xpath = "//*[@id='menu-help']/a")
	private WebElementFacade helpTab;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[1]/a")
	private WebElementFacade spanishFaqs;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[1]/a")
	private WebElementFacade faqs;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[2]/a")
	private WebElementFacade spanishContactUs;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[2]/a")
	private WebElementFacade contactUs;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[3]/a")
	private WebElementFacade spanishPrivacyPolicy;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[3]/a")
	private WebElementFacade privacyPolicy;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[4]/a")
	private WebElementFacade spanishAccessibility;

	@FindBy(xpath = "//*[@id='menu-help']/ul/li[4]/a")
	private WebElementFacade accessibility;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[5]/a")
	private WebElementFacade spanishDownloadPlugIns;

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

	@FindBy(xpath = "//*[@id='email-form-wrapper']")
	private WebElementFacade emailLinkForm;

	// @FindBy(xpath = "//*[@id='mobile-header']")
	// or @id='sidr-main'
	@FindBy(xpath = "//*[@id='responsive-menu-button']")
	private WebElementFacade mobileMenu;

	@FindBy(xpath = "/html/body")
	private WebElementFacade stateDAC;

	@FindBy(xpath = "//*[@id='disaster-results-container']")
	private WebElementFacade declaredCounties;

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

	public void clickAssistanceMainLink() {
		assistanceMainLink.click();
	}

	public void clickApplyOnlineMainLink() {
		applyOnlineMainLink.click();
	}

	public void clickCheckStatusMainLink() {
		checkStatusMainLink.click();
	}

	public void clickMobileMenu() {
		// JavascriptExecutor js = (JavascriptExecutor)getDriver();
		// js.executeScript("arguments[0].click();", mobileMenu);
		mobileMenu.click();
	}

	public void mouseOverGetAssistanceTab() {
		Actions action = new Actions(getDriver());
		action.moveToElement(getAssistanceTab).perform();
		/*
		 * // MouseOver function for Safari String mouseOverScript =
		 * "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}"
		 * ; JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript(mouseOverScript, getAssistanceTab);
		 */
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

	public void clickMobileAboutUs() {
		this.evaluateJavascript("arguments[0].scrollIntoView(true);", mobileAboutUs);
		mobileAboutUs.click();
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

	public void clickSpanishAddressLookUp() {
		mouseOverSpanishGetAssistanceTab();
		spanishAddressLookup.click();
	}

	public void clickFindAssistance() {
		mouseOverGetAssistanceTab();
		findAssistance.click();
	}

	public void clickSpanishFindAssistance() {
		mouseOverSpanishGetAssistanceTab();
		spanishFindAssistance.click();
	}

	public void clickApplyOnline() {
		mouseOverGetAssistanceTab();
		applyOnline.click();
	}

	public void clickSpanishApplyOnline() {
		mouseOverSpanishGetAssistanceTab();
		spanishApplyOnline.click();
	}

	public void clickCheckYourStatus() {
		mouseOverGetAssistanceTab();
		checkYourStatus.click();
	}

	public void clickSpanishCheckStatus() {
		mouseOverSpanishGetAssistanceTab();
		spanishCheckStatus.click();
	}

	public void clickAssistanceCategory() {
		mouseOverGetAssistanceTab();
		assistanceByCategory.click();
	}

	public void clickSpanishAssistanceCategory() {
		mouseOverSpanishGetAssistanceTab();
		spanishAssistanceCategory.click();
	}

	public void clickAssistanceFederal() {
		mouseOverGetAssistanceTab();
		assistanceByFederalAgency.click();
	}

	public void clickSpanishAssistanceFederal() {
		mouseOverSpanishGetAssistanceTab();
		spanishAssistanceFederal.click();
	}

	public void clickCommLeaders() {
		mouseOverGetAssistanceTab();
		communityLeaders.click();
	}

	public void clickOtherHelp() {
		mouseOverGetAssistanceTab();
		otherHelp.click();
	}

	public void clickSpanishOtherHelp() {
		mouseOverSpanishGetAssistanceTab();
		spanishOtherHelp.click();
	}

	public void clickApplicationChecklist() {
		mouseOverGetAssistanceTab();
		applicationChecklist.click();
	}

	public void clickSpanishApplicationChecklist() {
		mouseOverSpanishGetAssistanceTab();
		spanishApplicationChecklist.click();
	}

	public void clickForms() {
		mouseOverGetAssistanceTab();
		forms.click();
	}

	public void clickSpanishForms() {
		mouseOverSpanishGetAssistanceTab();
		spanishForms.click();
	}

	public void clickNewsFeeds() {
		mouseOverInfoTab();
		newsFeeds.click();
	}

	public void clickSpanishNewsFeeds() {
		mouseOverSpanishInfoTab();
		spanishNewsFeeds.click();
	}

	public void clickImmediateNeeds() {
		mouseOverInfoTab();
		immediateNeeds.click();
	}

	public void clickSpanishImmediateNeeds() {
		mouseOverSpanishInfoTab();
		spanishImmediateNeeds.click();
	}

	public void clickMovingForward() {
		mouseOverInfoTab();
		movingForward.click();
	}

	public void clickSpanishMovingForward() {
		mouseOverSpanishInfoTab();
		spanishMovingForward.click();
	}

	public void clickDisabilities() {
		mouseOverInfoTab();
		disabilities.click();
	}

	public void clickSpanishDisabilities() {
		mouseOverSpanishInfoTab();
		spanishDisabilities.click();
	}

	public void clickOlderAmericans() {
		mouseOverInfoTab();
		olderAmericans.click();
	}

	public void clickSpanishOlderAmericans() {
		mouseOverSpanishInfoTab();
		spanishOlderAmericans.click();
	}

	public void clickChildrenAndFamilies() {
		mouseOverInfoTab();
		childrenFamilies.click();
	}

	public void clickSpanishChildrenAndFamilies() {
		mouseOverSpanishInfoTab();
		spanishChildrenFamilies.click();
	}

	public void clickDisasterTypes() {
		mouseOverInfoTab();
		disasterTypes.click();
	}

	public void clickSpanishDisasterTypes() {
		mouseOverSpanishInfoTab();
		spanishDisasterTypes.click();
	}

	public void clickForeignDisasters() {
		mouseOverInfoTab();
		foreignDisasters.click();
	}

	public void clickSpanishForeignDisasters() {
		mouseOverSpanishInfoTab();
		spanishForeignDisasters.click();
	}

	public void clickFactSheets() {
		mouseOverInfoTab();
		factSheets.click();
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
		clickMobileAboutUs();
		mobileOverview.click();
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
		clickMobileAboutUs();
		mobilePartners.click();
	}

	public void clickSpanishPartners() {
		mouseOverSpanishAboutTab();
		spanishPartners.click();
	}

	public void clickFaqs() {
		mouseOverHelpTab();
		faqs.click();
	}

	public void clickSpanishFaqs() {
		mouseOverSpanishHelpTab();
		spanishFaqs.click();
	}

	public void clickContactUs() {
		mouseOverHelpTab();
		contactUs.click();
	}

	public void clickSpanishContactUs() {
		mouseOverSpanishHelpTab();
		spanishContactUs.click();
	}

	public void clickPrivacyPolicy() {
		mouseOverHelpTab();
		privacyPolicy.click();
	}

	public void clickSpanishPrivacyPolicy() {
		mouseOverSpanishHelpTab();
		spanishPrivacyPolicy.click();
	}

	public void clickAccessibility() {
		mouseOverHelpTab();
		accessibility.click();
	}

	public void clickSpanishAccessibility() {
		mouseOverSpanishHelpTab();
		spanishAccessibility.click();
	}

	public void clickDownload() {
		mouseOverHelpTab();
		downloadPlugIns.click();
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
		localResourcesTextbox.sendKeys("New York, NY");
	}
   
	String state; 

	public String checkDisasterStates() {   
		for (int i = 0; i < disasterStates.size(); i++) {
			state += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return state;
	}
	
 
	public void checkDACDisasterStateFeed() {
		/*getDriver().get("https://www.disasterassistance.gov/drupal_api/declaredStates");
		String states = stateDAC.getText().replaceAll("\"", "").replaceAll("[ ]", "");
		getDriver().get("https://www.disasterassistance.gov/");
		return states;*/ 
		Map<String, String> states = new HashMap<String, String>();
		states.put("Alabama","AL");
		states.put("Alaska","AK");
		states.put("Alberta","AB");
		states.put("American Samoa","AS");
		states.put("Arizona","AZ");
		states.put("Arkansas","AR");
		states.put("California","CA");
		states.put("Colorado","CO");
		states.put("Connecticut","CT");
		states.put("Delaware","DE");
		states.put("District Of Columbia","DC");
		states.put("Florida","FL");
		states.put("Georgia","GA");
		states.put("Guam","GU");
		states.put("Hawaii","HI");
		states.put("Idaho","ID");
		states.put("Illinois","IL");
		states.put("Indiana","IN");
		states.put("Iowa","IA");
		states.put("Kansas","KS");
		states.put("Kentucky","KY");
		states.put("Louisiana","LA");
		states.put("Maine","ME");
		states.put("Manitoba","MB");
		states.put("Maryland","MD");
		states.put("Massachusetts","MA");
		states.put("Michigan","MI");
		states.put("Minnesota","MN");
		states.put("Mississippi","MS");
		states.put("Missouri","MO");
		states.put("Montana","MT");
		states.put("Nebraska","NE");
		states.put("Nevada","NV");
		states.put("New Hampshire","NH");
		states.put("New Jersey","NJ");
		states.put("New Mexico","NM");
		states.put("New York","NY");
		states.put("North Carolina","NC");
		states.put("North Dakota","ND");
		states.put("Ohio","OH");
		states.put("Oklahoma","OK");
		states.put("Oregon","OR");
		states.put("Pennsylvania","PA");
		states.put("Puerto Rico","PR");
		states.put("Rhode Island","RI");
		states.put("South Carolina","SC");
		states.put("South Dakota","SD");
		states.put("Tennessee","TN");
		states.put("Texas","TX");
		states.put("Utah","UT");
		states.put("Vermont","VT");
		states.put("Virgin Islands","VI");
		states.put("Virginia","VA");
		states.put("Washington","WA");
		states.put("West Virginia","WV");
		states.put("Wisconsin","WI");
		states.put("Wyoming","WY");
	}
	
	String editState; 
	
	public String checkDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/");
		for (int i = 0; i < disasterStates.size(); i++) {
			editState += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return editState;
	}
	
	public String checkSpanishDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/es");
		for (int i = 0; i < disasterStates.size(); i++) {
			editState += disasterStates.get(i).getText().replaceAll("to see if your county is in a declared area", "")
					.replaceAll("Select", "");
		}
		return editState;
	}
 
	String counties;
	
	public String clickDisasterStates() {
		for (int i = 0; i < disasterStates.size(); i++) {
			disasterStates.get(i).click();
			counties += declaredCounties.getText();
		}
		return counties;
	}

	/*public String checkDACCountiesFeed() {
		getDriver().get("https://www.disasterassistance.gov/drupal_api/declaredCounties/AR");
		String counties = stateDAC.getText();
		getDriver().get("https://www.disasterassistance.gov/");
		return counties;
	} */
 
	String countiesEdit;
	
	public String clickDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/");
		for (int i = 0; i < disasterStates2.size(); i++) {
			disasterStates2.get(i).click();
			countiesEdit += declaredCounties.getText();
		}
		return countiesEdit;
	}
	
	public String clickSpanishDisasterStatesEdit() {
		getDriver().get("https://edit.disasterassistance.gov/es");
		for (int i = 0; i < disasterStates2.size(); i++) {
			disasterStates2.get(i).click();
			countiesEdit += declaredCounties.getText();
		}
		return countiesEdit; 
	}
	
	public void pause(long time) {
		try { 
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}