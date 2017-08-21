package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DALandingPage extends PageObject {

	@FindBy(xpath = "//div[@id='landing-page-container']/a")
	private List<WebElementFacade> landingPageNode;

	@FindBy(xpath = "//nav[@id='nav']/ul/li[@class[contains(., 'menu__item')]]")
	private List<WebElementFacade> navParentNode;

	@FindBy(xpath = "//*[@id='U.S. Department of Homeland Security || U.S. Department of Homeland Security']")
	private WebElementFacade evacuateLink;

	@FindBy(xpath = "//*[@id='Other Federal || Other Federal']")
	private WebElementFacade shelterLink;

	@FindBy(xpath = "//*[@id='U.S. Department of Homeland Security || U.S. Department of Homeland Security']")
	private WebElementFacade lostFamilyLink;

	@FindBy(xpath = "//*[@id='U.S. Department of Homeland Security || U.S. Department of Homeland Security']")
	private WebElementFacade findingPetsLink;

	@FindBy(xpath = "//*[@id='U.S. Department of Health and Human Services || U.S. Department of Health and Human Services']")
	private WebElementFacade safePlaceLink;

	@FindBy(xpath = "//*[@id='more-less-text']")
	private WebElementFacade moreButton;

	@FindBy(xpath = "//*[@id='more-less-content']")
	private WebElementFacade moreContent;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-8']/h2")
	private WebElementFacade recentlyDeclaredDisasters;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-19']/h2")
	private WebElementFacade severeStorms;

	@FindBy(xpath = "//*[@id'block-aggregator-feed-23']/h2")
	private WebElementFacade wildfire;

	@FindBy(xpath = "//*[@id='hurricanes']/h2")
	private WebElementFacade hurricanes;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-6']/h2")
	private WebElementFacade earthquakes;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-4']/h2")
	private WebElementFacade drought;

	private List<WebElementFacade> allElements = new ArrayList<WebElementFacade>();

	// *************************************************************************
	// Functions

	/*************************************************************************
	 * Searches through the main menu nodes and current landing page nodes to
	 * find the element with the same name that was passed. Once it finds the
	 * node it will click on the button.
	 * 
	 * @param node
	 *            : Name of the node to be clicked on
	 *************************************************************************/
	public void clickNavNode(String node) {
		allElements.clear();
		allElements.addAll(landingPageNode);
		allElements.addAll(navParentNode);

		Iterator<WebElementFacade> iter = allElements.iterator(); 
		WebElementFacade element = null;
		while (iter.hasNext()) {
			WebElementFacade tempElement = iter.next();
			String tempTitle = tempElement.getText();

			if (tempTitle.toLowerCase().contains(node)) {
				element = tempElement;
				break;
			}
		}

		element.click();
	}

	public void clickEvacuate() {
		evacuateLink.click();
	}

	public void clickShelterInPlace() {
		shelterLink.click();
	}

	public void clickFindingLostFamily() {
		lostFamilyLink.click();
	}

	public void clickFindingPets() {
		findingPetsLink.click();
	}

	public void clickFindSafePlace() {
		safePlaceLink.click();
	}

	public String getUrl() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(browserTabs.get(1));
		String url = getDriver().getCurrentUrl();
		// getDriver().switchTo().window(browserTabs.get(0));
		return url;
	}

	public boolean urlOpened() {
		return getUrl().contains("www") || getUrl().contains(".gov") || getUrl().contains(".edu")
				|| getUrl().contains(".html") || getUrl().contains(".org");
	}
	
	public boolean getApplyOnlineUrl() {
		return getDriver().getCurrentUrl().contains("mobileBrowser=True");
		//staging takes "mobile=True" ??
	}

	public void clickMore() {
		moreButton.click();
	}

	public String moreContentText() {
		return moreContent.getText();
	}
 
	public boolean contentDisplayed() {
		return moreContentText().contains("Emergency") || moreContentText().contains("Your")
				|| moreContentText().contains("Resources") || moreContentText().contains("Flood")
				|| moreContentText().contains("Emergencia") || moreContentText().contains("Su")
				|| moreContentText().contains("Recursos") || moreContentText().contains("Incendios");
	}

	public String disasterTitle() {
		return recentlyDeclaredDisasters.getText();
	}

	public String stormTitle() {
		return severeStorms.getText();
	}
 
	public String wildfireTitle() {
		return wildfire.getText();
	}

	public String hurricaneTitle() {
		return hurricanes.getText();
	}

	public String earthquakesTitle() {
		return earthquakes.getText();
	}

	public String droughtTitle() {
		return drought.getText();
	}
}