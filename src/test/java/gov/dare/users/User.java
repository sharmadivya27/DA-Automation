package gov.dare.users;

import org.junit.Assert;

import gov.dare.pageObjects.DApage;
import net.thucydides.core.annotations.Step;

public class User 
{
	DApage page;
	
	@Step
	public void open_home_page() 
	{
		page.open();
	}
	
	@Step
	public void open_page(String url)
	{
		page.openAt(url);
	}
	
	@Step
	public void clickParentNavigationTab(String menuItem)
	{
		page.clickParentNavNodes(menuItem);
	}
	
	@Step
	public void clickLandingPageNode(String subTab)
	{
		page.clickLandingPageNode(subTab);
	}
	
	@Step
	public void shouldSeeText(String expected)
	{
		String pageTitle = page.pullPageTitle();
		
		//lower case to account for case mismatching
		Assert.assertEquals(expected.toLowerCase(), pageTitle.toLowerCase());
	}
	
	@Step
	public void shouldSeeXLandingPageNodes(short expected)
	{
		Assert.assertEquals(expected, page.numberOfLandingPageNodes());
	}
	
	@Step
	public void shouldSeeAddressLookup()
	{
		Assert.assertEquals(true, page.addressLookupIsDisplayed());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	@Step
	public void shouldSeePage(String expectedPage)
	{
		switch(expectedPage)
		{
			//Get Assistance parent node
			case "address look-up":
			{
				Assert.assertEquals(true, page.addressLookupIsDisplayed());
			} break;
			
			case "find assistance":
			{
				
			} break;
			
			case "apply online":
			{
				
			} break;
			
			case "check your status":
			{
				
			} break;
			
			case "assistance by catgory":
			{
				
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
