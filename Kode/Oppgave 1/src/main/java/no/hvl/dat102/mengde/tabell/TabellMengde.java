package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.*;

import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}


	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element. Retur med null ved ikke-funn
		for (int i = 0; i < this.antall; i++) {
			if (tab[i].equals(element)) {
				T svar = tab[i];
				tab[i] = tab[antall - 1];
				antall--;
				return svar;
			}
		}
		
		return null;
	}

	/* Lite effektiv!
		@Override
		public MengdeADT<T> union(MengdeADT<T> m2) {
			TabellMengde<T> begge = new TabellMengde<T>();
			for (int i = 0; i < antall; i++) {
				begge.leggTil(tab[i]);
			}
			Iterator<T> teller = m2.oppramser();
	
			while (teller.hasNext()) {
				begge.leggTil(teller.next());
			}
			return (MengdeADT<T>)begge;
		}
		*/

	
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new TabellMengde<T>();
		T element = null;
		
		Iterator<T> itr1 = this.oppramser();
		Iterator<T> itr2 = m2.oppramser();

		while(itr1.hasNext()) {
			((TabellMengde<T>)mengde).settInn(itr1.next());
		}

		while(itr2.hasNext()) {
			element = itr2.next();
			if(!mengde.inneholder(element)) {
				((TabellMengde<T>)mengde).settInn(element);
			}
		}
		
		return mengde;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new TabellMengde<T>();
		T element = null;
		
		Iterator<T> itr = m2.oppramser();

		while(itr.hasNext()) {
			element = itr.next();
			if (this.inneholder(element))		 
				((TabellMengde<T>)mengde).settInn(element);
		}

		return mengde;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new TabellMengde<T>();
		T element;

		Iterator<T> itr = this.oppramser();
		
		while(itr.hasNext()) {
			element = itr.next();
			if(!m2.inneholder(element))
				((TabellMengde<T>)mengde).settInn(element);
		}

		return mengde;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		if (this.antall() == m2.antall()) {
			for (int i = 0; i < this.antall(); i++) {
				if (!m2.inneholder(this.tab[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}
}
