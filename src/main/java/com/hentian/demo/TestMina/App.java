package com.hentian.demo.TestMina;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			System.out.println(str.startsWith("8"));
		}
	}
}
