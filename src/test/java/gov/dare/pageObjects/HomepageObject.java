package gov.dare.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("http://www.disasterassistance.gov")
public class HomepageObject extends PageObject 
{
	/**
	 * Not sure if you really need constructor but keeping it in since Serenity manual uses this 
	 */
	public HomepageObject (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//nav[@id='nav']/ul/li[@class[contains(., 'menu__item')]]")
	private List<WebElementFacade> mainNavMenu;
	final class NavMenuItem {	//struct like object to reference the navbar web objects stored in "mainNavBar" by name
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
	@Step
	public void clickOnNavigationMenu(String menuItem)
	{
		switch(menuItem)
		{
		case "home":
		{
			mainNavMenu.get(NavMenuItem.home).click();
		} break;
		case "get_assistance":
		{
			mainNavMenu.get(NavMenuItem.getAssistance).click();
		} break;
		case "information":
		{
			mainNavMenu.get(NavMenuItem.information).click();
		} break;
		case "about_us":
		{
			mainNavMenu.get(NavMenuItem.aboutUs).click();
		} break;
		case "help":
		{
			mainNavMenu.get(NavMenuItem.help).click();
		} break;
		default:
		{
			//TODO better error checking
			System.err.println("ERROR: something weird got passed in from scenario 1 in dailyRegression.story");
		} break;

		} // end switch
	}
}
