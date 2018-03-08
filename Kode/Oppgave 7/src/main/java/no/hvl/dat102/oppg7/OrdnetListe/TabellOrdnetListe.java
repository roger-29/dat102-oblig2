package no.hvl.dat102.oppg7.OrdnetListe;

import no.hvl.dat102.oppg7.ADT.SortedListADT;

public class TabellOrdnetListe<T> implements SortedListADT<T> {

	private int qty;
	private T[] tab;

	public TabellOrdnetListe() {
		this(1000);
	}

	public TabellOrdnetListe(int size) {
		this.tab = ((T[]) new Object[size]);
		this.qty = 0;
	}

	@Override
	public void add(T element) {

	}

	@Override
	public void remove(T element) {

	}
}
