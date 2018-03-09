package no.hvl.dat102.oppg5;

public class KjedetKø<T> implements KøADT<T>
{

	private int count;
	private LinearNode<T> head,tail;
	
	public KjedetKø() {
		count = 0;
		head = tail = null;
	}

	@Override
	public void enqueue(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		
		if (isEmpty())
			head = node;
		else
			tail.setNext(node);
		
		tail = node;
		count++;
	}


	public T dequeue() throws EmptyCollectionException{
		
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		
		T result = head.getElement();
		head = head.getNext();
		count--;	
			
		if(isEmpty())
			tail = null;
			
		return result;
	}

	
	public T first() {
		return head.getElement();
	}

	public boolean isEmpty() {
		boolean empty = false;
		
		if (count == 0)
			empty = true;
		
		return empty;
	}


	public int size() {
		return count;
	}
	
	public String toString() {
		LinearNode<T> temp = head;
		String rString = "";
		for(int i = 0; i < count; i++) {
			rString += temp.getElement().toString() + "\n";
			temp = temp.getNext();
		}
		return rString;
	}
	
}
