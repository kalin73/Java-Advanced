import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String_Matrix_Rotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] degrees = sc.nextLine().split("\\(");
		int degree = Integer.parseInt(degrees[1].replace(")", ""));
		Character[][] normalArr = createArray(sc);
		Character[][] rotatedArr = rotatingArray(normalArr, degree);
		printArray(rotatedArr, rotatedArr.length, rotatedArr[0].length);

	}

	public static Character[][] createArray(Scanner sc) {
		String input = sc.nextLine();
		List<String> arr = new ArrayList<>();
		while (!input.equals("END")) {
			arr.add(input);
			input = sc.nextLine();
		}
		Character[][] arr2 = null;
		int maxSize = Integer.MIN_VALUE;

		for (int i = 0; i < arr.size(); i++) {

			if (arr.get(i).length() > maxSize) {
				maxSize = arr.get(i).length();

			}
			arr2 = new Character[arr.size()][maxSize];
			for (int row = 0; row < arr2.length; row++) {
				for (int col = 0; col < maxSize; col++) {

					if (col == arr.get(row).length()) {
						break;
					}
					arr2[row][col] = arr.get(row).charAt(col);

				}
			}
		}
		return arr2;
	}

	public static Character[][] rotatingArray(Character[][] arr, int degree) {
		Character[][] rotatedArray;
		int rotations = rotations(degree);

		if (rotations == 1) {

			rotatedArray = new Character[arr[0].length][arr.length];
			int col2 = 0;
			for (int row = 0; row < arr[0].length; row++) {
				int row2 = arr.length - 1;

				for (int col = 0; col < arr.length; col++) {

					rotatedArray[row][col] = arr[row2][col2];
					row2--;
				}
				col2++;
			}
			return rotatedArray;

		} else if (rotations == 2) {

			rotatedArray = new Character[arr.length][arr[0].length];
			int row2 = arr.length - 1;

			for (int row = 0; row < arr.length; row++) {
				int col2 = arr[0].length - 1;
				for (int col = 0; col < arr[0].length; col++) {

					rotatedArray[row][col] = arr[row2][col2];

					col2--;
				}
				row2--;
			}
			return rotatedArray;

		} else if (rotations == 3) {

			rotatedArray = new Character[arr[0].length][arr.length];
			int col2 = arr[0].length - 1;
			for (int row = 0; row < arr[0].length; row++) {
				int row2 = 0;

				for (int col = 0; col < arr.length; col++) {

					rotatedArray[row][col] = arr[row2][col2];
					row2++;
				}
				col2--;
			}
			return rotatedArray;

		} else {

			return arr;
		}

	}

	public static int rotations(int degree) {
		int rotations = 0;
		if (degree % 180 == 0) {

			int r = degree / 180;
			if (r % 2 == 0) {

				rotations = 4;

			} else {
				rotations = 2;
			}

		} else {
			int r = degree / 180;
			if (r % 2 == 0) {

				rotations = 1;

			} else {
				rotations = 3;
			}

		}
		return rotations;
	}

	public static void printArray(Character[][] arr, int a, int b) {
		for (int row = 0; row < a; row++) {
			for (int col = 0; col < b; col++) {
				if (arr[row][col] == null) {
					System.out.print(" ");
					continue;

				}
				System.out.print(arr[row][col]);

			}
			System.out.println();
		}

	}
}