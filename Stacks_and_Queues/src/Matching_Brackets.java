import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sb = sc.nextLine();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		String expression = "";
		for (int i = 0; i < sb.length(); i++) {

			if (sb.charAt(i) == '(') {

				stack.push(i);

			} else if (sb.charAt(i) == ')') {

				expression = sb.substring(stack.pop(), i + 1);
				System.out.println(expression);
				expression = "";
			}

		}
		sc.close();
	}

}
