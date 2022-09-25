import java.util.Arrays;
import java.util.Scanner;

public class Compare_Matrices {

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
		a = sc.nextInt();
		b = sc.nextInt();
		int[][] arr2 = new int[a][b];
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {
				arr2[row][col] = sc.nextInt();
			}

		}
		if (isEqual(arr1, arr2)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		sc.close();
	}

	public static boolean isEqual(int[][] arr1, int[][] arr2) {
		boolean isEqual = Arrays.deepEquals(arr1, arr2);
		return isEqual;
	}
}
