package gov.disasterassistance.daip.test.pageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import gov.disasterassistance.daip.test.exceptions.BenefitCountException;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DAFederalAgency extends PageObject {

	@FindBy(xpath = "//ul[@class='expand-collapse']/li")
	List<WebElementFacade> federalAgencyAccordions;

	// *************************************************************************
	// Functions

	/*************************************************************************
	 * Returns the element that correlates with the parameter provided from the
	 * list of all of the questionnaire buttons.
	 * 
	 * @param federalAgencyName
	 *            : The name of the agency to be returned
	 *************************************************************************/
	public WebElementFacade getFederalAgency(String federalAgencyName) {
		Iterator<WebElementFacade> iter = federalAgencyAccordions.iterator();
		WebElementFacade accordion = null;
		while (iter.hasNext()) {
			WebElementFacade temp = iter.next();
			if (temp.containsText(federalAgencyName)) {
				accordion = temp;
				break;
			}
		}
		return accordion;
	}

	/*************************************************************************
	 * Iterates through each Federal Agency and verifies that the number of
	 * benefits displayed correlates with its respective benefit counter.
	 * 
	 *************************************************************************/
	public void checkFederalBenefits() throws BenefitCountException {
		Iterator<WebElementFacade> federalAgencyIter = federalAgencyAccordions.iterator();
		while (federalAgencyIter.hasNext()) {
			WebElementFacade federalAgency = federalAgencyIter.next();
			String departmentNameAndBenefits = federalAgency.getText();
			String departmentName = departmentNameAndBenefits.substring(0, departmentNameAndBenefits.length() - 2)
					.trim();
			int benefitCount = Integer
					.parseInt(departmentNameAndBenefits.substring(departmentNameAndBenefits.length() - 2).trim());

			List<WebElement> benefits = this.getDriver().findElements(By.xpath("//div[@class='accordion-name-text' and "
					+ "text()[contains(., '" + departmentName + "')]]/../../ul//li"));

			if (benefits.size() != benefitCount) {
				throw new BenefitCountException("Incorrect number of benefits");
			}
		}
	}

}