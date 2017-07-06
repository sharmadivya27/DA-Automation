package gov.disasterassistance.daip.test.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/*************************************************************************
 * Using Selenium Webdriver, this class handles web related code such as pulling
 * elements from the given site.
 *
 * @author Chris Viqueira
 * @author Divya Sharma
 *************************************************************************/
public class DAPage extends PageObject {

	/*********************************************/

	@FindBy(xpath = "logo")
	private WebElementFacade homeLogo;

	public void clickIcon() {
		homeLogo.click();
	}

	public String shouldSeeHome() {
		return this.getTitle();
	}

	/*********************************************/

	private String env = System.getProperty("environment");
	public String defaultUrl = "http://" + env + ".disasterassistance.gov";

	public DAPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize(); 
		//driver.manage().window().setSize(new Dimension(500, 500));
		this.setImplicitTimeout(10, TimeUnit.SECONDS); 
	} 

	public void clearCookies() {
		this.getDriver().manage().deleteAllCookies();
	}
}