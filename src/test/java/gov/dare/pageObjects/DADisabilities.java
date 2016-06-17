package gov.dare.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/information/disabilities-access-and-functional-needs")
public class DADisabilities extends PageObject {

	public DADisabilities(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

}
