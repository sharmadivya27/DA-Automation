package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;

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

	@FindBy(xpath = "//div[@class='block block-nodeblock homepage-main-links even']//article")
	private List<WebElementFacade> mainLinks;

	@FindBy(xpath = "//*[@class='state selected single-state-group']")
	private List<WebElementFacade> disasterStates;

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
	 * Searches through the main links to find the element with the same name
	 * that was passed. Once it finds the link it will click on the button.
	 * 
	 * @param link
	 *            : Name of the link to be clicked on
	 *************************************************************************/

	public void clickMainLink(String link) {
		allElements.clear();
		allElements.addAll(mainLinks);

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

	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}