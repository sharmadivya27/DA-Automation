package gov.disasterassistance.daip.test.exceptions;

public class BenefitCountException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BenefitCountException() {
		super();
	}
	public BenefitCountException(String message) {
		super(message);
	}
}
