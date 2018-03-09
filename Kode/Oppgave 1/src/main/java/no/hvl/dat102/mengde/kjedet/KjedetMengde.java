package no.hvl.dat102.mengde.kjedet;

import java.util.*;
import no.hvl.dat102.mengde.adt.*;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		}
		return resultat;
	}

	@Override
	public T fjern(T element) {
		LinearNode<T> forgjenger = start, aktuell = start;

		if (!inneholder(element)) return null;

		while (aktuell != null) {
			if (aktuell.getElement().equals(element)) {

				if (aktuell.equals(forgjenger))	{
					start = start.getNeste();
				} else {
					forgjenger.setNeste(aktuell.getNeste());
				}
				
				antall--;
				return element;

			} else {
				forgjenger = aktuell;
				aktuell = aktuell.getNeste();
			}
		}
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new KjedetMengde<T>();
		T element = null;
		
		Iterator<T> itr1 = this.oppramser();
		Iterator<T> itr2 = m2.oppramser();

		while(itr1.hasNext()) {
			((KjedetMengde<T>)mengde).settInn(itr1.next());
		}

		while(itr2.hasNext()) {
			element = itr2.next();
			if(!mengde.inneholder(element)) {
				((KjedetMengde<T>)mengde).settInn(element);
			}
		}

		return mengde;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new KjedetMengde<T>();
		T element;

		Iterator<T> itr = m2.oppramser();

		while(itr.hasNext()) {
			element = itr.next();
			if (this.inneholder(element))		 
				((KjedetMengde<T>)mengde).settInn(element);
		}

		return mengde;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> mengde = new KjedetMengde<T>();
		T element;
		
		Iterator<T> itr = this.oppramser();
		
		while(itr.hasNext()) {
			element = itr.next();
			if(!m2.inneholder(element))
				((KjedetMengde<T>)mengde).settInn(element);
		}

		return mengde;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		Iterator<T> itr = m2.oppramser();
		
		if (antall() != m2.antall()) return false;
		
		while(itr.hasNext()) {
			if (!inneholder(itr.next())) {
				return false;
			}
		}
		
		return true;
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
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return erUnderMengde;
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
}
