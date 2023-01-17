import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] elements = in.nextLine().substring(7).split(", ");
		int[] coins = new int[elements.length];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(elements[i]);
		}

		int targetSum = Integer.parseInt(in.nextLine().substring(5));

		Map<Integer, Integer> usedCoins;
		try {
			usedCoins = chooseCoins(coins, targetSum);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			in.close();
			return;
		}

		for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
			System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
		}
		in.close();
	}

	public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
		Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

		coins = Arrays.stream(coins).boxed().sorted((f, s) -> s.compareTo(f)).mapToInt(Integer::intValue).toArray();

		for (int i : coins) {
			int numbOfCoins = targetSum / i;

			if (numbOfCoins != 0) {
				usedCoins.put(i, numbOfCoins);
				targetSum = targetSum % i;
			}

			if (targetSum == 0) {
				break;
			}

		}
		if (targetSum > 0) {
			throw new IllegalStateException("Error");
		}
		return usedCoins;
	}
}