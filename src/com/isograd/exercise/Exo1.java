package com.isograd.exercise;

import java.util.Scanner;

public class Exo1 {
	public static void main(String[] args) throws Exception {
		String  line;
		Scanner sc = new Scanner(Exo1.class.getResourceAsStream("/Exo1/input1.txt"));
		while(sc.hasNextLine()) {
			execute(sc);
		}
	}
	public static void execute(Scanner sc){
		int lines = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		for(int i=0; i < lines; i++){
			String line = sc.nextLine();
			if(isMoreTanFive(line))
				cnt++;
		}
		System.out.println(cnt);
	}
	public static boolean isMoreTanFive(String str){
		int cnt = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
				cnt++;
			else
				cnt = 0;
		}
		if(cnt >= 5)
			return true;
		return false;
	}
}
