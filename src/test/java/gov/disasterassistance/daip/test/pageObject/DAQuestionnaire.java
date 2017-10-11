package gov.disasterassistance.daip.test.pageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import gov.disasterassistance.daip.test.exceptions.EmploymentException;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DAQuestionnaire extends PageObject {

	// *************************************************************************
	// FindBy / private variables section

	DAHomepage daHomepage;

	@FindBy(xpath = "//fieldset//label[@class[contains(., 'radio')] and text()[not(contains(., 'No')) and not(contains(., 'Unknown'))]]")
	private List<WebElementFacade> questionnaireButtons;

	@FindBy(id = "stateSelector")
	private WebElementFacade stateSelector;

	@FindBy(xpath = "//div[@class='foatoolbar-plusminus']")
	private WebElementFacade expandAllButton;

	@FindBy(xpath = "//*[@id='benefit-counter-count']")
	private WebElementFacade benefitCounter;

	@FindBy(xpath = "//div[@class='foatoolbar-minus']")
	private WebElementFacade collapseAllButton;

	@FindBy(xpath = "//div[@class='foaccordionable open']")
	private List<WebElementFacade> FOAExpandedResults;

	@FindBy(xpath = "//div[@class='foa-result-wrapper auto-foas']/div//h2/span[not(@class='chevron')]")
	private List<WebElementFacade> autoFOAs;

	@FindBy(xpath = "//div[@class='foaccordionable']")
	private List<WebElementFacade> FOAResults;

	@FindBy(xpath = "//*[@class[contains(., 'qButton') and not(contains(., 'session'))]]")
	private List<WebElementFacade> FOAfooter;

	@FindBy(xpath = "//div[@class='accordionable' and @id]")
	private List<WebElementFacade> FOAChecklistAccordions;

	@FindBy(xpath = "//*[@id='pageContent']")
	private WebElementFacade checkStatusPageContent;

	@FindBy(xpath = "//span[contains(., 'Disaster Assistance Center') or contains(.,'Centro de Asistencia por Desastre')]")
	private WebElementFacade dacPage;

	// *************************************************************************
	// Functions

	/*************************************************************************
	 * Completes the entire FOA questionnaire checking every box, saying yes to
	 * every question, and picking a state.
	 * 
	 *************************************************************************/
	public void completeFullQuestionnaire() {
		daHomepage.pause(8000);
		Iterator<WebElementFacade> iter = questionnaireButtons.iterator();
		while (iter.hasNext()) {
			WebElementFacade temp = iter.next();
			temp.click();
			this.evaluateJavascript("window.scrollBy(0,50)", "");
		}
		stateSelector.sendKeys("Alabama");
		this.evaluateJavascript("window.scrollBy(0,50)", "");
		//////////// getResultsButton.click();
	}

	/*************************************************************************
	 * Clicks an individual element from the list of all of the questionnaire
	 * buttons.
	 * 
	 * @param buttonName
	 *            : The name of the element to be clicked
	 *************************************************************************/
	// TODO still doesn't distinguish between the yes buttons, just looks at the
	// text by the clickable button
	private WebElementFacade getQuestionnaireButton(String buttonName) {
		Iterator<WebElementFacade> iter = questionnaireButtons.iterator();
		WebElementFacade btn = null;
		while (iter.hasNext()) {
			WebElementFacade temp = iter.next();
			if (temp.containsText(buttonName)) {
				btn = temp;
				break;
			}
		}
		return btn;
	}

	public int getNumEmploymentResults() {
		return FOAExpandedResults.size();
	}

	/*************************************************************************
	 * Verifies that Employment results and content are visible and appear under
	 * the accordions.
	 * 
	 * @throws EmploymentException
	 * 
	 *************************************************************************/
	public void verifyEmploymentVisibility() throws EmploymentException {
		Iterator<WebElementFacade> FOAResultsIter = FOAResults.iterator();
		Iterator<WebElementFacade> FOAExpandedResultsIter = FOAExpandedResults.iterator();
		while (FOAResultsIter.hasNext() && FOAExpandedResultsIter.hasNext()) {
			WebElementFacade result = FOAResultsIter.next();
			WebElementFacade expandedResult = FOAExpandedResultsIter.next();
			if (!result.isVisible() || !expandedResult.isVisible()) {
				throw new EmploymentException("Employment results not visible");
			}
		}
	}

	/*************************************************************************
	 * Returns the number of FOAs that match with the expected list.
	 * 
	 * @return Number of FOA titles that match with the given list
	 *************************************************************************/
	public int getNumAdditionalFOA() {
		String[] additionalFOATitles = {
				"203(h) Mortgage Insurance for Disaster Victims and 203(k) Rehabilitation Mortgage Insurance",
				"FEMA Disaster Recovery Center (DRC) / DRC Locator",
				"International Terrorism Victim Expense Reimbursement Program (ITVERP)",
				"Savings Bond Redemption and Replacement", "State Crime Victims Compensation",
				"Substance Abuse and Mental Health Services Administration (SAMHSA) Disaster Relief Information" };

		int foaCounter = 0;

		Iterator<WebElementFacade> iter = autoFOAs.iterator();
		while (iter.hasNext()) {
			String foaTitle = iter.next().getText();
			for (int i = 0; i < additionalFOATitles.length; i++) {
				if (additionalFOATitles[i].equals(foaTitle)) {
					foaCounter++;
					break;
				}
			}
		}

		return foaCounter;
	}

	/*************************************************************************
	 * Returns the number of FOAs that match with the expected list.
	 * 
	 * @return Number of FOA titles that match with the given list
	 *************************************************************************/
	public int getNumAdditionalSpanishFOA() {
		String[] additionalFOATitles = { "Centros de Recuperación de Desastres de FEMA (DRC) / Localizador de DRC",
				"Indemnización Estatal para Víctimas del Crimen",
				"Información de Asistencia para Desastres de la Administración de Servicios para el Abuso de Sustancias y Enfermedades Mentales (SAMHSA)",
				"Programa de Reembolso de Gastos a las Víctimas del Terrorismo Internacional (ITVERP, por sus siglas en inglés)",
				"Reemplazo y Liquidación de Bonos de Ahorros",
				"Seguro Hipotecario para Víctimas de Desastres - Sección 203(h) y Seguro Hipotecario para Rehabilitación - Sección 203(k)" };

		int foaCounter = 0; 

		Iterator<WebElementFacade> iter = autoFOAs.iterator();
		while (iter.hasNext()) {
			String foaTitle = iter.next().getText();
			for (int i = 0; i < additionalFOATitles.length; i++) {
				if (additionalFOATitles[i].equals(foaTitle)) {
					foaCounter++;
					break;
				}
			}
		}

		return foaCounter;
	}

	/*************************************************************************
	 * Expands and collapses individual FOAs while also making sure the content
	 * is displayed in each.
	 * 
	 * @return The number of FOAs it clicked and checked for content
	 *************************************************************************/
	// TODO Clean this up somehow in the future
	// Find a way around using multiple thread.sleeps?
	public int clickIndividualFOAs() {

		int successCounter = 0;
		Iterator<WebElementFacade> foaIter = FOAResults.iterator();
		while (foaIter.hasNext()) {
			WebElementFacade foa = foaIter.next();
			System.out.println(foa.getText());
			// TODO find a better and more succinct way to write this
			this.evaluateJavascript("window.scrollTo(0," + foa.getLocation().getY() + "); "
					+ "window.scrollBy(0, -(window.screen.availHeight / 2))");

			try {
				foa.click();
			} catch (Exception e) {
				this.evaluateJavascript("window.scrollTo(0,document.body.scrollHeight)"); // scroll
																							// to
				foa.click();
			}

			daHomepage.pause(1000);

			if (successCounter == 73) {
				break;
			}

			WebElement openContent = this.getDriver().findElement(
					By.xpath("//div[@class='foaccordionable open']/.." + "/div[@style[not(contains(., 'none'))]]"));

			if (openContent.isDisplayed()) {
				successCounter++;
			}

			foa.click();

			daHomepage.pause(1000);
		}

		return successCounter;
	}

	/*************************************************************************
	 * Returns true if you can see both of the buttons on the footer of the FOA
	 * questionnaire page. Currently it is only looking for the next and back
	 * buttons
	 * 
	 * @return true if the next and back buttons are visible
	 *************************************************************************/
	public boolean foaFooterIsVisible() {
		Iterator<WebElementFacade> iter = FOAfooter.iterator();
		int textMatchCounter = 0;

		while (iter.hasNext()) {
			if (iter.next().isDisplayed()) {
				textMatchCounter++;
			}
		}

		return (textMatchCounter == 2 || textMatchCounter == 1);
	}

	public List<WebElement> getFOAFooter() {
		return this.getDriver()
				.findElements(By.xpath("//*[@class[contains(., 'qButton') and not(contains(., 'session'))]]"));
	}

	public void clickNextFOA() {
		List<WebElement> footer = getFOAFooter();
		footer.get(footer.size() - 1).click();
	}

	/*************************************************************************
	 * Opens and closes each accordion on the final page of the questionnaire
	 * and returns the number of content sections it could see
	 * 
	 * @return number of content sections visible
	 *************************************************************************/
	public int numApplyOnlineFOAs() {
		Iterator<WebElementFacade> iter = FOAChecklistAccordions.iterator();
		int contentCounter = 0;

		while (iter.hasNext()) {
			WebElementFacade accordion = iter.next();

			if (accordion.isDisplayed()) {
				contentCounter++;
			}

		}

		return contentCounter;

	}

	public void clickEmploymentCheckbox() {
		daHomepage.pause(8000);
		this.evaluateJavascript("window.scrollBy(0,50)", "");
		getQuestionnaireButton("Employment").click();
	}

	public void clickSpanishEmploymentCheckbox() {
		daHomepage.pause(8000);
		this.evaluateJavascript("window.scrollBy(0,50)", "");
		getQuestionnaireButton("Empleo").click();
	}

	public void getFOAResultsPage() {
		benefitCounter.click();
	}

	public void expandFOAResults() {
		expandAllButton.click();
	}

	public int getNumQuestionnaireResults() {
		return FOAResults.size();
	}

	public int getResultsVal() {
		int i = Integer.parseInt(benefitCounter.getText());
		return i;
	}

	public void collapseFOAResults() {
		collapseAllButton.click();
	}

	public int getNumExpandedQuestionnaireResults() {
		return FOAExpandedResults.size();
	}

	public void clickApplyOnline() {
		FOAfooter.get(FOAfooter.size() - 1).click();
	}

	public boolean checkStatusPageIsDisplayed() {
		return checkStatusPageContent.isDisplayed();
	}

	public boolean dacPageIsDisplayed() {
		return dacPage.isDisplayed();
	}
}
