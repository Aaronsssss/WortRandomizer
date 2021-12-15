package alles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	String fileLink = "C:\\Users\\aaron.swann\\git\\repository\\Code\\src\\alles\\";

	public static void main(String[] args) throws FileNotFoundException {
		Main main = new Main();

		 //main.zahlenZählen();

		//main.zahlenZählen2();

		//main.dive();
		
		//main.dive2();
		
		main.binaryDiagnostic2();

	}
	
	//File lesen, Array aus integer zurückgeben
	public int[] readFileInt(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileLink + fileName));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (scanner.hasNextLine()) {
			list.add(Integer.parseInt(scanner.nextLine()));
		}
		int[]arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	//File lesen, Array aus Strings zurückgeben
	public String[] readFileString(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileLink + fileName));
		ArrayList<String> list = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			list.add(scanner.nextLine());
		}
		String[]arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	//Day 1 Part 1
	public void zahlenZählen() throws FileNotFoundException {

		int[] arr = readFileInt("file");

		int counter = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				counter++;
			}
		}
		System.out.println(counter);

	}
	
	//Day 1 Part 2
	public void zahlenZählen2() throws FileNotFoundException {

		int[] arr = readFileInt("file");


		int vorher, vormitte, nachmitte, nachher;
		int counter = 0;
		for (int i = 0; i < arr.length - 3; i++) {

			vorher = arr[i];
			vormitte = arr[i + 1];
			nachmitte = arr[i + 2];
			nachher = arr[i + 3];

			int erster = vorher + vormitte + nachmitte;
			int vergleich = vormitte + nachmitte + nachher;
			if (erster < vergleich) {
				counter++;
			}
		}
		System.out.println(counter);

	}

	//Day 2 Part 1
	public void dive() throws FileNotFoundException {
		
		String[] arr = readFileString("file2");

		int forward = 0;
		int height = 0;
		for (int i = 0; i < arr.length; i++) {
			String[] split = arr[i].split("\\s"); //split[0] = richtung, split[1] = wie viel
			System.out.println(split[0] + " | " + split[1]);
			
			if (split[0].contains("forward")) {
				forward += Integer.parseInt(split[1]);
			} else if (split[0].contains("down")) {
				height += Integer.parseInt(split[1]);
			} else if (split[0].contains("up")) {
				height -= Integer.parseInt(split[1]);
			}
		}
		System.out.println("Forward: " + forward + ". Und höhe ist " + height + ". Ergebnis:" + (forward*height));

	}
	
	//Day 2 Part 2
	public void dive2() throws FileNotFoundException {
		
		String[] arr = readFileString("file2");
		int forward = 0;
		int height = 0;
		int aim = 0; //down: height+ , up: height- , forward: depth += split[1]*aim
		for (int i = 0; i < arr.length; i++) {
			String[] split = arr[i].split("\\s");
			//System.out.println(split[0] + " | " + split[1]);
			int x = Integer.parseInt(split[1]);
			if (split[0].contains("forward")) {
				forward += x;
				height += aim*x;
				
			} else if (split[0].contains("down")) {
				aim += x;
				
			} else if (split[0].contains("up")) {
				aim -= x;
			}
			System.out.println("Forward: " + forward + " | height: " + height + " | aim: " + aim);
		}
		System.out.println("Forward: " + forward + ". Und höhe ist " + height + ". Ergebnis:" + (forward*height));

	}
	
	//Day 3 Part 1
	public void binaryDiagnostic() throws FileNotFoundException {
		String[] arr = readFileString("file3");
		
		int[] calc = {0,0,0,0,0,0,0,0,0,0,0,0};
		int gamma = 0, epsilon = 0;
		int summand = 1;
		
		for(int i = 0; i < arr.length; i++) {
			
			String[]row = arr[i].split("");//Jede Zeile aufsplitten
			
			for (int j = 0; j < row.length;j++) {//Wenn Ziffer = 1 -> Array++, wenn Ziffer = 0 Array--
				if(row[j].contains("0")) {
					calc[j]++;
				} else {
					calc[j]--;
				}
			}
		}
		
		//calc Array auswerten: wenn zahl positiv, diejenige binärstelle auf gamma addieren. Negativ auf epsilon addieren
		for (int i = calc.length-1; i >= 0; i--) {
			if (calc[i] > 0) { 
				gamma += summand;
				
			} else {
				epsilon += summand;
			}
			summand *= 2;
		}
		System.out.println("Gamma: " + gamma + " | Epsilon: " + epsilon + " | Ergebnis: " + (epsilon*gamma));
	}
	
	public void binaryDiagnostic2() throws FileNotFoundException {
		String[] arr = readFileString("file3");
		ArrayList<String> finalList = null;
		int[] calc = {0,0,0,0,0,0,0,0,0,0,0,0};
		int oxygen = 0, scrubber = 0;
		int summand = 1;
		
		for(int i = 0; i < arr.length; i++) {
			
			String[]row = arr[i].split("");//Jede Zeile aufsplitten
			
			for (int j = 0; j < row.length;j++) {//Wenn Ziffer = 1 -> Array++, wenn Ziffer = 0 Array--
				if(row[j].contains("0")) {
					calc[j]++;
				} else {
					calc[j]--;
				}
			}
		}
//		for (int i : calc) {
//			System.out.print(i + " ");
//		}
		for (int a = 0; a < 12; a++ ) {
			ArrayList<String> newList = new ArrayList<String>();
			for (String i : arr) {
				String[]row = i.split("");
				if (calc[a] >= 0 && row[a].contains("1") ) {
					newList.add(i);
				}
			}
			if(a == 11) {
				finalList = newList;
			}
		}
		for (String i : finalList) {
			System.out.println(i);
		}
		/*
		//calc Array auswerten: wenn zahl positiv, diejenige binärstelle auf gamma addieren. Negativ auf epsilon addieren
		for (int i = calc.length-1; i >= 0; i--) {
			if (calc[i] > 0) { 
				
				
			} else {
				
			}
			summand *= 2;
		}
		System.out.println("Gamma: " + "" + " | Epsilon: " + "" + " | Ergebnis: " + "");
		*/
	}
	
	
	
	
	

}
