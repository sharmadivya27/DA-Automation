package gov.disasterassistance.daip.test.pageObject;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://edit.disasterassistance.gov/user")
public class DrupalPage extends PageObject {

	// *************************************************************************
	// FindBy / private variables section

	@FindBy(xpath = "//*[@id='edit-name']")
	private WebElementFacade username;

	@FindBy(xpath = "//*[@id='edit-pass']")
	private WebElementFacade password;

	@FindBy(xpath = "//*[@id='edit-submit']")
	private WebElementFacade submit;

	@FindBy(xpath = "//*[@id='toolbar-link-admin-settings-daip_admin']")
	private WebElementFacade disasterAssistance;

	@FindBy(xpath = "//*[@id='block-system-main']/div/ul/li[1]/a")
	private WebElementFacade elasticSearchSettings;

	@FindBy(xpath = "//*[@id='page-title']/div/div/ul/li[2]/a")
	private WebElementFacade managePagesTab;

	@FindBy(xpath = "//*[@id='edit-sites-list']")
	private WebElementFacade selectSite;

	@FindBy(xpath = "//*[@id='edit-pages-pull']")
	private WebElementFacade getPages;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[2]/td[6]/a")
	private WebElementFacade editGrantsPage;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[9]/td[6]/a")
	private WebElementFacade editFemaPage;

	@FindBy(xpath = "//*[@id='edit-daip-elastic-search-results-pages-edit-tags']")
	private WebElementFacade tagWords;

	@FindBy(xpath = "//*[@class='form-item form-type-textfield form-item-query']")
	private WebElementFacade searchField;

	@FindBy(xpath = "//*[@id='edit-submit-desktop']")
	private WebElementFacade searchSubmit;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[1]/div/div[1]")
	private WebElementFacade searchPage;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[1]/td[3]")
	private WebElementFacade url;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr/td")
	private WebElementFacade noPages;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[1]/div")
	private WebElementFacade communityPreparedness;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[2]/div")
	private WebElementFacade disasterRecoveryResources;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[3]/div")
	private WebElementFacade emergencyShelterHousing;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[4]/div")
	private WebElementFacade howCanYouHelp;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[5]/div")
	private WebElementFacade infrastructure;

	@FindBy(xpath = "//*[@id='block-daip-elastic-search-daip-preset-search-queries']/div[1]/div/div[3]")
	private WebElementFacade quickSearchResult;

	// *************************************************************************************
	// Functions

	/*************************************************************************
	 * Logs into the Drupal DA site with a test account.
	 * 
	 *************************************************************************/
	public void logIntoDrupal() {
		getDriver().manage().window().maximize();
		username.type("automatedUser");
		password.type("Drupal1234");
		submit.click();
	}

	/*************************************************************************
	 * Navigates to the elastic search page.
	 * 
	 *************************************************************************/
	public void onElasticSearchPage() {
		disasterAssistance.click();
		elasticSearchSettings.click();
	}

	/*************************************************************************
	 * Clicks the 'Manage Pages' tab in Drupal.
	 * 
	 *************************************************************************/
	public void clickManagePages() {
		managePagesTab.click();
	}

