package no.hib.dat102.medlem.klient;
import no.hib.dat102.medlem.*;

public class MedlemKlient {

	public static void main(String[] args) {
		
		Datakontakt kj�r = new Datakontakt();
		Tekstgrensesnitt kj�rer = new Tekstgrensesnitt(kj�r);
		kj�rer.start();

	}

}
