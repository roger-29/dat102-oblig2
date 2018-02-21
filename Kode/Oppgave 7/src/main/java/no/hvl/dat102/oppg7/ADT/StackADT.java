package no.hvl.dat102.oppg7.ADT;

public interface StackADT<T> {
	boolean push(T element);

	boolean pop();

	T getFirst();

	T getLast();

	boolean find();

	boolean isEmpty();

	int size();

	String toString();
}
