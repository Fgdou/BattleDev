package com.isograd.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Exo4 {
	public static void main(String[] args) throws Exception {
		String  line;
		Scanner sc = new Scanner(Exo1.class.getResourceAsStream("/Exo4/input4.txt"));
		while(sc.hasNextLine()) {
			execute(sc);
		}
	}
	public static void execute(Scanner sc){
		String numbers = sc.nextLine();
		int space = numbers.indexOf(' ');
		int n = parseInt(numbers, 0, space);
		int m = parseInt(numbers, space+1, numbers.length());
		
		int[] key = parseKey(sc.nextLine(), n);
		
		int[] result = new int[256];
		for(int i=0; i<m; i++){
			result[decode(parseMsg(sc.nextLine(), m), key)]++;
		}
		
		for(int i=0; i<result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
	
	private static int decode(int[] msg, int[] key) {
		return key[msg[1]+1] ^ key[msg[0]];
	}
	
	private static int[] parseMsg(String line, int n) {
		int[] list = new int[2];
		int space = line.indexOf(' ');
		list[0] = parseInt(line, 0, space);
		list[1] = parseInt(line, space+1, line.length());
		
		if(list[0] > list[1]){
			int tmp = list[0];
			list[0] = list[1];
			list[1] = tmp;
		}
		return list;
	}
	private static int[] parseKey(String nextLine, int m) {
		int[] key = new int[m+1];
		key[0] = 0;
		int last = 0;
		for(int i=0; i<m; i++){
			int index = nextLine.indexOf(' ', last);
			if(index == -1) {
				key[i+1] = key[i] ^ parseInt(nextLine, last, nextLine.length());
			} else {
				key[i+1] = key[i] ^ parseInt(nextLine, last, index);
				last += (index-last)+1;
			}
		}
		return key;
	}
	
	public static int parseInt(String str, int debut, int fin){
		int n = 0;
		int power = 1;
		for(int i=fin-1; i>=debut; i--){
			n += (str.charAt(i) - '0')*power;
			power *= 10;
		}
		return n;
	}
}
