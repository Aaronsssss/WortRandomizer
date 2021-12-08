package main;

import java.util.Random;
import java.util.Scanner;

public class WortRaten {

	public static void main(String[] args) {
		
		WortRaten wr = new WortRaten();
		
		String wort = "Bicycle";
		String wortNeu = wr.randomize(wort);
		
		//System.out.println("Altes Wort: " + wort + ". Neues Wort: " + wortNeu);
		wr.zufallSpiel();

	}
	
	public String randomize(String wort) {
		
		Random rnd = new Random();	
		int index1, index2;
		char[] wortAlsArray = wort.toCharArray();
		String wortNeu;
		
		for (int i = 0; i< wort.length() + 20; i++) {
			index1 = rnd.nextInt(wort.length());
			index2 = rnd.nextInt(wort.length());
			
			char tmp = wortAlsArray[index1];
			
			wortAlsArray[index1] = wortAlsArray[index2];
			wortAlsArray[index2] = tmp;
			
		}
		wortNeu = String.valueOf(wortAlsArray);
		return wortNeu;
	}
	
	public void zufallSpiel() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welches Wort möchtest du erraten? Eingabe:"); //Wort entgegen nehmen und randomizen
		String wort = in.next();
		
		
		wort = randomize(wort);
		System.out.println(wort);
		
		char[] wortArray = wort.toCharArray();
		boolean[] errateneChars = new boolean[wortArray.length]; //Array für erratene Buchstaben
		for (boolean b : errateneChars) {
			b = false;
		}
		
		System.out.println("Dein Wort: ");
		charAusgabe(wortArray, errateneChars);
		
		
		
		
		boolean erraten = false;
		while(!erraten) {
			System.out.println("Bitte raten sie dann mal: "); //Anfang des Spiels als While schleife
			
			String eingabe; 
			eingabe = in.next();
			char[] eingabeArray = eingabe.toCharArray();
			try {
				for (int i = 0; i<eingabe.length(); i++) {
					if(eingabeArray[i] == wortArray[i]) { //Jeden erratenen Buchstaben abspeichern
						errateneChars[i] = true;
					}
				}
			} catch (Exception e) {
				System.out.println("Wort zu lang!!");
			}
			charAusgabe(wortArray, errateneChars);
			if(istFertig(errateneChars)) { //Alle erraten? dann fertig
				erraten = true;
			}
		}
		System.out.println("Wow du hast das Wort " + wort + " erraten!");
		
	}
	
	//Ausgabe der erratenen Buchstaben
	public void charAusgabe(char[] arr, boolean[] erratene) { 
		
		int i = 0;
		for (char c : arr) {
			if (!erratene[i]) {
				System.out.print("*");
			} else {
				System.out.print(arr[i]);
			}
			i++;
		}
		System.out.println();
	}
	public boolean istFertig(boolean[] arr) {
		for (boolean b : arr) {
			if(!b) {
				return false;
			}
		}
		return true;
	}

}








