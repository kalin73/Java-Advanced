import java.util.Scanner;

public class Find_the_Real_Queen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] arr = createArray(sc);
		check(arr);

	}

	public static String[][] createArray(Scanner sc) {

		String[][] arr = new String[8][8];
		for (int row = 0; row < arr.length; row++) {
			arr[row] = sc.nextLine().split(" ");
		}
		return arr;
	}

	public static void check(String[][] arr) {
		boolean clearRow = false;
		boolean clearCol = false;
		boolean clearDiagonal1 = false;
		boolean clearDiagonal2 = false;
		int coll = 0;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if ("q".equals(arr[row][col])) {
					coll = col;
					clearCol = checkCol(arr, row, col);
					if (!clearCol) {
						break;
					}

					clearRow = checkrRow(arr, row, col);
					if (!clearRow) {
						continue;
					}

					clearDiagonal1 = checkrDiagonal1(arr, row, col);
					if (!clearDiagonal1) {
						continue;
					}

					clearDiagonal2 = checkrDiagonal2(arr, row, col);
					if (!clearDiagonal2) {
						continue;
					}
				}
			}
			if (clearCol && clearRow && clearDiagonal1 && clearDiagonal2) {

				System.out.println(row + " " + coll);
				break;
			}
		}
	}

	public static boolean checkCol(String[][] arr, int row, int col) {
		boolean clear = true;

		for (int col2 = col + 1; col2 < 8; col2++) {
			if ("q".equals(arr[row][col2])) {
				return false;
			}
		}

		return clear;

	}

	public static boolean checkrRow(String[][] arr, int row, int col) {
		boolean clear = true;

		for (int row2 = 0; row2 < 8; row2++) {
			if ("q".equals(arr[row2][col]) && (row2 != row)) {
				return false;
			}
		}
		return clear;

	}

	public static boolean checkrDiagonal1(String[][] arr, int row, int col) {
		boolean clear = true;
		int col2 = col + 1;
		for (int row2 = row + 1; row2 < 8 && col2 < 8; row2++) {
			if ("q".equals(arr[row2][col2])) {
				return false;
			}
			col2++;
		}
		col2 = col - 1;
		for (int row2 = row - 1; row2 >= 0 && col2 >= 0; row2--) {
			if ("q".equals(arr[row2][col2])) {
				return false;
			}
			col2--;
		}
		return clear;

	}

	public static boolean checkrDiagonal2(String[][] arr, int row, int col) {
		boolean clear = true;
		int col2 = col - 1;
		for (int row2 = row + 1; row2 < 8 && col2 >= 0; row2++) {
			if ("q".equals(arr[row2][col2])) {
				return false;
			}
			col2--;
		}
		col2 = col + 1;
		for (int row2 = row - 1; row2 >= 0 && col2 < 8; row2--) {
			if ("q".equals(arr[row2][col2])) {
				return false;
			}
			col2++;
		}
		return clear;

	}
}
