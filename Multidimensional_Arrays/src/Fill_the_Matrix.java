import java.util.Scanner;

public class Fill_the_Matrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(", ");
		if (input[1].equals("A")) {
			int[][] arr = createArrayA(Integer.parseInt(input[0]));
			printArray(arr);
		} else {
			int[][] arr = createArrayB(Integer.parseInt(input[0]));
			printArray(arr);
		}
		sc.close();
	}

	public static int[][] createArrayA(int n) {
		int element = 1;
		int[][] arr = new int[n][n];
		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {

				arr[row][col] = element;
				element++;
			}

		}
		return arr;
	}

	public static int[][] createArrayB(int n) {
		int element = 1;
		int col = 0;
		int[][] arr = new int[n][n];

		for (int row = 0; row < n; row++) {
			if (element > n * n) {
				return arr;
			}
			arr[row][col] = element;
			element++;
			if (row == n - 1) {
				if (element > n * n) {
					return arr;
				}
				col++;
				for (int row2 = row; row2 >= 0; row2--) {
					arr[row2][col] = element;
					element++;
					if (row2 == 0) {
						col++;
						row = -1;
					}
				}

			}

		}
		return arr;
	}

	public static void printArray(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				System.out.print(arr[row][col] + " ");

			}
			System.out.println();
		}

	}
}
