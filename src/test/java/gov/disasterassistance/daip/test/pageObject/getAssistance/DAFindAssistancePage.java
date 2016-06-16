package gov.disasterassistance.daip.test.pageObject.getAssistance;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/get-assistance/find-assistance")
public class DAFindAssistancePage extends PageObject {

	public DAFindAssistancePage(WebDriver driver) {
		super(driver);
	}
}
