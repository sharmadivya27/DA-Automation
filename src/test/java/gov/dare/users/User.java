package gov.dare.users;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import gov.dare.pageObjects.DApage;
import net.thucydides.core.annotations.Step;

public class User {
	DApage daPage;

	@Step
	public void open_home_page() {
		daPage.open();
	}

	@Step
	public void open_page(String url) {
		daPage.openAt(url);
	}

	@Step
	public void clickParentNavigationTab(String menuItem) {
		daPage.clickParentNavNodes(menuItem);
	}

	@Step
	public void clickLandingPageNode(String subTab) {
		daPage.clickLandingPageNode(subTab);
	}

	@Step
	public void shouldSeeLandingPageNodes(short expected) {
		Assert.assertEquals(expected, daPage.numberOfLandingPageNodes());
	}

	////////////////////////////////////////////////////////////////////////////////////////////

	@Step
	public void shouldSeePage(String expectedPageName) {
		String pageTitle = "";
		try {
			pageTitle = daPage.pullPageTitle();
		} catch (NoSuchElementException e) {
			// do nothing
		}

		switch (expectedPageName) {
		case "home": {
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
		}
			break;

		case "get assistance": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "information": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "about us": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "help": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		// Get Assistance parent node
		case "address look-up": {
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
		}
			break;

		case "find assistance": {
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
		}
			break;

		case "apply online": {
			Assert.assertEquals(true, daPage.textCaptchaIsDisplayed());
		}
			break;

		case "check your status": {
			Assert.assertEquals(true, daPage.checkStatusPageIsDisplayed());
		}
			break;

		case "assistance by catgory": {
			Assert.assertEquals(15, daPage.getNumberAccordions()); // counted
																	// manually
																	// 6/6/16
		}
			break;

		case "assistance by federal agency": {
			Assert.assertEquals(14, daPage.getNumberAccordions()); // counted
																	// manually
																	// 6/6/16
		}
			break;

		case "application checklist": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "forms": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		// Information parent node
		case "news feeds": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "immediate needs": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "moving forward": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "community resources": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "disabilities or access and functional needs": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "older americans": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "children and families": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "disaster types": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "foreign disasters": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "fact sheets": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		// About us parent node
		case "overview": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "partners": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		// Help parent node
		case "faqs": {
			Assert.assertEquals(27, daPage.getNumberAccordions()); // counted
																	// manually
																	// 6/8/16
		}
			break;

		case "contact us": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "privacy policy": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "accessibility": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		case "download plug-ins": {
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
		}
			break;

		default: {
			System.err.println("INVALID PAGE SENT");
		}
			break;

		} // end switch
	}

}
