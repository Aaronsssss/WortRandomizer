package main;

import java.util.Random;

public class WortRaten {

	public static void main(String[] args) {
		
		WortRaten wr = new WortRaten();
		wr.randomize("Bicycle");

	}
	
	public void randomize(String wort) {
		
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
		System.out.println("Altes Wort: " + wort + ". Neues Wort: " + wortNeu);
	}

}








