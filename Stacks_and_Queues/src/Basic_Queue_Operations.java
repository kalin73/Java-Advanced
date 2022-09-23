import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Basic_Queue_Operations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int n = nums[0];
		int s = nums[1];
		int x = nums[2];
		int min = Integer.MAX_VALUE;
		int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(z -> Integer.parseInt(z)).toArray();
		sc.close();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			queue.offer(numbers[i]);
		}
		for (int i = 0; i < s; i++) {
			queue.poll();
		}
		if (queue.isEmpty()) {

			System.out.println(0);
			return;

		}
		while (!queue.isEmpty()) {

			if (queue.peek() == x) {

				System.out.println(true);
				return;
			} else if (queue.peek() < min) {

				min = queue.poll();
				continue;
			}
			queue.poll();

		}
		System.out.println(min);

	}

}
