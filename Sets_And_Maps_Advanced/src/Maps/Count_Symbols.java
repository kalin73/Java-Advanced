package Maps;

import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		TreeMap<Character, Integer> charCount = new TreeMap<>();
		sc.close();
		
		for (int i = 0; i < input.length(); i++) {
			Character currChar = input.charAt(i);
			if (!charCount.containsKey(currChar)) {

				charCount.put(currChar, 1);
				continue;
			}
			charCount.put(currChar, charCount.get(currChar) + 1);

		}
		charCount.forEach((key, value) -> {
			System.out.printf("%s: %d time/s%n", key, value);
		});
	}

}
