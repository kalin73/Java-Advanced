package linkedListTraversal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LnkdList<Integer> list = new LnkdList<>();

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String command = input[0];
			int number = Integer.parseInt(input[1]);

			switch (command) {
			case "Add":
				list.add(number);
				break;

			case "Remove":
				list.remove(number);
				break;
			}

		}

		System.out.println(list.size());
		list.forEach(x -> System.out.print(x + " "));
		
		sc.close();
	}

}
