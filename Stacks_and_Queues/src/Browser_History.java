import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayDeque<String> urls = new ArrayDeque<>();

		while (!"Home".equals(input)) {

			if (input.equals("back")) {

				if (urls.size() < 2) {
					System.out.println("no previous URLs");
				} else {
					urls.pop();
					System.out.println(urls.peek());

				}
				input = sc.nextLine();
			} else {
				System.out.println(input);
				urls.push(input);
				input = sc.nextLine();
			}

		}
		sc.close();
	}

}
