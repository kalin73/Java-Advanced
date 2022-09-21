import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Math_Potato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ArrayDeque<String> queue = new ArrayDeque<>();
		List<String> input = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
		int n = Integer.parseInt(sc.nextLine());
		int count = 0;
		int remove = 1;
		int primeCicle = 1;
		boolean isPrime = false;
		while (input.size() > 1) {
			if (primeCicle == 2) {
				isPrime = true;
			}
			for (int i = 2; i < primeCicle; i++) {
				if (!(primeCicle % i == 0)) {
					isPrime = true;
				} else {
					isPrime = false;
				}
			}
			if (count > input.size() - 1) {
				count = 0;

			}
			if (remove == n) {
				primeCicle++;
				remove = 0;
				if (isPrime) {
					System.out.println("Prime " + input.get(count));
				
				} else {
					System.out.println("Removed " + input.get(count));
					input.remove(count);
					
					count--;

				}

			}
			count++;
			remove++;
		}

		System.out.println("Last is " + input.get(0));
		sc.close();
	}

}
