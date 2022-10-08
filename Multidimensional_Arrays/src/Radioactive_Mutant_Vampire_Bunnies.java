import java.util.Scanner;

public class Radioactive_Mutant_Vampire_Bunnies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		int playerRow = 0;
		int playerCol = 0;

		char[][] arr = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			String inp = sc.nextLine();

			for (int k = 0; k < cols; k++) {

				arr[i][k] = inp.charAt(k);

				if (inp.charAt(k) == 'P') {
					playerRow = i;
					playerCol = k;
				}
			}

		}
		char[][] arr2 = copy(arr, rows, cols);

		String inp = sc.nextLine();
		boolean isFree = false;
		boolean isDead = false;

		for (int i = 0; i < inp.length(); i++) {

			if (inp.charAt(i) == 'L' && !isDead) {
				if (playerCol == 0) {
					isFree = true;
					arr2[playerRow][playerCol] = '.';
				} else if (arr[playerRow][playerCol - 1] == 'B') {
					arr2[playerRow][playerCol] = '.';
					isDead = true;
					playerCol--;

				} else {
					arr2[playerRow][playerCol - 1] = 'P';
					arr2[playerRow][playerCol] = '.';
					playerCol--;
				}

			} else if (inp.charAt(i) == 'R' && !isDead) {
				if (playerCol == cols - 1) {
					isFree = true;
					arr2[playerRow][playerCol] = '.';
				} else if (arr[playerRow][playerCol + 1] == 'B') {
					arr2[playerRow][playerCol] = '.';
					isDead = true;
					playerCol++;

				} else {
					arr2[playerRow][playerCol + 1] = 'P';
					arr2[playerRow][playerCol] = '.';
					playerCol++;

				}

			} else if (inp.charAt(i) == 'U' && !isDead) {
				if (playerRow == 0) {
					isFree = true;
					arr2[playerRow][playerCol] = '.';
				} else if (arr[playerRow - 1][playerCol] == 'B') {
					arr2[playerRow][playerCol] = '.';
					isDead = true;
					playerRow--;

				} else {
					arr2[playerRow - 1][playerCol] = 'P';
					arr2[playerRow][playerCol] = '.';
					playerRow--;
				}

			} else if (inp.charAt(i) == 'D' && !isDead) {
				if (playerRow == rows - 1) {
					isFree = true;
					arr2[playerRow][playerCol] = '.';
				} else if (arr[playerRow + 1][playerCol] == 'B') {
					arr2[playerRow][playerCol] = '.';
					isDead = true;
					playerRow++;

				} else {
					arr2[playerRow + 1][playerCol] = 'P';
					arr2[playerRow][playerCol] = '.';
					playerRow++;
				}

			}

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (arr[r][c] == 'B') {
						if (r == 0 && c < cols - 1 && c > 0) {

							arr2[r + 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							arr2[r][c + 1] = 'B';
							continue;

						} else if (r == rows - 1 && c < cols - 1 && c > 0) {

							arr2[r - 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							arr2[r][c + 1] = 'B';
							continue;

						} else if (c == 0 && r > 0 && r < rows - 1) {

							arr2[r - 1][c] = 'B';
							arr2[r + 1][c] = 'B';
							arr2[r][c + 1] = 'B';
							continue;

						} else if (c == cols - 1 && r < rows - 1 && r > 0) {

							arr2[r - 1][c] = 'B';
							arr2[r + 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							continue;

						} else if (r == 0 && c == 0) {

							arr2[r + 1][c] = 'B';
							arr2[r][c + 1] = 'B';
							continue;

						} else if (r == rows - 1 && c == cols - 1) {

							arr2[r - 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							continue;

						} else if (r == rows - 1 && c == 0) {

							arr2[r - 1][c] = 'B';
							arr2[r][c + 1] = 'B';
							continue;

						} else if (r == 0 && c == cols - 1) {

							arr2[r + 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							continue;

						} else {
							arr2[r + 1][c] = 'B';
							arr2[r][c - 1] = 'B';
							arr2[r - 1][c] = 'B';
							arr2[r][c + 1] = 'B';

						}
					}
				}
			}
			arr = copy(arr2, rows, cols);

			if (arr[playerRow][playerCol] == 'B' && !isFree) {
				isDead = true;
			}

			if (isDead || isFree) {

				if (isDead) {

					print(arr);
					System.out.println("dead: " + playerRow + " " + playerCol);
					break;
				} else if (isFree) {

					print(arr);
					System.out.println("won: " + playerRow + " " + playerCol);
					break;
				}
			}

		}
		sc.close();
	}

	public static void print(char[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}

	}

	public static char[][] copy(char[][] arr, int rows, int cols) {
		char[][] newArr = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			newArr[i] = arr[i].clone();
		}
		return newArr;
	}
}
