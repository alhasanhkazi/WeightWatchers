package com.general.scripting;

import java.util.Scanner;

public class Question1 {
	private static Scanner scan;

	public static void main(String[] args) {
		System.out.println("Enter your sentence");
		scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		String rev = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);
	}
}
