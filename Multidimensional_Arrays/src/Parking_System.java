
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking_System {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int r = input[0];
		int c = input[1];
		boolean[][] arr = new boolean[r][c];

		Map<Integer, Integer> map = new HashMap<>();
		String[] coordinates = sc.nextLine().split(" ");

		while (!coordinates[0].equals("stop")) {
			int start = Integer.parseInt(coordinates[0]);
			int spotRow = Integer.parseInt(coordinates[1]);
			int spotCol = Integer.parseInt(coordinates[2]);
			int distance = 1;
			distance += Math.abs(start - spotRow);

			if (arr[spotRow][spotCol] == false) {

				distance += spotCol;
				System.out.println(distance);
				arr[spotRow][spotCol] = true;
				map.put(spotRow, 1);
				coordinates = sc.nextLine().split(" ");
				continue;

			} else {
				int col1 = spotCol + 1;
				int col2 = spotCol - 1;

				if (map.get(spotRow) == c - 1) {
					System.out.printf("Row %d full%n", spotRow);
					coordinates = sc.nextLine().split(" ");
					continue;
				}
				while (true) {

					if (col2 > 0 && arr[spotRow][col2] == false) {
						arr[spotRow][col2] = true;
						distance += col2;
						System.out.println(distance);
						map.put(spotRow, map.get(spotRow) + 1);
						break;

					} else if (col1 < c && arr[spotRow][col1] == false) {
						distance += col1;
						System.out.println(distance);
						arr[spotRow][col1] = true;
						map.put(spotRow, map.get(spotRow) + 1);
						break;

					}
					col1++;
					col2--;
				}
			}
			coordinates = sc.nextLine().split(" ");
		}
		sc.close();
	}

}
