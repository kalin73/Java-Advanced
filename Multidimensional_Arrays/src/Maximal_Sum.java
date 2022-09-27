import java.util.Scanner;

public class Maximal_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int[][] arr = createArray(sc, a, b);
		maxSum(arr, a, b);
	}

	public static int[][] createArray(Scanner sc, int a, int b) {

		int[][] arr = new int[a][b];

		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {

				arr[row][col] = sc.nextInt();

			}

		}
		return arr;
	}

	public static void maxSum(int[][] arr, int a, int b) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		String matrix = "";

		for (int row = 0; row < a - 2; row++) {
			for (int col = 0; col < b - 2; col++) {

				currSum = arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row + 1][col]
						+ arr[row + 1][col + 1] + arr[row + 1][col + 2] + arr[row + 2][col] + arr[row + 2][col + 1]
						+ arr[row + 2][col + 2];
				if (currSum > maxSum) {
					maxSum = currSum;
					matrix = String.format("%d %d %d%n%d %d %d%n%d %d %d", arr[row][col], arr[row][col + 1],
							arr[row][col + 2], arr[row + 1][col], arr[row + 1][col + 1], arr[row + 1][col + 2],
							arr[row + 2][col], arr[row + 2][col + 1], arr[row + 2][col + 2]);
				}
			}

		}
		System.out.println("Sum = " + maxSum);
		System.out.println(matrix);

	}
}
