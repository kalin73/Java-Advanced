import java.util.Arrays;
import java.util.Scanner;

public class Print_Diagonals_of_Square_Matrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int[][] arr = createArray(sc, size, size);
		printDiagonal(arr);

	}

	public static int[][] createArray(Scanner sc, int a, int b) {

		int[][] arr = new int[a][b];
		for (int row = 0; row < arr.length; row++) {
			arr[row] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		}
		return arr;
	}

	public static void printDiagonal(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			System.out.print(arr[row][row] + " ");

		}
		System.out.println();
		int col = 0;
		for (int row = arr.length - 1; row >= 0; row--) {

			System.out.print(arr[row][col] + " ");
			col++;

		}

	}
}
