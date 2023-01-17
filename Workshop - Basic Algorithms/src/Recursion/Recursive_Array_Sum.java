package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Array_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println(sum(arr, arr.length - 1));
		sc.close();
	}

	private static int sum(int[] arr, int index) {
		if (index < 0) {
			return 0;
		}
		return arr[index] + sum(arr, index - 1);
	}
}
