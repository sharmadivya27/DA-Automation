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
		//getDriver().switchTo().window(browserTabs.get(0));
		return url;
	}

	public boolean urlOpened() {
		return getUrl().contains("www") || getUrl().contains(".gov") || getUrl().contains(".edu")
				|| getUrl().contains(".html") || getUrl().contains(".org");
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