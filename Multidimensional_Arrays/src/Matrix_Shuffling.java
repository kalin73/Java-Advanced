import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Shuffling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dementions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int a = dementions[0];
		int b = dementions[1];
		String[][] arr = createArray(sc, a, b);
		swap(sc, arr, a, b);
	}

	public static String[][] createArray(Scanner sc, int a, int b) {

		String[][] arr = new String[a][b];

		for (int row = 0; row < a; row++) {

			arr[row] = sc.nextLine().split(" ");

		}
		return arr;
	}

	public static void swap(Scanner sc, String[][] array, int a, int b) {

		String[] input = sc.nextLine().split(" ");
		String[][] arr = array;
		String command = input[0];

		while (!command.equals("END")) {

			if (!command.equals("swap")) {
				System.out.println("Invalid input!");
			} else {

				try {
					int row1 = Integer.parseInt(input[1]);
					int col1 = Integer.parseInt(input[2]);
					int row2 = Integer.parseInt(input[3]);
					int col2 = Integer.parseInt(input[4]);
					String temp = arr[row1][col1];
					arr[row1][col1] = arr[row2][col2];
					arr[row2][col2] = temp;
					printArray(arr, a, b);
				} catch (Exception c) {
					System.out.println("Invalid input!");

				}

			}
			input = sc.nextLine().split(" ");
			command = input[0];
		}

	}

	public static void printArray(String[][] arr, int a, int b) {
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {

				System.out.print(arr[row][col] + " ");

			}
			System.out.println();
		}

	}
}
