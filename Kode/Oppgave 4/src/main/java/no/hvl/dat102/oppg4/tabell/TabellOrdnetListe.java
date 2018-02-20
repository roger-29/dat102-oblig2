package no.hvl.dat102.oppg4.tabell;

import no.hvl.dat102.oppg4.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() { // Gjort selv
		T resultat = liste[bak - 1];
		liste[bak - 1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		//... Fyll ut
		return resultat;
	}

     @Override
	public T foerste() {
		return !erTom() ? liste[0] : null;
	}

	@Override
	public T siste() {
		return !erTom() ? liste[bak - 1] : null;
	}

	@Override
	public boolean erTom() {
		return bak == 0;
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
    	   	
		//...Fyll ut
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		// ...Fyll ut
		return element;
		
	}		

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		//...Fyll ut
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}
}
