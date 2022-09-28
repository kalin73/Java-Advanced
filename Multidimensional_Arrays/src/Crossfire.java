import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dementions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int a = dementions[0];
		int b = dementions[1];

		String[][] arr = createArray(sc, a, b);
		printArray(nukedArray(sc, arr), a, b);

	}

	public static String[][] createArray(Scanner sc, int a, int b) {

		String[][] arr = new String[a][b];
		int counter = 1;
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {

				arr[row][col] = String.valueOf(counter);
				counter++;
			}

		}
		return arr;
	}

	public static String[][] nukedArray(Scanner sc, String[][] arr) {

		String[] input = sc.nextLine().split(" ");
		String[][] newArr;

		while (!input[0].equals("Nuke")) {
			newArr = arr;
			arr = new String[newArr.length][newArr[0].length];
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			int radius = Integer.parseInt(input[2]);
			if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {

				for (int i = 0; i <= radius; i++) {

					if (row + i < newArr.length) {

						newArr[row + i][col] = "";

					}
					if (row - i >= 0) {

						newArr[row - i][col] = "";

					}
					if (col + i < arr[0].length) {

						newArr[row][col + i] = "";

					}
					if (col - i >= 0) {

						newArr[row][col - i] = "";

					}

				}
			} else if (col >= 0 && col < arr[0].length) {
				if (row > arr.length - 1) {

					int explosion = row - radius;
					for (int i = arr.length - 1; i >= explosion && i >= 0; i--) {
						newArr[i][col] = "";
					}

				} else if (row < 0) {

					int explosion = row + radius;
					for (int i = 0; i <= explosion && i < arr.length; i++) {
						newArr[i][col] = "";
					}

				}
			} else if (row >= 0 && row < arr.length) {
				if (col > arr[0].length - 1) {

					int explosion = col - radius;
					for (int i = arr[0].length - 1; i >= explosion && i >= 0; i--) {
						newArr[row][i] = "";
					}

				} else if (col < 0) {

					int explosion = col + radius;
					for (int i = 0; i <= explosion && i < arr[0].length; i++) {
						newArr[row][i] = "";
					}

				}
			}
			int currenRow = 0;
			int currentCol = 0;
			for (int row2 = 0; row2 < arr.length; row2++) {
				for (int col2 = 0; col2 < arr[0].length; col2++) {

					if (newArr[row2][col2] == null || newArr[row2][col2].equals("")) {
						arr[currenRow][currentCol] = "";
						continue;

					}
					arr[currenRow][currentCol] = newArr[row2][col2];

					currentCol++;
				}
				currentCol = 0;
				if (arr[currenRow][0] == "") {
					continue;
				}
				currenRow++;
			}
			input = sc.nextLine().split(" ");
		}
		return arr;
	}

	public static void printArray(String[][] arr, int a, int b) {
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {
				if (arr[row][col] == null) {
					System.out.print("");
					continue;
				}
				System.out.print(arr[row][col] + " ");

			}
			System.out.println();
		}

	}
}
