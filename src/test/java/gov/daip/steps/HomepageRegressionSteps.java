package gov.daip.steps;

import net.thucydides.core.annotations.Step;

public class HomepageRegressionSteps {

	@Step
	public void clickExample(String name) {
		System.out.println("clicked on" + name);
	}
}
