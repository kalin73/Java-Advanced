import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer_Queue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<>();
		String input = sc.nextLine();

		while (!"print".equals(input)) {

			if (input.equals("cancel")) {
				if (queue.size() < 1) {
					System.out.println("Printer is on standby");
				} else {

					System.out.println("Canceled " + queue.pollFirst());

				}

			} else {

				queue.offer(input);

			}
			input = sc.nextLine();
		}
		queue.forEach(x -> System.out.println(queue.pollFirst()));
		sc.close();
	}

}
