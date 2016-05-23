package gov.dare.pageObjects;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("http://www.disasterassistance.gov")
public class HomepageObject extends PageObject 
{
	@FindBy(linkText="home")
	WebElementFacade mainNavBar;
	
	public HomepageObject (WebDriver driver)
	{
		super(driver);
	}
	
	@Step
	public void clickOnHome()
	{
		mainNavBar.click();
	}
}
