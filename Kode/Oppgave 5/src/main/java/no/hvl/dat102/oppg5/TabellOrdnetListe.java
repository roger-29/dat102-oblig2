package no.hvl.dat102.oppg5;

public class TabellOrdnetListe<T> extends TabellListe<T> implements OrdnetListeADT<T>{

	public TabellOrdnetListe() {
		super();
	}

	@Override
	public void leggTil(T element) {
		
		if(!(element instanceof Comparable))

			throw new NonComparableElementException("OrderedList");

		
		Comparable<T> comparableElement = (Comparable<T>)element;
		
		if(size() == list.length)
			expandCapacity();
		int scan = 0;
		

		while (scan < rear && comparableElement.compareTo(list[scan]) > 0)

			scan++;
		
		for(int shift = rear; shift > scan; shift--)
			list[shift] = list[shift-1];
		
		list[scan] = element;
		rear++;
		modCount++;
		
	}
	
	private void expandCapacity() {

		T[] newList = (T[])(new Object[list.length * 2]);
		for(int i = 0; i < list.length; i++)
			newList[i] = list[i];
		
		list = newList;

	}
	
	
	
	
}
