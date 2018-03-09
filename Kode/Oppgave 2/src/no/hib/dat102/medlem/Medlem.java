package no.hib.dat102.medlem;
import no.hib.dat102.mengde.kjedet.*;
import no.hib.dat102.mengde.adt.*;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = null;
		statusIndeks = -1;
	}
	
	public void setNavn(String endretNavn) {
		navn = endretNavn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}
	
	public void setHobbyer(MengdeADT<Hobby> hobbyMengde) {
		hobbyer = hobbyMengde;
	}
	
	public MengdeADT<Hobby> getHobbyer(){
		return hobbyer;
	}
	
	public void setStatusIndeks(int medlem) {
		statusIndeks = medlem;
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public boolean equals(Medlem medlem) {
		if(getNavn().equals(medlem.getNavn()))
			return true;
		else
			return false;
	}
	
	public boolean passerTil(Medlem medlem2) {
		if(getHobbyer().equals(medlem2.getHobbyer()))
			return true;
		else 
			return false;
	}
	
	public void printMedlem() {
		System.out.println("Medlemsnavn: " + navn + "\nMedlemsindeks: " + statusIndeks
				+ "\nMedlemshobbyer: \n" + hobbyer.toString());
	}
}
