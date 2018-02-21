package no.hvl.dat102.oppg7;

import java.io.*;

public class Jobbsamling<T> {

	private int tabLength;
	private Jobb[] tab;

	public Jobbsamling() {
		this(1000);
	}

	public Jobbsamling(int size) {
		this.tabLength = 0;
		this.tab = new Jobb[size]; // ((T[]) new Object[size]);
	}

	public int getLength() {
		return this.tabLength;
	}

	public void leggTilJobb(Jobb j) {

	}

	

	public Jobb hentFoerstAnkommet(int tid) {
		// Not implemented
		return null;
	}

	// Summerer ventetidene til alle jobbene i samlingen
	public int finnSumVentetider() {
		int sum = 0;
		for (int i = 0; i < this.tabLength; i++) {
			sum += tab[i].getVentetid();
		}
		return sum;
	}

	public void lesFraFil(String filnavn) {
		String SKILLE = "#";
		
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(filnavn);
			br = new BufferedReader(fr);

			String antall = br.readLine();
			int n = Integer.parseInt(antall);
			
			String linje = br.readLine();
			
			for(int i = 0; i < n; i++) {
				
				String[] data = linje.split(SKILLE);
				
				int nr = Integer.parseInt(data[0]);
				int ankomsttid = Integer.parseInt(data[1]);
				int kjoretidKrav = Integer.parseInt(data[2]);
				int ferdigtid = Integer.parseInt(data[3]);
				
				Jobb j = new Jobb(nr, ankomsttid, kjoretidKrav, ferdigtid);

				this.leggTilJobb(j);
				
				linje = br.readLine();
			}
			
			br.close();
			fr.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke fil: "+ filnavn);	
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Det oppstod en feil: " + e);
			System.exit(1);
		}
	}
}
