package no.hvl.dat102.oppg5;

public class NotAnOperandStackException extends RuntimeException{
	
	public NotAnOperandStackException(String operand) {
		super(operand);
	}
	
	public void runThread() {
		System.out.println(Thread.currentThread().getStackTrace());
	}

}
