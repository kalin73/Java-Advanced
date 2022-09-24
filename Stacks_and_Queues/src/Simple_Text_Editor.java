import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Text_Editor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringBuilder text = new StringBuilder("");
		ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			int command = Integer.parseInt(input[0]);
			if (command == 1) {
				String argument = input[1];

				stack.push(new StringBuilder(text));

				text.append(argument);

			} else if (command == 2) {
				int erase = Integer.parseInt(input[1]);

				stack.push(new StringBuilder(text));
				text = text.delete((text.length() - erase), text.length());

			} else if (command == 3) {

				int index = Integer.parseInt(input[1]);
				System.out.println(text.charAt(index - 1));

			} else {
				text = stack.pop();
			}
		}
		sc.close();

	}

}
