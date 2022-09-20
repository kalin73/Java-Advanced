import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		ArrayDeque<Integer> result = new ArrayDeque<>();
		for (int i = 0; i < input.length; i++) {
			if (Character.isDigit(input[i].charAt(0))) {

				result.push(Integer.parseInt(input[i]));

			} else if (input[i].charAt(0) == '+') {
				result.push(result.pop() + Integer.parseInt(input[i + 1]));
				i++;

			} else {
				result.push(result.pop() - Integer.parseInt(input[i + 1]));
				i++;
			}

		}
		System.out.println(result.pop());
		sc.close();
	}

}
