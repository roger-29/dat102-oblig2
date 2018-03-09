package no.hib.dat102.medlem;
import java.util.Scanner;
import no.hib.dat102.mengde.adt.*;
import no.hib.dat102.mengde.kjedet.*;

public class Tekstgrensesnitt {
	
	private static Datakontakt data;
	private final static String AVSLUTT = "-1";
	private final static String KOMMANDOER = "0";
	private final static String LES_MEDLEM = "1";
	private final static String SKRIV_HOBBYLISTE = "2";
	private final static String SKRIV_PAR_LISTE = "3";
	
		public Tekstgrensesnitt(Datakontakt data) {
			this.data = data;
		}
		
		public void start() {
			
			System.out.println("Tekstgrensesnitt for Medlemsdata \nSkriv '0' for listen over kommandoer.");
			Scanner input = new Scanner(System.in);
			String currentInput = "";
			boolean running = true;
			while(running) {
				currentInput = input.nextLine();
				
				if(currentInput.equals(AVSLUTT)) {
					running = false;
					
				}else if(currentInput.equals(KOMMANDOER)) {
					System.out.println("AVSLUTT = -1 \nKOMMANDOER = 0 \nLES MEDLEM = 1 \nSKRIV HOBBYLISTE = 2\n"
							+ "SKRIV PAR LISTE = 3");
				}else if(currentInput.equals(LES_MEDLEM)) {
					
						Medlem med = lesMedlem();
						data.leggTilMedlem(med);
						
				}else if(currentInput.equals(SKRIV_HOBBYLISTE)) {
					
					currentInput = input.nextLine();
					try {
						skrivHobbyListe(data.getMedlem(currentInput));
					}catch(NullPointerException e) {
						System.out.println("Personen eksisterer ikke i systemet");
					}
				
					
				}else if(currentInput.equals(SKRIV_PAR_LISTE)) {
					
					skrivParListe(data);
					
				}else {
					System.out.println("Ugyldig kommando");
				}
				
			}
			
			input.close();
			System.out.println("Programmet avluttes...");
		}
	
		public static Medlem lesMedlem() {
	
			MengdeADT<Hobby> hh = new KjedetMengde<Hobby>();
			Hobby h;
			Scanner input = new Scanner(System.in);
			String m = "";
			boolean running = true;
			
			System.out.println("Legger inn et nytt medlem \nSkriv navn: ");
			m = input.nextLine();
			Medlem med = new Medlem(m);
			System.out.println("Skriv inn hobbyene en og en \nSkriv 'zzz' når fullført: ");
			
			while(running) {
				
				m = input.nextLine();
				
				if(!m.equals("zzz")) {
					h = new Hobby(m);
					hh.leggTil(h);
				}else
					running = false;
		
			}
			med.setHobbyer(hh);
			System.out.println("Fullført");
			
			return med;
		}
		
		public static void skrivHobbyListe(Medlem medlem) {
			System.out.println("Alle hobbyene ");
			System.out.println(medlem.getHobbyer().toString());
		}
		
		public static void skrivParListe(Datakontakt arkiv) {
			Datakontakt kopi = arkiv;
			String liste = "";
			String partnerNavn = "";
			Medlem m1;
			Medlem m2;
			Medlem[] mmer = kopi.getMedlemsTabell();
			int størrelse = kopi.getStørrelse();
			int partner = -1;
			
			for(int i = 0; i < størrelse; i++){
				
				m1 = mmer[i];
				
				if(m1.getStatusIndeks() > i || m1.getStatusIndeks() == -1) {
				
				liste += m1.getNavn() + " og ";
				kopi.finnPartnerFor(m1.getNavn());
				if(m1.getStatusIndeks() != -1) {
					m2 = mmer[m1.getStatusIndeks()];
					partnerNavn = m2.getNavn();
				}else
					partnerNavn = " (ingen partner) ";
				liste += partnerNavn;
				liste += m1.getHobbyer();
				
				}
			}
			System.out.println(liste);
		}
}
