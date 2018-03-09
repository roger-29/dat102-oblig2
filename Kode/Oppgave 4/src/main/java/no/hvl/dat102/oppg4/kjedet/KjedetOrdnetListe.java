package no.hvl.dat102.oppg4.kjedet;

import no.hvl.dat102.oppg4.adt.*;

/**
 * 
 * @param <T> elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;

		if (!erTom()) {
			svar = foerste.getElement();
			foerste = foerste.getNeste();
			antall--;
			return svar;
		}

		return null;
	}

	@Override
	public T fjernSiste() {
		T svar = null;

		if (erTom()) return null;

		svar = siste();
		antall--;

		if (antall() == 1) {
			foerste = siste = null;
			return svar;
		}

		if (antall() == 2) {
			siste = foerste;
			foerste.setNeste(null);
			return svar;
		}

		LinearNode<T> denne = foerste;

		for (int i = 0; i < antall() - 1; i++) {
			denne = denne.getNeste();
		}

		denne.setNeste(null);
		siste = denne;
		
		return svar;
	}

	@Override
	public T foerste() {
		if (erTom()) return null;
		
		return foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom()) return null;
		
		return siste.getElement();
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		if (!(element instanceof Comparable)) {
			System.out.println("Kan ikke legge til elementer som ikke er Comparable.");
			return;
		}

		Comparable<T> comparableElement = (Comparable<T>) element;

		LinearNode<T> nyNode = new LinearNode<T>(element);
		

		if (antall() == 0) {
			foerste = siste = nyNode;
			antall++;
			return;
		}

		if (antall() == 1) {
			if (comparableElement.compareTo(foerste.getElement()) > 0) {
				foerste.setNeste(nyNode);
				siste = nyNode;
			} else {
				nyNode.setNeste(foerste);
				siste = foerste;
				foerste = nyNode;
			}
			antall++;
			return;
		}


		LinearNode<T> current = foerste;

		int indeks = 0;
		while ((indeks < antall() - 1) && (element.compareTo(current.getElement()) > 0)) {
			current = current.getNeste();
			indeks++;
		}

		if (indeks == 0) {
			nyNode.setNeste(current);
			foerste = nyNode;
		} else if (indeks == antall()) {
			siste.setNeste(nyNode);
			siste = nyNode;
		} else {
			nyNode.setNeste(current);
			//previous.setNeste(nyNode);
		}
		
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}
