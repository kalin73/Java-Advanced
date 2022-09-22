import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Numbers_with_a_Stack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		for (int i = 0; i < numbers.length; i++) {

			stack.push(numbers[i]);

		}
		for (int i = 0; i < numbers.length; i++) {

			System.out.print(stack.pop() + " ");

		}
		sc.close();
	}

}
