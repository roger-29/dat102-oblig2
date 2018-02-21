package no.hvl.dat102.oppg7;

import java.util.Scanner;

// Algoritmen implementert med vanlig kø
public class KjorePlan1 {

	public static void main(String[] args) {

		// Tømmer konsollvindu
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Initialiserer Scanner
		Scanner sc = new Scanner(System.in);

		System.out.println("Skriv inn filnavn");
		System.out.print("> ");
		String filnavn = sc.nextLine();

		System.out.println("Kjøring med kø");

		// 1 | Opprett Jobbsamling og les en fil inn i køen
		Jobbsamling<Jobb> samling = new Jobbsamling<Jobb>();

		System.out.println("Leser inn CPU-jobber fra fil");
		samling.lesFraFil(filnavn);

		int antall = samling.getLength();
		System.out.println("Jobbsamling opprettet med " + antall + " CPU-jobber");

		// 2 | Gjennomfør simulering

		// 3 | Skriv ut resultater
		System.out.println("Datafil:\nAlle tider i ms");

		// 4 | Avslutt program
		sc.close();
		System.exit(0);
	}
}
