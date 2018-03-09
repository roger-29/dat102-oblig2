package no.hvl.dat102.oppg5;
import java.util.Scanner;
import no.hvl.dat102.oppg5.*;
import no.hvl.dat102.oppg5.kjedet.KjedetOrdnetListe;

public class Main {
	public static void main(String[] args) {
		printIntro();
		KjedetOrdnetListe<Person> personListe = new KjedetOrdnetListe<Person>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Antall personer som skal legges til: ");
		int count = 0;

		// For å unngå trøbbel med newline-characters og scanner
		try{
			count = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		int i = 0;
		while(i<count)
		{
			System.out.println("**************************\nPerson " + (i+1));
			Person person = new Person();

			System.out.println("Fornavn: ");
			person.setFornavn(sc.nextLine());

			System.out.println("Etternavn: ");
			person.setEtternavn(sc.nextLine());

			System.out.println("Fødselsår: ");
			try{
				person.setFodselsaar(Integer.parseInt(sc.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if(person!= null)
			personListe.leggTil(person);
			i++;
			System.out.println("**************************\n");
		}

		Iterator Iterator = personListe.iterator();
	}

	public static void printIntro()
	{
		String cyan = "\033[0;96m";
		String reset = "\u001B[0m";

		System.out.println(cyan + "**************************" + reset);
		System.out.println("Oppgave 5");
		System.out.println(cyan + "**************************" + reset);
	}
}
