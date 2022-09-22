import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History_Upgrade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<>();
		ArrayDeque<String> stack2 = new ArrayDeque<>();
		String input = sc.nextLine();
		String currentUrl = "";
		int count = 1;
		while (!input.equals("Home")) {

			if (input.equals("back")) {
				if (stack.isEmpty()) {
					System.out.println("no previous URLs");
				} else {
					stack2.push(currentUrl);
					currentUrl = stack.pop();
					System.out.println(currentUrl);
				}

			} else if (input.equals("forward")) {

				if (stack2.isEmpty()) {
					System.out.println("no next URLs");
				} else {
					stack.push(currentUrl);
					currentUrl = stack2.pop();
					System.out.println(currentUrl);
				}

			} else if (count == 1) {
				currentUrl = input;
				System.out.println(currentUrl);
				count++;
			} else {

				stack.push(currentUrl);
				currentUrl = input;
				System.out.println(currentUrl);
				stack2.clear();
			}
			input = sc.nextLine();
		}
		sc.close();
	}

}
