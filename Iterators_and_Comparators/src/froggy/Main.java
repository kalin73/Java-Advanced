package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();

		int[] input = Arrays.stream(sc.nextLine().split(", ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		sc.nextLine();

		Lake<Integer> lake = new Lake<>(input);
		int counter = 0;

		for (Integer i : lake) {
			if (lake.length() == 1) {
				System.out.println(i);
				sc.close();
				return;
			}
			if (counter % 2 == 0) {
				even.add(i);
				counter++;
				continue;
			}
			counter++;
			odd.add(i);
		}

		String result = even
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", ")) 
				+ ", "+ 
				odd
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", "));

		System.out.println(result);
		sc.close();

	}

}
