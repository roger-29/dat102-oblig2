package no.hvl.dat102.oppg7;

import java.util.Scanner;
import no.hvl.dat102.oppg7.Queue.CircularQueue;

// Algoritmen implementert med Kø A (ordnet liste) og Kø B (sirkulær kø)
public class KjorePlan3 {

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
		//Jobbsamling<Jobb> samling = new Jobbsamling<Jobb>();

		System.out.println("Leser inn CPU-jobber fra fil");
		//samling.lesFraFil(filnavn);

		CircularQueue<Jobb> queueB = new CircularQueue<Jobb>();

		queueB.enqueue(new Jobb());

		sc.close();
		System.exit(0);
	}
}
