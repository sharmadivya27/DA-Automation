package gov.disasterassistance.daip.test.exceptions;

public class BenefitCountException extends Exception {
	
	private static final long serialVersionUID = 7743230607846503584L;
	public BenefitCountException() {
		super();
	}
	public BenefitCountException(String message) {
		super(message);
	}
}
