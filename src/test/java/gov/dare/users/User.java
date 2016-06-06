package gov.dare.users;

import org.junit.Assert;

import gov.dare.pageObjects.DApage;
import net.thucydides.core.annotations.Step;

public class User 
{
	DApage daPage;
	
	@Step
	public void open_home_page() 
	{
		daPage.open();
	}
	
	@Step
	public void open_page(String url)
	{
		daPage.openAt(url);
	}
	
	@Step
	public void clickParentNavigationTab(String menuItem)
	{
		daPage.clickParentNavNodes(menuItem);
	}
	
	@Step
	public void clickLandingPageNode(String subTab)
	{
		daPage.clickLandingPageNode(subTab);
	}
	
	@Step
	public void shouldSeeText(String expected)
	{
		String pageTitle = daPage.pullPageTitle();
		
		//lower case to account for case mismatching
		Assert.assertEquals(expected.toLowerCase(), pageTitle.toLowerCase());
	}
	
	@Step
	public void shouldSeeXLandingPageNodes(short expected)
	{
		Assert.assertEquals(expected, daPage.numberOfLandingPageNodes());
	}
	
	@Step
	public void shouldSeeAddressLookup()
	{
		Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	@Step
	public void shouldSeePage(String page)
	{
		switch(page)
		{
		//Get Assistance parent node
		case "address look-up":
		{
			Assert.assertEquals(true, daPage.addressLookupIsDisplayed());
		} break;
		
		case "find assistance":
		{
			Assert.assertEquals(true, daPage.questionnaireIsDisplayed());
		} break;
		
		case "apply online":
		{
			Assert.assertEquals(true, daPage.textCaptchaIsDisplayed());
		} break;
		
		case "check your status":
		{
			Assert.assertEquals(true, daPage.checkStatusPageIsDisplayed());
		} break;
		
		case "assistance by catgory":
		{
			Assert.assertEquals(15, daPage.getNumberAccordions());	//counted manually 6/6/16
		} break;
		
		case "assistance by federal agency":
		{
			
		} break;
		
		case "application checklist":
		{
			
		} break;
		
		case "forms":
		{
			
		} break;
		
		//Information parent node
		case "news feeds":
		{
			
		} break;
		
		case "immediate needs":
		{
			
		} break;
		
		case "moving forward":
		{
			
		} break;
		
		case "community resources":
		{
			
		} break;
		
		case "disabilities or access and functional needs":
		{
			
		} break;
		
		case "older americans":
		{
			
		} break;
		
		case "children and families":
		{
			
		} break;
		
		case "disaster types":
		{
			
		} break;
		
		case "foreign disasters":
		{
			
		} break;
		
		case "fact sheets":
		{
			
		} break;
		
		//About us parent node
		case "overview":
		{
			
		} break;
		
		case "partners":
		{
			
		} break;
		
		//Help parent node
		case "faqs":
		{
			
		} break;
		
		case "contact us":
		{
			
		} break;
		
		case "privacy policy":
		{
			
		} break;
		
		case "accessibility":
		{
			
		} break;
		
		case "download plug-ins":
		{
			
		} break;
		
		default:
		{
			System.err.println("INVALID PAGE SENT");
		} break;
		
		} // end switch
	}
	
}
