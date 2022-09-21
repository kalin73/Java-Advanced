import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hot_Potato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<>();
		List<String> input = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
		int n = Integer.parseInt(sc.nextLine());
		int count = 0;
		int remove = 1;
		while (input.size() > 1) {

			if (count > input.size() - 1) {
				count = 0;
			}
			if (remove == n) {
				queue.offer(input.get(count));
				input.remove(count);
				remove = 0;
				count--;
			}
			count++;
			remove++;
		}
		queue.forEach(x -> System.out.println("Removed " + queue.pollFirst()));
		System.out.println("Last is " + input.get(0));
		sc.close();
	}

}
