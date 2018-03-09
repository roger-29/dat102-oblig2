package no.hib.dat102.medlem.klient;
import no.hib.dat102.medlem.*;

public class MedlemKlient {

	public static void main(String[] args) {
		
		Datakontakt kjør = new Datakontakt();
		Tekstgrensesnitt kjører = new Tekstgrensesnitt(kjør);
		kjører.start();

	}

}
