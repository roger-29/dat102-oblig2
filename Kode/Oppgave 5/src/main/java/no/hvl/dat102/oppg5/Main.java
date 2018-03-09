package no.hvl.dat102.oppg5;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		printIntro();
		Scanner sc = new Scanner(System.in);
		int method = 0;

		// For å unngå trøbbel med newline-characters og scanner
		try{
			method = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

		switch(method)
		{
			case 0: System.out.println("Invalid input");
			break;

			case 1: runCircularQueue(sc);
			break;

			case 2: runLinkedQueue(sc);
			break;

			case 3: runArrayOrderedList(sc);
			break;

			case 4: runLinkedOrderedList(sc);
			break;

			default: System.out.println("Error reading input..");
			sc.close();
			break;
		}
	}

	public static void printIntro()
	{
		String color = "\u001B[32m";
		String reset = "\u001B[0m";

		System.out.println(color + "**************************" + reset);
		System.out.println("Oppgave 5");
		System.out.println(color + "**************************" + reset);
		System.out.println("What queue/list do you want to use?");
		System.out.println("1. Circular queue");
		System.out.println("2. Linked queue");
		System.out.println("3. ArrayOrderedList");
		System.out.println("4. LinkedOrderedList");
		System.out.println(color + "**************************" + reset);
		System.out.println("Enter number:");
	}


	public static void runLinkedQueue(Scanner sc)
	{
		KjedetKø<Person> personKø = new KjedetKø<>();

		System.out.println("Antall personer som skal legges til: ");
		int count = 0;

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
				personKø.enqueue(person);
			i++;
			System.out.println("**************************\n");
		}

		while(personKø.size()>0)
		{
			System.out.println(personKø.dequeue().toString());
		}
	}

	public static void runCircularQueue(Scanner sc)
	{
		SirkulærKø<Person> personKø = new SirkulærKø<>();

		System.out.println("Antall personer som skal legges til: ");
		int count = 0;

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
				personKø.enqueue(person);
			i++;
			System.out.println("**************************\n");
		}

		while(personKø.size()>0)
		{
			System.out.println(personKø.dequeue().toString());
		}
	}

	public static void runArrayOrderedList(Scanner sc)
	{
		TabellOrdnetListe<Person> personListe = new TabellOrdnetListe<>();

		System.out.println("Antall personer som skal legges til: ");
		int count = 0;

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

		while(personListe.rear>0)
		{
			System.out.println(personListe.removeLast().toString());

		}
	}

	public static void runLinkedOrderedList(Scanner sc)
	{
		KjedetOrdnetListe<Person> personListe = new KjedetOrdnetListe<>();
		System.out.println("Antall personer som skal legges til: ");
		int count = 0;

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

		while(personListe.count>0)
		{
			System.out.println(personListe.removeLast().toString());

		}
	}
}
