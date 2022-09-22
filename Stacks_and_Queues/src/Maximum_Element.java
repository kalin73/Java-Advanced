import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_Element {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
			if (nums[0] == 1) {

				stack.push(nums[1]);

			} else if (nums[0] == 2) {

				stack.pop();

			} else {

				System.out.println(Collections.max(stack));

			}

		}
		sc.close();
	}

}
