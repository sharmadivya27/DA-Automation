package gov.dare.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.disasterassistance.gov")
public class HomepageObject extends PageObject 
{
	/**
	 * Not sure if you really need constructor but keeping it in since Serenity manual uses this 
	 */
	public HomepageObject (WebDriver driver)
	{
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//nav[@id='nav']/ul/li[@class[contains(., 'menu__item')]]")
	private List<WebElementFacade> navParentNode;
	final class NavMenuItem 
	{	 //menu items pulled sequentially, referencing by name looks nicer
		static final short home = 0;
		static final short getAssistance = 1;
		static final short information = 2;
		static final short aboutUs = 3;
		static final short help = 4;
	}
	
	/**
	 * Clicks on the menu item passed into the function.
	 * @param menuItem - takes a menu item from the "examples" section under scenario 1 in dailyRegression.story
	 */
	public void clickParentNavNodes(String menuItem)
	{
		switch(menuItem)
		{
		case "home":
		{
			navParentNode.get(NavMenuItem.home).click();
		} break;
		
		case "get assistance":
		{
			navParentNode.get(NavMenuItem.getAssistance).click();
		} break;
		
		case "information":
		{
			navParentNode.get(NavMenuItem.information).click();
		} break;
		
		case "about us":
		{
			navParentNode.get(NavMenuItem.aboutUs).click();
		} break;
		
		case "help":
		{
			navParentNode.get(NavMenuItem.help).click();
		} break;
		
		default:
		{
			//TODO better error checking
			System.err.println("ERROR: something weird got passed in from scenario 1 in dailyRegression.story");
		} break;

		} // end switch
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//div[@id='landing-page-container']/a")
	private List<WebElementFacade> landingPageNode;
	
	public short numberOfLandingPageNodes()
	{
		return (short) landingPageNode.size();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//nav[@id='nav']//ul/li[@class[contains(., 'menu__item is-leaf')]]")
	private List<WebElementFacade> navChildNode;
	
	public void clickChildNavNode(String menuItem)
	{
		switch(menuItem)
		{
		//Get Assistance parent node
		case "address look-up":
		{
			
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
			System.err.println("What did you pass me??");
		} break;
		
		} // end switch
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//*[@class='page__title title']")
	private WebElementFacade pageTitle;
	
	public String pullPageTitle() 
	{
		return pageTitle.getText();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//*//div[@id='address-lookup-container']")
	private WebElementFacade addressLookup;
	
	public boolean isHomepage()
	{
		return addressLookup.isDisplayed();
	}
	
}
