import java.util.Scanner;

public class Intersection_of_Two_Matrices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		String[][] arr1 = createArray(sc, a, b);
		String[][] arr2 = createArray(sc, a, b);
		checkArrays(arr1, arr2);
	}

	public static String[][] createArray(Scanner sc, int a, int b) {

		String[][] arr = new String[a][b];
		for (int row = 0; row < arr.length; row++) {
			arr[row] = sc.nextLine().split(" ");
		}
		return arr;
	}

	public static void checkArrays(String[][] arr1, String[][] arr2) {

		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[0].length; col++) {
				if (arr1[row][col].equals(arr2[row][col])) {
					System.out.print(arr1[row][col] + " ");
				} else {
					System.out.print("* ");
				}

			}
			System.out.println();
		}

	}
}