	/*************************************************************************
	 * Collects the key words of the Grants page from Drupal and types it into
	 * the Community Leaders search box.
	 * 
	 *************************************************************************/
	public void searchGrantsText() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchField);
		actions.click();
		actions.sendKeys("FAQs Grants Application Frequently Asked Grant Questions");
		actions.build().perform();
		searchSubmit.click();
	}

	/*************************************************************************
	 * Collects the key words of the Fema page from Drupal and types it into the
	 * Community Leaders search box.
	 * 
	 *************************************************************************/
	public void searchFemaText() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchField);
		actions.click();
		actions.sendKeys("Youth Kids Family Preparedness Counseling Training");
		actions.build().perform();
		searchSubmit.click();
	}

	/*************************************************************************
	 * Checks if the Community Leaders search box contains any of these
	 * keywords.
	 * 
	 *************************************************************************/
	public boolean communityResults() {
		return quickSearchResult.containsText("Community") || quickSearchResult.containsText("community")
				|| quickSearchResult.containsText("Preparedness") || quickSearchResult.containsText("recovery")
				|| quickSearchResult.containsText("leaders") || quickSearchResult.containsText("housing")
				|| quickSearchResult.containsText("Shelter") || quickSearchResult.containsText("Volunteers")
				|| quickSearchResult.containsText("Utilities") || quickSearchResult.containsText("Public Assistance")
				|| quickSearchResult.containsText("community") || quickSearchResult.containsText("Infrastructure")
				|| quickSearchResult.containsText("Governments") || quickSearchResult.containsText("Guide")
				|| quickSearchResult.containsText("Checklists") || quickSearchResult.containsText("infraestructura")
				|| quickSearchResult.containsText("comunidad") || quickSearchResult.containsText("gobierno")
				|| quickSearchResult.containsText("refugio") || quickSearchResult.containsText("Vivienda")
				|| quickSearchResult.containsText("desastres") || quickSearchResult.containsText("Lista");
	}

	public void showResults() {
		searchPage.getText();
	}

	public void getDAPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.disasterassistance.gov");
		getPages.click();
	}

	public void getBenefitsPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.benefits.gov");
		getPages.click();
	}

	public void getReadyPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.ready.gov");
		getPages.click();
	}

	public void getNRNPages() {
		selectSite.click();
		selectSite.sendKeys("http://www.nationalresourcenetwork.org/en/home");
		getPages.click();
	}

	public void getGrantPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.grants.gov");
		getPages.click();
	}

	public void getUSAGovPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.usa.gov");
		getPages.click();
	}

	public void getFemaPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.fema.gov");
		getPages.click();
	}

	public void getCFDAPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.cfda.gov");
		getPages.click();
	}

	public void getDHSPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.dhs.gov");
		getPages.click();
	}

	public void getRedcrossPages() {
		selectSite.click();
		selectSite.sendKeys("http://www.redcross.org");
		getPages.click();
	}

	public void getHHSPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.hhs.gov");
		getPages.click();
	}

	public void getSBAPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.sba.gov");
		getPages.click();
	}

	public void getFCCPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.fcc.gov");
		getPages.click();
	}

	public void getHUDPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.hudexchange.info");
		getPages.click();
	}

	public void getEPAPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.epa.gov");
		getPages.click();
	}

	public void getEnergyPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.energy.gov");
		getPages.click();
	}

	public void getCDCPages() {
		selectSite.click();
		selectSite.sendKeys("https://www.cdc.gov");
		getPages.click();
	}

	public void getSpanishBenefits() {
		selectSite.click();
		selectSite.sendKeys("https://www.benefits.gov/es");
		getPages.click();
	}

	public void getSpanishReady() {
		selectSite.click();
		selectSite.sendKeys("https://www.ready.gov/es");
		getPages.click();
	}

	public void getSpanishFema() {
		selectSite.click();
		selectSite.sendKeys("https://www.fema.gov/es");
		getPages.click();
	}

	public void getSpanishRedCross() {
		selectSite.click();
		selectSite.sendKeys("http://www.redcross.org/cruz-roja");
		getPages.click();
	}

	public void getSpanishSBA() {
		selectSite.click();
		selectSite.sendKeys("https://www.es.sba.gov");
		getPages.click();
	}

	public void getSpanishFCC() {
		selectSite.click();
		selectSite.sendKeys("https://www.fcc.gov/es");
		getPages.click();
	}

	public void getSpanishEPA() {
		selectSite.click();
		selectSite.sendKeys("https://espanol.epa.gov/");
		getPages.click();
	}

	public void getSpanishCDC() {
		selectSite.click();
		selectSite.sendKeys("https://www.cdc.gov/es");
		getPages.click();
	}

	public void getSpanishDA() {
		selectSite.click();
		selectSite.sendKeys("https://www.disasterassistance.gov/es/");
		getPages.click();
	}

	public String getFirstUrl() {
		return url.getText();
	}

	public String noPages() {
		return noPages.getText();
	}

	public void editGrantsPage() {
		editGrantsPage.click();
	}

	public void editFemaPage() {
		editFemaPage.click();
	}

	public String viewTagWords() {
		return tagWords.getText();
	}

	public void clickCommunityPreparedness() {
		communityPreparedness.click();
	}

	public void clickDisasterRecoveryResources() {
		disasterRecoveryResources.click();
	}

	public void clickEmergencyShelterHousing() {
		emergencyShelterHousing.click();
	}

	public void clickHowCanYouHelp() {
		howCanYouHelp.click();
	}

	public void clickInfrastructure() {
		infrastructure.click();
	}
}