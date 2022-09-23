import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced_Parentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		String parentheses = sc.nextLine();
		sc.close();
		for (int i = 0; i < parentheses.length(); i++) {
			char c = parentheses.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(i);

			} else if ((c == ')' || c == ']' || c == '}') && stack.isEmpty()) {
				System.out.println("NO");
				return;
			} else if (parentheses.charAt(i) == '}' && parentheses.charAt(stack.peek()) == '{') {
				stack.pop();

			} else if (parentheses.charAt(i) == ']' && parentheses.charAt(stack.peek()) == '[') {
				stack.pop();

			} else if (parentheses.charAt(i) == ')' && parentheses.charAt(stack.peek()) == '(') {
				stack.pop();

			}

		}
		if (stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
