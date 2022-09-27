import java.util.Scanner;

public class Matrix_of_Palindromes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		String[][] arr = createArray(a, b);
		printArray(arr);
		sc.close();

	}

	public static String[][] createArray(int a, int b) {

		char c1 = 97;
		String[][] arr = new String[a][b];
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {
				char c2 = (char) (c1 + col);
				arr[row][col] = String.valueOf(c1 + "" + c2 + "" + c1);

			}
			c1++;
		}
		return arr;

	}

	public static void printArray(String[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				System.out.print(arr[row][col] + " ");

			}
			System.out.println();
		}

	}
}
