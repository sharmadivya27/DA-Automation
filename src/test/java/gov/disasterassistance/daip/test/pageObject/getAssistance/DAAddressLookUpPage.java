package gov.disasterassistance.daip.test.pageObject.getAssistance;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/address-lookup")
public class DAAddressLookUpPage extends PageObject{
	
		public DAAddressLookUpPage(WebDriver driver) {
			super(driver);
		}
}
