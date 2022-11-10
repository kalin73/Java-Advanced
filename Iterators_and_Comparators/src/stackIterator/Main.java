package stackIterator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		String[] command = sc.nextLine().split(" ");

		while (!"END".equals(command[0])) {
			try {
				switch (command[0]) {
				case "Pop":
					stack.pop();
					break;

				case "Push":
					Integer[] numbers = new Integer[command.length - 1];
					for (int i = 1; i < command.length; i++) {
						numbers[i - 1] = Integer.parseInt(command[i].replace(",", ""));
					}
					stack.push(numbers);
					break;
				}
			} catch (NullPointerException ex) {
				System.out.println("No elements");
			}
			command = sc.nextLine().split(" ");
		}
		print(stack);
		sc.close();
	}

	private static void print(Stack<Integer> stack) {
		for (int i = 0; i < 2; i++) {
			for (Integer in : stack) {
				System.out.println(in);
			}

		}
	}
}
