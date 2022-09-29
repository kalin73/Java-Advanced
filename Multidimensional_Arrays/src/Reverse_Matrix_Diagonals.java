import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Matrix_Diagonals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dementions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int a = dementions[0];
		int b = dementions[1];
		String[][] arr = createArray(sc, a, b);
		String[][] diagonal = diagonal(arr, a, b);
		printArray(diagonal, diagonal.length, diagonal[0].length);
	}

	public static String[][] createArray(Scanner sc, int a, int b) {

		String[][] arr = new String[a][b];

		for (int row = 0; row < a; row++) {

			arr[row] = sc.nextLine().split(" ");

		}
		return arr;
	}

	public static String[][] diagonal(String[][] arr, int a, int b) {

		int rows = a + b - 1;
		String[][] diagonal = new String[rows][a];
		int rotations = 0;
		int col = 0;

		if (a <= b) {
			rotations = a;
		} else {
			rotations = b;
		}

		for (int i = 0; i < rotations; i++) {
			int startCol = arr[0].length;
			int row = 0 + i;
			int startRow = arr.length - 1 - i;
			for (int j = arr[0].length - 1; j > i; j--) {
				startCol--;
				diagonal[row][col] = arr[startRow][startCol];
				row++;

			}
			startCol--;
			for (int k = startRow; k >= 0; k--) {

				diagonal[row][col] = arr[k][startCol];
				row++;

			}
			col++;
		}
		return diagonal;
	}

	public static void printArray(String[][] arr, int a, int b) {
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {
				if (arr[row][col] == null) {
					System.out.print(" ");
					continue;

				}
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

	}
}
