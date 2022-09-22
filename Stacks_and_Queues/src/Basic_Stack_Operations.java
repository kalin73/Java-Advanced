import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Basic_Stack_Operations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int n = nums[0];
		int s = nums[1];
		int x = nums[2];
		int diff = n - s;
		int min = Integer.MAX_VALUE;
		int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(z -> Integer.parseInt(z)).toArray();
		sc.close();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < diff; i++) {

			stack.push(numbers[i]);

		}
		if (stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		while (!stack.isEmpty()) {

			if (stack.peek() == x) {
				System.out.println(true);
				return;
			} else if (stack.peek() < min) {
				min = stack.pop();
				continue;
			}
			stack.pop();
		}
		System.out.println(min);
		
	}

}
