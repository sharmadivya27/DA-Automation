package gov.disasterassistance.daip.test.pageObject.help;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/help/privacy-policy")
public class DAPrivacyPolicy extends PageObject {

	public DAPrivacyPolicy(WebDriver driver) {
		super(driver);
	}

}
