import java.util.Scanner;

public class Positions_Of {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int[][] arr1 = new int[a][b];
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {
				arr1[row][col] = sc.nextInt();
			}
		}
		int n = sc.nextInt();

		if (contains(n, arr1)) {

			print(n, arr1);

		} else {

			System.out.println("not found");
		}
		sc.close();
	}

	public static boolean contains(int n, int[][] arr1) {

		boolean contains = false;

		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				if (arr1[row][col] == n) {
					contains = true;
				}

			}

		}
		return contains;
	}

	public static void print(int n, int[][] arr1) {
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				if (arr1[row][col] == n) {
					System.out.println(row + " " + col);
				}

			}

		}

	}
}