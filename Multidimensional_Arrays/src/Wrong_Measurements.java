import java.util.Arrays;
import java.util.Scanner;

public class Wrong_Measurements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int[][] arr1 = createArray(sc, a);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int row = arr[0];
		int col = arr[1];
		int[][] fixedArray = fixingArr(arr1, a, row, col);
		printArray(fixedArray);
	}

	public static int[][] createArray(Scanner sc, int a) {
		int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int[][] arr = new int[a][arr1.length];
		for (int row = 0; row < a; row++) {
			if (row == 0) {
				arr[row] = arr1;
				continue;
			}
			arr[row] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		}
		return arr;
	}

	public static int[][] fixingArr(int[][] arr, int a, int r, int c) {
		int[][] newArr = new int[a][arr[0].length];
		int top = 0;
		int bot = 0;
		int right = 0;
		int left = 0;
		int wrongVal = arr[r][c];
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == wrongVal) {

					if (row > 0 && arr[row - 1][col] != wrongVal) {

						top = arr[row - 1][col];

					}
					if (row < a - 1 && arr[row + 1][col] != wrongVal) {

						bot = arr[row + 1][col];

					}
					if (col != 0 && arr[row][col - 1] != wrongVal) {

						left = arr[row][col - 1];

					}
					if (col < arr[0].length - 1 && arr[row][col + 1] != wrongVal) {

						right = arr[row][col + 1];

					}
					newArr[row][col] = top + bot + right + left;
					top = 0;
					bot = 0;
					right = 0;
					left = 0;
				} else {
					newArr[row][col] = arr[row][col];
				}
			}

		}

		return newArr;
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
