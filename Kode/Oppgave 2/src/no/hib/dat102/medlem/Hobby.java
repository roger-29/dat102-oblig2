package no.hib.dat102.medlem;

public class Hobby {

	private String hobbyNavn;
	
	public Hobby(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}
	
	@Override
	public String toString() {
		return "<" + hobbyNavn + ">";
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	@Override
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby)hobby2;
		return hobbyNavn.equals(hobbyDenAndre.getHobbyNavn());
	}
	
}
