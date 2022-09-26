import java.util.Arrays;
import java.util.Scanner;

public class Sum_Matrix_Elements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] size = Arrays.stream(sc.nextLine().split(", ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int a = size[0];
		int b = size[1];
		int[][] arr = createArray(sc, a, b);
		System.out.println(a + "\n" + b);
		int sum = sumArray(arr);
		System.out.println(sum);

	}

	public static int[][] createArray(Scanner sc, int a, int b) {

		int[][] arr = new int[a][b];
		for (int row = 0; row < arr.length; row++) {
			arr[row] = Arrays.stream(sc.nextLine().split(", ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		}
		return arr;
	}

	public static int sumArray(int[][] arr1) {
		int sum = 0;
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[0].length; col++) {
				sum += arr1[row][col];

			}
		}
		return sum;
	}
}
