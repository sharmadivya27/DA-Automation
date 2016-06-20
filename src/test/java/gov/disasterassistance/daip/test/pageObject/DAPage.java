package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

//*************************************************************************
//Class: DApage
//Description: Using Selenium Webdriver, this class handles web related 
//	code such as pulling elements from the given site.
//
/** @author Chris Viqueira **/
@DefaultUrl("http://www.disasterassistance.gov")
public class DAPage extends PageObject {

	public DAPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//nav[@id='nav']/ul/li[@class[contains(., 'menu__item')]]")
	private List<WebElementFacade> navParentNode;

	@FindBy(xpath = "//div[@id='landing-page-container']/a")
	private List<WebElementFacade> landingPageNode;

	private List<WebElementFacade> allElements = new ArrayList<WebElementFacade>();

	// NOTE(chris)
	// Fix the none clickable landingPageNode
	public void clickNavNode(String node) {
		if (allElements == null || allElements.isEmpty()) {
			allElements.addAll(landingPageNode);
			allElements.addAll(navParentNode);
		}
		Iterator<WebElementFacade> iter = allElements.iterator();
		WebElementFacade tab = null;
		while (iter.hasNext()) {
			WebElementFacade tempTab = iter.next();
			String tempTitle = getNodeTitle(tempTab);

			if (node.equalsIgnoreCase(tempTitle)) {
				tab = tempTab;
				break;
			}
		}

		if (tab == null) {
			System.err.println("COULD NOT FIND NODE WITH THAT TITLE");
		} else {
			tab.click();
		}
	}

	private String getNodeTitle(WebElementFacade tempTab) {
		String ret;
		try {
			ret = tempTab.findElement(By.className("lp-link-title")).getText().toLowerCase();
		} catch (Exception e) {
			ret = tempTab.getText();
		}

		return ret;
	}

	// this and child node basically duplicates, fix this later
	public void clickParentNavNodes(String menuItem) {
		Iterator<WebElementFacade> iter = navParentNode.iterator();
		WebElementFacade tab = null;
		while (iter.hasNext()) {
			WebElementFacade tempTab = iter.next();
			String tempTitle = tempTab.getText();

			if (menuItem.equalsIgnoreCase(tempTitle)) {
				tab = tempTab;
			}
		}

		if (tab == null) {
			System.err.println("COULD NOT FIND TAB WITH THAT TITLE");
		} else {
			tab.click();
		}
	}

	public int numberOfLandingPageNodes() {
		return landingPageNode.size();
	}

	public void clickLandingPageNode(String landingNode) {
		Iterator<WebElementFacade> iter = landingPageNode.iterator();
		WebElementFacade node = null;
		while (iter.hasNext()) // Will look through the nodes pulled from
								// the
								// web site to find current case
		{
			WebElementFacade tempNode = iter.next();
			String tempTitle = tempNode.findElement(By.className("lp-link-title")).getText().toLowerCase();

			if (tempTitle.contains(landingNode)) {
				node = tempNode;
				break;
			}
		}

		if (node == null) {
			System.err.println("COULD NOT FIND LANDING PAGE NODE");
		} else {
			node.click();
		}

	}

	@FindBy(xpath = "//*[@class='page__title title']")
	private WebElementFacade pageTitle;

	public String pullPageTitle() {
		return pageTitle.getText();
	}

	@FindBy(xpath = "//*//div[@id='address-lookup-container']")
	private WebElementFacade addressLookup;

	public boolean addressLookupIsDisplayed() {
		return addressLookup.isDisplayed();
	}

	@FindBy(xpath = "//div[@id='block-daip-responsive-questionnaire-responsive-questionnaire-block']")
	private WebElementFacade questionnaire;

	public boolean questionnaireIsDisplayed() {
		return questionnaire.isDisplayed();
	}

	@FindBy(xpath = "//a[@href[contains(., 'TextCaptcha')]]")
	private WebElementFacade textCaptcha;

	public boolean textCaptchaIsDisplayed() {
		return textCaptcha.isDisplayed();
	}

	@FindBy(xpath = "//*[@id='pageContent']")
	private WebElementFacade checkStatusPageContent;

	public boolean checkStatusPageIsDisplayed() {
		return checkStatusPageContent.isDisplayed();
	}

	@FindBy(xpath = "//div[@class[contains(., 'accordion') and not(contains(., 'name'))]]")
	private List<WebElementFacade> accordionBlocks;

	public int getNumberAccordions() {
		return accordionBlocks.size();
	}

	@FindBy(id = "stateSelector")
	private WebElementFacade stateSelector;

	@FindBy(xpath = "//fieldset//label[@class[contains(., 'radio')] and text()[not(contains(., 'No')) and not(contains(., 'Unknown'))]]")
	private List<WebElementFacade> questionnaireButtons;

	public void completeFullQuestionnaire() {
		Iterator<WebElementFacade> iter = questionnaireButtons.iterator();
		while (iter.hasNext()) {
			WebElementFacade temp = iter.next();
			temp.click();
			this.evaluateJavascript("window.scrollBy(0,50)");
		}
		stateSelector.sendKeys("Alabama");
	}
	
	//TODO still doesn't distinguish between the yes buttons, just looks at the text by the clickable button
	private WebElementFacade getQuestionnaireButton(String buttonName) {
		Iterator<WebElementFacade> iter = questionnaireButtons.iterator();
		WebElementFacade btn = null;
		while(iter.hasNext()){
			WebElementFacade temp = iter.next();
			if(temp.containsText(buttonName)) {
				btn = temp;
				break;
			}
		}
		return btn;
	}
	

	@FindBy(id = "benefit-counter-count")
	private WebElementFacade benefitCounter;

	public int getQuestionnaireResults() {
		return Integer.parseInt(benefitCounter.getText());
	}

	public void clickEmployment() {
		getQuestionnaireButton("Employment").click();
	}

	@FindBy(xpath = "//div[@class='foaccordionable']")
	List<WebElementFacade> FOAResults;
	
	public void getFOAResultsPage() {
		benefitCounter.click();
	}

	//These show up with more than just employment benefits
	/*List<String> employmentBenefits = Arrays.asList("American Job Centers Network", "Disaster Umemployment Assistance",
			"Umemployment Insurance", "203(h) Mortgage Insurance,", "Disaster Recovery Center", 
			"Internaional Terrorism Victim Expense Reimbursement Program", "Savings Bond Redemption and Replacement");
			*/

	public int getNumEmploymentResults() {
		return FOAResults.size();
	}
}
