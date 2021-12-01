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
		
		System.out.println("Welches Wort möchtest du erraten? Eingabe:");
		String wort = in.next();
		
		
		wort = randomize(wort);
		char[] wortArray = wort.toCharArray();
		boolean[] errateneChars = new boolean[wortArray.length];
		for (boolean b : errateneChars) {
			b = false;
		}
		
		System.out.println("Dein Wort: ");
		int index = 0;
		for (char c : wortArray) {
			if (!errateneChars[index]) {
				System.out.print("*");
			} else {
				System.out.print(wortArray[index]);
			}
			index++;
		}
		System.out.println();
		
		
		
	}

}








