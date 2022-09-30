package Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest_3_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> set = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(x -> Integer.parseInt(x))
				.sorted((f, s) -> s.compareTo(f)).collect(Collectors.toList()));

		sc.close();

		if (set.size() < 3) {
			set.forEach(x -> System.out.print(x + " "));
			return;
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(set.get(i) + " ");
		}

	}

}
