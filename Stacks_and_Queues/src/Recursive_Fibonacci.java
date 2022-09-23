import java.util.ArrayDeque;
import java.util.Scanner;

public class Recursive_Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<Long> stack = new ArrayDeque<>();
		System.out.println(fibonacci(stack, n));
		sc.close();
	}

	public static Long fibonacci(ArrayDeque<Long> fibonacci, long n) {
		if (n < 2) {
			return 1l;
		} else {
			fibonacci.offer(0L);
			fibonacci.offer(1L);
			for (int i = 0; i < n; i++) {
				long Sum = fibonacci.poll() + fibonacci.peek();
				fibonacci.offer(Sum);
			}
		}
		fibonacci.poll();
		return fibonacci.peek();
	}
}
