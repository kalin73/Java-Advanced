package Recursion;

import java.util.Scanner;

public class Recursive_Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long number = Long.parseLong(sc.nextLine());
		System.out.println(factoriel(number));

		sc.close();
	}

	private static long factoriel(long n) {
		if (n == 0) {
			return 1;
		}
		return n * factoriel(n - 1);
	}
}
