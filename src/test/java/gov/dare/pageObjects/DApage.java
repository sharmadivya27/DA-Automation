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
	
	//this and child node basically duplicates, fix this later
	public void clickParentNavNodes(String menuItem)
	{
		Iterator<WebElementFacade> iter = navParentNode.iterator();
		WebElementFacade tab = null;
		while(iter.hasNext())
		{
			WebElementFacade tempTab = iter.next();
			String tempTitle = tempTab.getText();
			
			if(menuItem.equalsIgnoreCase(tempTitle))
			{
				tab = tempTab;
			}
		}
		
		if(tab == null)
		{
			System.err.println("COULD NOT FIND TAB WITH THAT TITLE");
		}
		else
		{
			tab.click();
		}
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
	
	@FindBy(xpath="//div[@id='block-daip-responsive-questionnaire-responsive-questionnaire-block']")
	private WebElementFacade questionnaire;
	
	public boolean questionnaireIsDisplayed()
	{
		return questionnaire.isDisplayed();
	}
}
