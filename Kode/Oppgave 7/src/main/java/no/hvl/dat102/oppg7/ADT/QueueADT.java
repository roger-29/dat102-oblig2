package no.hvl.dat102.oppg7.ADT;

public interface QueueADT<T> {
	void enqueue(T element);

	T dequeue();

	T firstElement();

	boolean isEmpty();

	int size();

	String toString();
}
