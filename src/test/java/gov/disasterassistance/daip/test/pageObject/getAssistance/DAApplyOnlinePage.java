package gov.disasterassistance.daip.test.pageObject.getAssistance;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/DAC/govBenefitReceiver.do?gbsessionid=0&action=RI&langcode=EN")
public class DAApplyOnlinePage extends PageObject{

		public DAApplyOnlinePage(WebDriver driver) {
			super(driver);
		}
}
