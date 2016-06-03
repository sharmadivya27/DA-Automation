package gov.dare.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;

@SuppressWarnings("deprecation")
@DefaultUrl("http://www.disasterassistance.gov")
public class DApage extends PageObject 
{
	/**
	 * Not sure if you really need constructor but keeping it in since Serenity manual uses this 
	 */
	public DApage (WebDriver driver)
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
	
	public void clickLandingPageNode(String landingNode)
	{
		Iterator<WebElementFacade> iter = landingPageNode.iterator();
		WebElementFacade node = null;
		while(iter.hasNext()) //Will look through the nodes pulled from the web site to find current case
		{
			WebElementFacade tempNode = iter.next();
			String tempTitle = tempNode.findElement(By.className("lp-link-title")).getText();
			
			if(landingNode.equalsIgnoreCase(tempTitle))
			{
				node = tempNode;
				break;
			}
		}
		
		if(node == null)
		{
			System.err.println("COULD NOT FIND LANDING PAGE NODE");
		}
		else
		{
			node.click();
		}
		
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
	
	public boolean addressLookupIsDisplayed()
	{
		return addressLookup.isDisplayed();
	}
	
}
