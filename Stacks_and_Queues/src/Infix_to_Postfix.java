import java.util.ArrayDeque;
import java.util.Scanner;

public class Infix_to_Postfix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");

		ArrayDeque<String> outputQueue = new ArrayDeque<>();
		ArrayDeque<String> stack = new ArrayDeque<>();

		for (int i = 0; i < input.length; i++) {
			String currSymbol = input[i];

			if ("(".equals(currSymbol)) {
				stack.push(currSymbol);
				
			} else if (")".equals(currSymbol)) {
				popParentasise(outputQueue, stack);
				
			} else {
				pushNumberOrOperator(input, outputQueue, stack, i);
				
			}
		}
		popToQueue(outputQueue, stack);

		String result = String.join(" ", outputQueue);
		System.out.println(result);

		sc.close();
	}

	private static void popParentasise(ArrayDeque<String> outputQueue, ArrayDeque<String> stack) {
		String currOperator = stack.pop();

		while (!currOperator.equals("(")) {
			outputQueue.offer(currOperator);

			currOperator = stack.pop();
		}
	}

	private static void popToQueue(ArrayDeque<String> outputQueue, ArrayDeque<String> stack) {
		while (!stack.isEmpty()) {
			outputQueue.offer(stack.pop());
		}
	}

	private static void pushNumberOrOperator(String[] input, ArrayDeque<String> outputQueue, ArrayDeque<String> stack,
			int i) {
		if (Character.isDigit(input[i].charAt(0)) || Character.isAlphabetic(input[i].charAt(0))) {
			outputQueue.offer(input[i]);

		} else {
			if (!stack.isEmpty() && evaluatingPower(input, stack, i)) {
				outputQueue.offer(stack.pop());
			}
			stack.push(input[i]);
		}
	}

	private static String power(String operator) {
		if (operator.equals("+") || operator.equals("-")) {
			return "low";
		} else if (operator.equals("*") || operator.equals("/")) {
			return "high";
		}

		return "";
	}

	private static boolean evaluatingPower(String[] input, ArrayDeque<String> stack, int i) {
		if ((power(stack.peek()).equals("high") && power(input[i]).equals("low"))) {
			return true;

		}
		if (!power(input[i]).equals("") && (power(stack.peek()).equals(power(input[i])))) {
			return true;
		}
		return false;
	}
}
