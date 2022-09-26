import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_of_2X2_Submatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] size = Arrays.stream(sc.nextLine().split(", ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int a = size[0];
		int b = size[1];
		int[][] arr = createArray(sc, a, b);
		maxSum(arr);
		sc.close();
	}

	public static int[][] createArray(Scanner sc, int a, int b) {

		int[][] arr = new int[a][b];
		for (int row = 0; row < arr.length; row++) {
			arr[row] = Arrays.stream(sc.nextLine().split(", ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		}
		return arr;
	}

	static void maxSum(int[][] arr) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		StringBuilder currSubMatrix = new StringBuilder("");
		StringBuilder maxSubMatrix = new StringBuilder("");
		for (int row = 0; row < arr.length - 1; row++) {
			for (int col = 0; col < arr[0].length - 1; col++) {

				currSum = arr[row][col] + arr[row][col + 1] + arr[row + 1][col] + arr[row + 1][col + 1];
				currSubMatrix.append(arr[row][col] + " " + arr[row][col + 1] + "\n" + arr[row + 1][col] + " "
						+ arr[row + 1][col + 1]);
				if (currSum > maxSum) {
					maxSum = currSum;
					maxSubMatrix.delete(0, maxSubMatrix.length());
					maxSubMatrix = new StringBuilder(currSubMatrix);
				}
				currSubMatrix.delete(0, currSubMatrix.length());
				currSum = 0;
			}

		}
		System.out.println(maxSubMatrix);
		System.out.println(maxSum);
	}
}
