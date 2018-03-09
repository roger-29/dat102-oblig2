package no.hib.dat102.medlem;

public class Datakontakt {

	private final static int STANDARD = 100;
	private Medlem[] Tab;
	private int antallM;
	
	public Datakontakt() {
		Tab = new Medlem[STANDARD];
		antallM = 0;
	}
	
	public Medlem[] getMedlemsTabell() {
		return Tab;
	}
	
	public void leggTilMedlem(Medlem person) {
		for(int i = 0; i < antallM; i++) {
			if(Tab[i].equals(person))
				return;
		}
		
		Tab[antallM] = person;
		antallM++;
	}
	
	
	public int getStørrelse() {
		return antallM;
	}
	
	public Medlem getMedlem(String medlemsNavn) {
		int m = finnMedlemsIndeks(medlemsNavn);
		Medlem med = null;
		if(m != -1)
			med = Tab[m];
		
		return med;
	}
	
	public int finnMedlemsIndeks(String medlemsNavn) {
		boolean funnet = false;
		int indeks = -1;
		for(int i = 0; i < Tab.length && !funnet; i++) {
			if(Tab[i].getNavn().equals(medlemsNavn)) {
				funnet = true;
				indeks = i;
			}
		}
			
		return indeks;
	}
	
	public int finnPartnerFor(String medlemsNavn) {
		boolean funnet = false;
		int m1 = finnMedlemsIndeks(medlemsNavn);
		int m2 = -1;
		int indeks = -1;
		for(int i = 0; i < antallM && !funnet; i++) {
			m2 = i;
			if((Tab[m2].passerTil(Tab[m1]) && Tab[m2].getStatusIndeks() == -1) && m1 != m2) {
				Tab[m2].setStatusIndeks(m1);
				Tab[m1].setStatusIndeks(m2);
				indeks = m2;
				funnet = true;
			}
		}
		return indeks;
	}
	
	public void tilbakeStillStatusIndeks(String medlemsNavn) {
		int m1 = finnMedlemsIndeks(medlemsNavn);
		int m2 = Tab[m1].getStatusIndeks();
		if(m2 != -1) {
			Tab[m1].setStatusIndeks(-1);
			Tab[m2].setStatusIndeks(-1);
		}
	}
	
	
}
