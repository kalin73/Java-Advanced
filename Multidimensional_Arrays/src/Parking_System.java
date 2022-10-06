
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Parking_System {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int r = input[0];
		int c = input[1];
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> takenSpots = new HashSet<>();
		int[][] arr = new int[r][c];
		String[] coordinates = sc.nextLine().split(" ");

		while (!coordinates[0].equals("stop")) {
			int start = Integer.parseInt(coordinates[0]);
			int spotRow = Integer.parseInt(coordinates[1]);
			int spotCol = Integer.parseInt(coordinates[2]);
			int distance = 1;
			int newSpot = 0;
			distance += Math.abs(start - spotRow);
			int position = spotCol + spotRow;

			if (!takenSpots.contains(position)) {

				distance += spotCol;

				System.out.println(distance);
				map.put(spotRow, 1);
				takenSpots.add(position);
				coordinates = sc.nextLine().split(" ");
				continue;

			} else if (takenSpots.contains(position)) {

				if (map.get(spotRow) % 2 == 0) {
					newSpot = spotCol + (map.get(spotRow) / 2);

					if (newSpot < arr[0].length) {
						distance += newSpot;
						position = spotRow + newSpot;
						takenSpots.add(position);
						map.put(spotRow, map.get(spotRow) + 1);
						System.out.println(distance);

					}
				} else if (map.get(spotRow) % 2 != 0 ) {

					newSpot = spotCol - (map.get(spotRow) / 2) - 1;

					if (newSpot > 0) {
						distance += newSpot;
						position = spotRow + newSpot;
						takenSpots.add(position);
						map.put(spotRow, map.get(spotRow) + 1);
						System.out.println(distance);

					}

				} else {
					System.out.printf("Row %d full%n", spotRow);
				}

			}

			coordinates = sc.nextLine().split(" ");
		}

	}

}
