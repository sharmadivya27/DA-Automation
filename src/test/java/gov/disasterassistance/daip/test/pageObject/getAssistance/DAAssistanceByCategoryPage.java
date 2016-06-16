package gov.disasterassistance.daip.test.pageObject.getAssistance;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/get-assistance/assistance-by-category")
public class DAAssistanceByCategoryPage extends PageObject {
	
	public DAAssistanceByCategoryPage (WebDriver driver) {
		super(driver);
	}
}
