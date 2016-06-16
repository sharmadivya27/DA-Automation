package gov.disasterassistance.daip.test.pageObject.getAssistance;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/get-assistance/forms")
public class DAFormsPage extends PageObject {

	public DAFormsPage(WebDriver driver) {
		super(driver);
	}

}
