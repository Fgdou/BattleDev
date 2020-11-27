package com.isograd.exercise2020;

import java.util.Scanner;

public class Exo3 {
	public static void main(String[] args) throws Exception {
		String  line;
		Scanner sc = new Scanner(Exo1.class.getResourceAsStream("/Exo3/input1.txt"));
		while(sc.hasNextLine()) {
			execute(sc);
		}
	}
	static int[] list;
	static int[] grades;
	
	public static void execute(Scanner sc){
		int number = Integer.parseInt(sc.nextLine());
		
		list = new int[number];
		grades = new int[10];
		for(int i=0; i<number-1; i++){
			String line = sc.nextLine();
			int cut = line.indexOf(' ');
			int name = Integer.parseInt(line.substring(0, cut));
			int sup = Integer.parseInt(line.substring(cut+1, line.length()));
			list[name] = sup;
		}
		
		for(int i=1; i<number; i++){
			grades[findGrade(i)]++;
		}
		grades[0] = 1;
		for(int i=0; i<10; i++){
			System.out.print(grades[i] + " ");
		}
	}
	
	private static int findGrade(int i) {
		int cnt = 1;
		int current = list[i];
		while(current != 0){
			current = list[current];
			cnt++;
		}
		return cnt;
	}
}
