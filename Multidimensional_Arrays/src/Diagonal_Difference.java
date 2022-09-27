import java.util.Scanner;

public class Diagonal_Difference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int[][] matrix = createArray(sc, size);
		int diff = getDiagonalDiff(matrix);
		System.out.println(diff);
	}

	public static int[][] createArray(Scanner sc, int size) {

		int[][] arr = new int[size][size];

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {

				arr[row][col] = sc.nextInt();

			}

		}
		return arr;
	}

	public static int getDiagonalDiff(int[][] arr) {
		int diff = 0;
		int sum1 = 0;
		int sum2 = 0;
		int col = 0;

		for (int row = 0; row < arr.length; row++) {
			sum1 = sum1 + arr[row][col];
			col++;
		}
		col = arr.length - 1;
		for (int row = 0; row < arr.length; row++) {
			sum2 = sum2 + arr[row][col];
			col--;
		}
		diff = Math.abs(sum1 - sum2);
		return diff;

	}
}
