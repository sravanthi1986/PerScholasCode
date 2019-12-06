package org.perscholas2;

import java.util.Random;
import java.util.Scanner;

public class JavaSBAProject_02 {

	public static void main(String[] args) {
		int a;
		int c;
		int r = 0;

		Random t = new Random();

		// random integers in [0, 100]

		for (c = 1; c <= 10; c++) {
			r = t.nextInt(100);
			System.out.println(r);
		}

		Scanner input = new Scanner(System.in); /* create a object */

		System.out.println("Guess random number(0-100):");
		a = input.nextInt();

		while (a != r) {
			if (a > r) {
				System.out.println("Too High, Try Again");
			}

			if (a < r) {
				System.out.println("Too Low, Try Again");
			}

			System.out.println("guess random number(0-100) again?");
			a = input.nextInt();

		}

		if (a == r) {
			System.out.println("Your guess is correct.");
		}
	}
}
