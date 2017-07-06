package gov.disasterassistance.daip.test.pageObject;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://edit.disasterassistance.gov/user")
public class DrupalPage extends PageObject {

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

	@FindBy(xpath = "//*[@id='edit-pages']/div/div/ul[1]/li[4]/a")
	private WebElementFacade lastPage;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[7]/td[2]")
	private WebElementFacade lastDAUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[13]/td[2]")
	private WebElementFacade lastBGUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[15]/td[2]")
	private WebElementFacade lastReadyUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[12]/td[2]")
	private WebElementFacade lastNRNUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[12]/td[2]")
	private WebElementFacade lastGrantsUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr/td")
	private WebElementFacade lastUSAUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[15]/td[2]")
	private WebElementFacade lastFemaUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[6]/td[2]")
	private WebElementFacade lastCFDAUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[3]/td[2]")
	private WebElementFacade lastDHSUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[15]/td[2]")
	private WebElementFacade lastRedcrossUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr/td")
	private WebElementFacade lastHHSUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr/td[2]")
	private WebElementFacade lastSBAUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr/td[2]")
	private WebElementFacade lastFCCUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[2]/td[2]")
	private WebElementFacade lastHUDUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[3]/td[2]")
	private WebElementFacade lastEPAUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[6]/td[2]")
	private WebElementFacade lastEnergyUrl;

	@FindBy(xpath = "//*[@id='edit-pages']/div/table[2]/tbody/tr[4]/td[2]")
	private WebElementFacade lastCDCUrl;

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

	public void logIntoDrupal() {
		getDriver().manage().window().maximize();
		username.type("automatedUser");
		password.type("Drupal1234");
		submit.click();
	}

	public void onElasticSearchPage() {
		disasterAssistance.click();
		elasticSearchSettings.click();
	}

	public void clickManagePages() {
		managePagesTab.click();
	}

	public void searchGrantsText() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchField);
		actions.click();
		actions.sendKeys("FAQs Grants Application Frequently Asked Grant Questions");
		actions.build().perform();
		searchSubmit.click();
	}

	public void searchFemaText() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchField);
		actions.click();
		actions.sendKeys("Youth Kids Family Preparedness Counseling Training");
		actions.build().perform();
		searchSubmit.click();
	}

	public void showResults() {
		searchPage.getText();
	}

	public void getDAPages() {
		selectSite.click();
		selectSite.sendKeys("DisasterAssistance");
		getPages.click();
	}

	public void getBenefitsPages() {
		selectSite.click();
		selectSite.sendKeys("Benefits");
		getPages.click();
	}

	public void getReadyPages() {
		selectSite.click();
		selectSite.sendKeys("Ready");
		getPages.click();
	}

	public void getNRNPages() {
		selectSite.click();
		selectSite.sendKeys("NRN");
		getPages.click();
	}

	public void getGrantPages() {
		selectSite.click();
		selectSite.sendKeys("Grants");
		getPages.click();
	}

	public void getUSAGovPages() {
		selectSite.click();
		selectSite.sendKeys("USA.gov");
		getPages.click();
	}

	public void getFemaPages() {
		selectSite.click();
		selectSite.sendKeys("Fema");
		getPages.click();
	}

	public void getCFDAPages() {
		selectSite.click();
		selectSite.sendKeys("CFDA");
		getPages.click();
	}

	public void getDHSPages() {
		selectSite.click();
		selectSite.sendKeys("DHS");
		getPages.click();
	}

	public void getRedcrossPages() {
		selectSite.click();
		selectSite.sendKeys("Redcross");
		getPages.click();
	}

	public void getHHSPages() {
		selectSite.click();
		selectSite.sendKeys("HHS");
		getPages.click();
	}

	public void getSBAPages() {
		selectSite.click();
		selectSite.sendKeys("SBA");
		getPages.click();
	}

	public void getFCCPages() {
		selectSite.click();
		selectSite.sendKeys("FCC");
		getPages.click();
	}

	public void getHUDPages() {
		selectSite.click();
		selectSite.sendKeys("HUD");
		getPages.click();
	}

	public void getEPAPages() {
		selectSite.click();
		selectSite.sendKeys("EPA");
		getPages.click();
	}

	public void getEnergyPages() {
		selectSite.click();
		selectSite.sendKeys("Energy");
		getPages.click();
	}

	public void getCDCPages() {
		selectSite.click();
		selectSite.sendKeys("CDC");
		getPages.click();
	}

	public void clickLastPageButton() {
		this.evaluateJavascript("window.scrollBy(0,50)", "");
		Actions action = new Actions(getDriver());
		action.moveToElement(lastPage).perform();
	}

	public String getDAUrl() {
		return lastDAUrl.getText();
	}

	public String getBenefitsUrl() {
		return lastBGUrl.getText();
	}

	public String getReadyUrl() {
		return lastReadyUrl.getText();
	}

	public String getNRNUrl() {
		return lastNRNUrl.getText();
	}

	public String getGrantsUrl() {
		return lastGrantsUrl.getText();
	}

	public String getUSAgovUrl() {
		return lastUSAUrl.getText();
	}

	public String getFemaUrl() {
		return lastFemaUrl.getText();
	}

	public String getCFDAUrl() {
		return lastCFDAUrl.getText();
	}

	public String getDHSUrl() {
		return lastDHSUrl.getText();
	}

	public String getRedcrossUrl() {
		return lastRedcrossUrl.getText();
	}

	public String getHHSUrl() {
		return lastHHSUrl.getText();
	}

	public String getSBAUrl() {
		return lastSBAUrl.getText();
	}

	public String getFCCUrl() {
		return lastFCCUrl.getText();
	}

	public String getHUDUrl() {
		return lastHUDUrl.getText();
	}

	public String getEPAUrl() {
		return lastEPAUrl.getText();
	}

	public String getEnergyUrl() {
		return lastEnergyUrl.getText();
	}

	public String getCDCUrl() {
		return lastCDCUrl.getText();
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

	public boolean communityResults() {
		return quickSearchResult.containsText("Community") || quickSearchResult.containsText("Preparedness")
				|| quickSearchResult.containsText("Recovery") || quickSearchResult.containsText("leaders")
				|| quickSearchResult.containsText("housing") || quickSearchResult.containsText("Shelter")
				|| quickSearchResult.containsText("Volunteers") || quickSearchResult.containsText("Utilities")
				|| quickSearchResult.containsText("Public Assistance")
				|| quickSearchResult.containsText("Infrastructure") || quickSearchResult.containsText("Government")
				|| quickSearchResult.containsText("Guide") || quickSearchResult.containsText("Checklists");
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