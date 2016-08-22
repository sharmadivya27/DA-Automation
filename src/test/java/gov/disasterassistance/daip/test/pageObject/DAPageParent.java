package gov.disasterassistance.daip.test.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class DAPageParent extends PageObject {

//	private final String pageTitle = "Home | DisasterAssistance.gov | Access to Disaster Help and Resources";
	
	public DAPageParent(WebDriver driver){
		super(driver);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	public String getPageTitle() {
		return this.getDriver().getTitle();
	}

	public void openTestPage() {
		this.getDriver().get("https://www.disasterassistance.gov");
	}
}
