package com.isograd.exercise2020;

import java.util.Scanner;

public class Exo2 {
	public static void main(String[] args) throws Exception {
		String  line;
		Scanner sc = new Scanner(Exo1.class.getResourceAsStream("/Exo2/input2.txt"));
		while(sc.hasNextLine()) {
			execute(sc);
		}
	}
	public static void execute(Scanner sc){
		int total = Integer.parseInt(sc.nextLine());
		int night = 0;
		
		for(int i=0; i< total; i++){
			String line = sc.nextLine();
			int hour = Integer.parseInt(line.substring(0, 2));
			int min = Integer.parseInt(line.substring(3, 5));
			int time = hour*60+min;
			
			if(time < 8*60 || time >= 20*60)
				night++;
		}
		
		if(night > total/2)
			System.out.println("SUSPICIOUS");
		else
			System.out.println("OK");
	}
}
