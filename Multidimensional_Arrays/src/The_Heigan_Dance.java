import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class The_Heigan_Dance {
	private static int playerHP = 18500;
	private static int playerRow = 7;
	private static int playerCol = 7;
	private static final int CLOUD_DMG = 3500;
	private static final int ERUPTION_DMG = 6000;
	private static double heiganHp = 3000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();

		double damage = Double.parseDouble(sc.nextLine());
		boolean playerKilled = false;
		boolean heiganKilled = false;

		while (true) {
			heiganHp -= damage;
			String playerPosition = playerRow + " " + playerCol;
			if (list.contains(playerPosition)) {
				playerHP -= CLOUD_DMG;
				if (playerHP < 1) {
					playerKilled = true;
				}
			}
			if (heiganHp < 0) {
				heiganKilled = true;
			}

			if (heiganKilled && playerKilled) {
				System.out.println("Heigan: Defeated!");
				System.out.println("Player: Killed by Plague Cloud");
				break;

			} else if (heiganKilled && !playerKilled) {
				System.out.println("Heigan: Defeated!");
				System.out.println("Player: " + playerHP);
				break;

			} else if (!heiganKilled && playerKilled) {
				System.out.printf("Heigan: %.2f%nPlayer: Killed by Plague Cloud%n", heiganHp);
				break;
			}
			list.clear();

			String[] input = sc.nextLine().split(" ");
			int row = Integer.parseInt(input[1]);
			int col = Integer.parseInt(input[2]);
			String ability = input[0];

			switch (ability) {
			case "Cloud":
				spellHit(list, row, col);

				if (inDanger(list, playerPosition)) {
					playerMove(list, CLOUD_DMG);
				}
				if (playerHP < 1) {
					System.out.printf("Heigan: %.2f%nPlayer: Killed by Plague Cloud%n", heiganHp);
					System.out.println("Final position: " + playerRow + ", " + playerCol);
					return;
				}

				break;

			case "Eruption":
				spellHit(list, row, col);

				if (inDanger(list, playerPosition)) {
					playerMove(list, ERUPTION_DMG);
				}
				if (playerHP < 1) {
					System.out.printf("Heigan: %.2f%nPlayer: Killed by Eruption%n", heiganHp);
					System.out.println("Final position: " + playerRow + ", " + playerCol);
					return;
				}
				list.clear();
				break;

			default:
				throw new IllegalArgumentException("Invalid spell: " + ability);
			}
		}
		System.out.println("Final position: " + playerRow + ", " + playerCol);
		sc.close();
	}

	private static boolean valid(int row, int col) {
		if (row >= 0 && row < 15 && col >= 0 && col < 15) {
			return true;
		}
		return false;
	}

	private static boolean inDanger(List<String> list, String playerPosition) {
		if (list.contains(playerPosition)) {
			return true;
		}
		return false;
	}

	public static void playerMove(List<String> list, int dmg) {
		String playerPosition = "";

		if (valid(playerRow - 1, playerCol)) {
			playerPosition = (playerRow - 1) + " " + playerCol;
			if (!list.contains(playerPosition)) {
				playerRow--;
				return;
			}

		}
		if (valid(playerRow, playerCol + 1)) {
			playerPosition = playerRow + " " + (playerCol + 1);
			if (!list.contains(playerPosition)) {
				playerCol++;
				return;
			}

		}
		if (valid(playerRow + 1, playerCol)) {
			playerPosition = (playerRow + 1) + " " + playerCol;
			if (!list.contains(playerPosition)) {
				playerRow++;
				return;
			}

		}
		if (valid(playerRow, playerCol - 1)) {
			playerPosition = playerRow + " " + (playerCol - 1);
			if (!list.contains(playerPosition)) {
				playerCol--;
				return;
			}
		}
		playerHP -= dmg;
	}

	public static void spellHit(List<String> list, int row, int col) {
		String coordinates;
		for (int i = -1; i < 2; i++) {
			for (int k = -1; k < 2; k++) {
				if (valid(row + i, col + k)) {
					coordinates = (row + i) + " " + (col + k);
					list.add(coordinates);
				}
			}
		}
	}
}
