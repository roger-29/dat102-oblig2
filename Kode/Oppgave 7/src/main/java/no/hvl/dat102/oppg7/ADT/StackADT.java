package no.hvl.dat102.oppg7.ADT;

import java.util.EmptyStackException;

public interface StackADT<T> {
	boolean push(T element);

	boolean pop() throws EmptyStackException;

	T getFirst();

	T getLast();

	boolean find();

	boolean isEmpty();

	int size();

	String toString();
}
