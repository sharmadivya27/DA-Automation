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

	@FindBy(xpath = "//*[@id='block-aggregator-feed-8']/h2")
	private WebElementFacade recentlyDeclared;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-19']/div/ul/li[1]/a")
	private WebElementFacade severeStormLink;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-8']/div/ul/li[1]/a")
	private WebElementFacade disasterLink;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-14']/div/ul/li/a")
	private WebElementFacade hurricaneLink;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-23']/div/ul/li[1]/a")
	private WebElementFacade wildfireLink;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-4']/div/ul/li[1]/a")
	private WebElementFacade droughtLink;

	@FindBy(xpath = "//*[@id='block-aggregator-feed-6']/div/ul/li[1]/a")
	private WebElementFacade earthquakeLink;

	@FindBy(xpath = "//*[@id='more-less-text']")
	private WebElementFacade moreButton;

	@FindBy(xpath = "//*[@id='more-less-content']")
	private WebElementFacade moreContent;

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

	public void clickOnDisasterLink() {
		disasterLink.click();
	}

	public void clickOnSevereLink() {
		severeStormLink.click();
	}

	public void clickOnHurricaneLink() {
		hurricaneLink.click();
	}

	public void clickOnWildfireLink() {
		wildfireLink.click();
	}

	public void clickOnDroughtLink() {
		droughtLink.click();
	}

	public void clickOnEarthquakeLink() {
		earthquakeLink.click();
	}

	public String getUrl() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(browserTabs.get(1));
		String url = getDriver().getCurrentUrl();
		getDriver().switchTo().window(browserTabs.get(0));
		return url;
	}

	public boolean urlOpened() {
		return getUrl().contains("www") || getUrl().contains(".gov") || getUrl().contains(".edu")
				|| getUrl().contains(".html");
	}

	public void clickMore() {
		moreButton.click();
	}

	public String moreContentText() {
		return moreContent.getText();
	}

	public boolean contentDisplayed() {
		return moreContentText().contains("Emergency") || moreContentText().contains("Your")
				|| moreContentText().contains("Resources") || moreContentText().contains("Flood");
	} 
}