package no.hvl.dat102.oppg7;

public class Jobb implements Comparable<Jobb> {

	private int nr;
	private int ankomsttid;
	private int kjoretidKrav;
	private int ferdigtid;

	public Jobb() {
		this(0, 0, 0, 0);
	}

	public Jobb(int nr, int ankomsttid, int kjoretidKrav, int ferdigtid) {
		this.nr = nr;
		this.ankomsttid = ankomsttid;
		this.kjoretidKrav = kjoretidKrav;
		this.ferdigtid = ferdigtid;
	}

	public int getNr() {
		return this.nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public int getAnkomsttid() {
		return this.ankomsttid;
	}

	public void setAnkomsttid(int ankomsttid) {
		this.ankomsttid = ankomsttid;
	}

	public int getKjoretidKrav() {
		return this.kjoretidKrav;
	}

	public void setKjoreTidKrav(int kjoretidKrav) {
		this.kjoretidKrav = kjoretidKrav;
	}

	public int getFerdigtid() {
		return this.ferdigtid;
	}

	public void setFerdigtid(int ferdigtid) {
		this.ferdigtid = ferdigtid;
	}

	public int getVentetid() {
		return (this.getFerdigtid() - this.getAnkomsttid()) - this.getKjoretidKrav();
	}

	@Override
	public int compareTo(Jobb o) {
		final int FØR = -1;
		final int LIK = 0;
		final int ETTER = 1;

		if (this == o) {return LIK;}

		if (this.getNr() < o.getNr()) {return FØR;}
		if (this.getNr() > o.getNr()) {return ETTER;}

		if (this.getKjoretidKrav() < o.getKjoretidKrav()) {return FØR;}
		if (this.getKjoretidKrav() > o.getKjoretidKrav()) {return ETTER;}

		return LIK;
	}
}
