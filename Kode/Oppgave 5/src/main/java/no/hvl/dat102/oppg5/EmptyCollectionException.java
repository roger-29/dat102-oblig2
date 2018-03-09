package no.hvl.dat102.oppg5;

public class EmptyCollectionException extends RuntimeException{

	
	public EmptyCollectionException(String collection) {
		super("The " + collection + " is empty.");
	}
	
	
}
