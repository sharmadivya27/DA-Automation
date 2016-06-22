package gov.disasterassistance.daip.test.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/*************************************************************************
 *	Using Selenium Webdriver, this class handles web related 
 *	code such as pulling elements from the given site.
 *
 *	@author Chris Viqueira
 *************************************************************************/
@DefaultUrl("http://www.disasterassistance.gov")
public class DAPage extends PageObject {

	public DAPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	public void clearCookies() {
		this.getDriver().manage().deleteAllCookies();
	}
	
	//*************************************************************************
	//	FindBy / private variables section
	
	@FindBy(id = "stateSelector")
	private WebElementFacade stateSelector;

	@FindBy(xpath = "//fieldset//label[@class[contains(., 'radio')] and text()[not(contains(., 'No')) and not(contains(., 'Unknown'))]]")
	private List<WebElementFacade> questionnaireButtons;
	
	@FindBy(xpath = "//div[@class[contains(., 'accordion') and not(contains(., 'name'))]]")
	private List<WebElementFacade> accordionBlocks;
	
	@FindBy(xpath = "//*[@id='pageContent']")
	private WebElementFacade checkStatusPageContent;
	
	@FindBy(xpath = "//a[@href[contains(., 'TextCaptcha')]]")
	private WebElementFacade textCaptcha;
	
	@FindBy(xpath = "//div[@id='block-daip-responsive-questionnaire-responsive-questionnaire-block']")
	private WebElementFacade questionnaire;
	
	@FindBy(xpath = "//*//div[@id='address-lookup-container']")
	private WebElementFacade addressLookup;
	
	//Find assistance page
	@FindBy(xpath = "//div[@class='foaccordionable']")
	private List<WebElementFacade> FOAResults;
	
	@FindBy(xpath = "//div[@class[contains(., 'accordbody')]]")
	private List<WebElementFacade> FOAAccordionBody;
	
	@FindBy(xpath = "//div[@id='expand-all-button']")
	private WebElementFacade expandAllButton;
	
	@FindBy(xpath = "//div[@id='collapse-all-button']")
	private WebElementFacade collapseAllButton;
	
	@FindBy(id = "benefit-counter-count")
	private WebElementFacade benefitCounter;
	
	@FindBy(xpath = "//*[@class='page__title title']")
	private WebElementFacade pageTitle;

	@FindBy(xpath = "//ul[@class='expand-collapse']/li")
	private List<WebElementFacade> federalAgencyAccordions;
    
	@FindBy(xpath = "//nav[@id='nav']/ul/li[@class[contains(., 'menu__item')]]")
	private List<WebElementFacade> navParentNode;

	@FindBy(xpath = "//div[@id='landing-page-container']/a")
	private List<WebElementFacade> landingPageNode;

	private List<WebElementFacade> allElements = new ArrayList<WebElementFacade>();
	
	//*************************************************************************
	//	Functions

	/*************************************************************************
	 	Searches through the main menu nodes and current landing
	 	page nodes to find the element with the same name that was passed.
		Once it finds the node it will click on the button. 
		
		@param node : Name of the node to be clicked on
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

	
	/*************************************************************************
		Completes the entire FOA questionnaire checking every
	 	box, saying yes to every question, and picking a state.
	*************************************************************************/
	public void completeFullQuestionnaire() {
		Iterator<WebElementFacade> iter = questionnaireButtons.iterator();
		while (iter.hasNext()) {
			WebElementFacade temp = iter.next();
			temp.click();
			this.evaluateJavascript("window.scrollBy(0,50)");
		}
		stateSelector.sendKeys("Alabama");
	}
	
	
	/*************************************************************************
		Clicks an individual element from the list of all of the 
		questionnaire buttons.
		
		@param buttonName : The name of the element to be clicked
	 *************************************************************************/
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
	
	public WebElementFacade getFederalAgency(String federalAgencyName) {
		Iterator<WebElementFacade> iter = federalAgencyAccordions.iterator();
		WebElementFacade accordion = null;
		while(iter.hasNext()){
			WebElementFacade temp = iter.next();
			if(temp.containsText(federalAgencyName)) {
				accordion = temp;
				break;
			}
		}
		return accordion;
	}
	
	public void checkFederalBenefits() throws BenefitCountException {
		Iterator<WebElementFacade> federalAgencyIter = federalAgencyAccordions.iterator();
		while(federalAgencyIter.hasNext()) {
			WebElementFacade federalAgency = federalAgencyIter.next();
			String departmentNameAndBenefits = federalAgency.getText();
			String departmentName = departmentNameAndBenefits.substring(0, departmentNameAndBenefits.length()-2).trim();
			int benefitCount = Integer.parseInt(departmentNameAndBenefits.substring(departmentNameAndBenefits.length()-2).trim());

			List<WebElement> benefits = this.getDriver().findElements(By.xpath("//div[@class='accordion-name-text' and "
					+ "text()[contains(., '" + departmentName + "')]]/../../ul//li"));
			
			if(benefits.size() != benefitCount) {
				throw new BenefitCountException("Incorrect number of benefits");
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

	public boolean textCaptchaIsDisplayed() {
		return textCaptcha.isDisplayed();
	}

	public boolean checkStatusPageIsDisplayed() {
		return checkStatusPageContent.isDisplayed();
	}

	public int getNumberAccordions() {
		return accordionBlocks.size();
	}

	public int getQuestionnaireResults() {
		return Integer.parseInt(benefitCounter.getText());
	}

	public void clickEmploymentCheckbox() {
		getQuestionnaireButton("Employment").click();
	}

	public void getFOAResultsPage() {
		benefitCounter.click();
	}

	public int getNumEmploymentResults() {
		return FOAResults.size();
	}
	
	public void expandFOAResults() {
		expandAllButton.click();
	}
	
	public boolean accordVisible() {
		return FOAAccordionBody.get(0).isVisible();
	}
}
