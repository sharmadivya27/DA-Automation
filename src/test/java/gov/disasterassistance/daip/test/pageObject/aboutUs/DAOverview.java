package gov.disasterassistance.daip.test.pageObject.aboutUs;


import org.openqa.selenium.WebDriver;

import gov.disasterassistance.daip.test.pageObject.DAPageParent;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/about-us/overview")
public class DAOverview extends DAPageParent {

//	private final String pageTitle = "Overview | DisasterAssistance.gov";
	
	public DAOverview(WebDriver driver) {
		super(driver);
	}

}
