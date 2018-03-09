package no.hvl.dat102.oppg4.tabell;

import no.hvl.dat102.oppg4.adt.OrdnetListeADT;
import java.util.Arrays;

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
	public void leggTil(T element) {
		liste[bak] = element;
		bak++;
		Arrays.sort(liste, 0, bak);
	}

	@Override
	public T fjernSiste() {
		bak--;
		return liste[bak];
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		int indeks = 0;

		if (erTom()) return null;

		resultat = liste[0];

		while (indeks < bak - 1) {
			liste[indeks] = liste[indeks + 1];
			indeks++;
		}

		bak--;

		return resultat;
	}

	@Override
	public T fjern(T element) {
		T el = null;

		int indeks = finn(element);

		if (indeks != IKKE_FUNNET) {
			el = liste[indeks];
			while (indeks < bak - 1) {
				liste[indeks] = liste[indeks + 1];
				indeks++;
			}
			bak--;
		}

		return el;
	}		

	private int finn(T el) {
		for (int i = 0; i < bak; i++) {
			if (liste[i].equals(el)) {
				return i;
			}
		}

		return IKKE_FUNNET;
	}

    @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()) resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		if (!erTom()) resultat = liste[bak];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}

		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}
