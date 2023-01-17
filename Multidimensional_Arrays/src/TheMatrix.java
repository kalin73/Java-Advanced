import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int rows = arr[0];
		int cols = arr[1];

		char[][] matrix = new char[rows][cols];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = sc.nextLine().replace(" ", "").toCharArray();
		}

		char newChar = sc.nextLine().charAt(0);

		int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int startingRow = arr2[0];
		int startingCol = arr2[1];

		char oldChar = matrix[startingRow][startingCol];

		paint(matrix, newChar, oldChar, startingRow, startingCol);

		for (char[] line : matrix) {
			for (char c : line) {
				System.out.print(c);
			}
			System.out.println();
		}
		sc.close();
	}

	private static void paint(char[][] matrix, char newChar, char oldChar, int startingRow, int startingCol) {
		if (!valid(startingRow, startingCol, matrix) || (matrix[startingRow][startingCol] != oldChar)) {
			return;
		}

		matrix[startingRow][startingCol] = newChar;

		paint(matrix, newChar, oldChar, startingRow - 1, startingCol);
		paint(matrix, newChar, oldChar, startingRow + 1, startingCol);
		paint(matrix, newChar, oldChar, startingRow, startingCol - 1);
		paint(matrix, newChar, oldChar, startingRow, startingCol + 1);

	}

	private static boolean valid(int row, int col, char[][] matrix) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}
}
