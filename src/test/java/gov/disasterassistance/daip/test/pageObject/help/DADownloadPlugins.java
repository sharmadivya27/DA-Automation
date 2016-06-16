package gov.disasterassistance.daip.test.pageObject.help;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/help/download-plug-ins")
public class DADownloadPlugins extends PageObject {

	public DADownloadPlugins(WebDriver driver) {
		super(driver);
	}

}
