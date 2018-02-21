package no.hvl.dat102.oppg7.Queue;

import no.hvl.dat102.oppg7.ADT.QueueADT;

public class CircularQueue<T> implements QueueADT<T> {

	private final static int STDK = 100;
	private int start, end, qty;
	private T[] queue;

	public CircularQueue() {
		this(STDK);
	}

	public CircularQueue(int startKapasitet) {
		start = end = qty = 0;
		queue = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public void enqueue(T element) {
		if (size() == queue.length) {
			utvid();
		}
		queue[end] = element;
		end = (end + 1) % queue.length;

		qty++;
	}

	private void utvid() {
		T[] ny = (T[]) (new Object[queue.length * 2]);

		for (int i = 0; i < qty; i++) {
			ny[i] = queue[start];
			start = (start + 1) % queue.length;
		}
		start = 0;
		end = qty;
		queue = ny;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			return null;
		}

		T resultat = queue[start];
		queue[start] = null;
		start = (start + 1) % queue.length;

		qty--;

		return resultat;
	}

	@Override
	public T firstElement() {
		return queue[start];
	}

	@Override
	public boolean isEmpty() {
		return queue[start] == null;
	}

	@Override
	public int size() {
		return qty;
	}
}
