package no.hvl.dat102.oppg5;

public class SirkulærKø<T> implements KøADT<T>{

	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;
	
	public SirkulærKø() {
		this(DEFAULT_CAPACITY);
	}
	
	public SirkulærKø(int capacity) {
		front = rear = count = 0;
		queue = (T[])(new Object[DEFAULT_CAPACITY]);
	}

	@Override
	public void enqueue(T element) {

		if(size() == queue.length)
			expandCapacity();
		
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	@Override
	public T dequeue() throws EmptyCollectionException{
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		
		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;
		
		return result;
	}


	public T first() {
		return queue[front];
	}

	
	public boolean isEmpty() {
		boolean empty = false;
		if(count == 0)
			empty = true;
		return empty;
	}


	public int size() {
		return count;
	}
	
	public String toString() {
		String rString = "";
		int c = front;
		for (int i = 0; i < count; i++) {
			rString += queue[c].toString() + "\n";
			c = (c + 1) % queue.length;
		}
		return rString;
	}
	
	private void expandCapacity() {
		
		T[] larger = (T[])(new Object[queue.length * 2]);
		
		for (int i = 0; i < count; i++) {
			larger[i] = queue[front];
			front = (front + 1) % queue.length;
		}
		
		front = 0;
		rear = count;
		queue = larger;
	}
	
}
