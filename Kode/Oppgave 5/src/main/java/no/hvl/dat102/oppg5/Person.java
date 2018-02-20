package no.hvl.dat102.oppg5;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int fodselsaar;

	public Person() {
		this.fornavn = "Ola";
		this.etternavn = "Nordmann";
		this.fodselsaar = 1970;
	}

	public Person(String fornavn, String etternavn, int fodselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
	}

	public String getFornavn() {
		return this.fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodselsaar() {
		return this.fodselsaar;
	}

	public void setFodselsaar(int fodselsaar) {
		this.fodselsaar = fodselsaar;
	}

	@Override
	public int compareTo(Person denAndre) {
		if (this.getFodselsaar() > denAndre.getFodselsaar()) {
			return 1;
		} else if (this.getFodselsaar() < denAndre.getFodselsaar()) {
			return -1;
		} else if (this.getFodselsaar() == denAndre.getFodselsaar()) {
			if (this.getEtternavn() < denAndre.getEtternavn()) {
				return 1;
			} else if (this.getEtternavn() > denAndre.getEtternavn()) {
				return -1;
			} else if (this.getEtternavn() == denAndre.getEtternavn()) {
				if (this.getFornavn() < denAndre.getFornavn()) {
					return 1;
				} else if (this.getFornavn() > denAndre.getFornavn()) {
					return -1;
				} else if (this.getFornavn() == denAndre.getFornavn()) {
					return 0;
				}
			}
		}
	}

	@Override
	public String toString() {
		return this.getEtternavn() + ", " + this.getFornavn() + ", " + this.getFodselsaar() + "\n";
	}
}
