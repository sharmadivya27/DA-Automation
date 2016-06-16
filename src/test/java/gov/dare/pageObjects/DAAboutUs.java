package gov.dare.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.disasterassistance.gov/about-us")
public class DAAboutUs extends PageObject {

	public DAAboutUs(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

}
