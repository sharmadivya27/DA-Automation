package gov.disasterassistance.daip.test.pageObject;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObjects;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.disasterassistance.gov")
public class DAHomePage extends PageObjects{

	public DAHomePage(WebDriver driver) {
		super(driver);
	}
	
}
