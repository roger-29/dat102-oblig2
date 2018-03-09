package no.hvl.dat102.oppg5;

public class NonComparableElementException extends RuntimeException{


	public NonComparableElementException(String element) {
		super("The " + element + " is not comparable");
	}

}
