package collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListyIterator li = null;
		String[] input = sc.nextLine().split(" ");

		if (input.length > 1) {
			String[] names = Arrays.copyOfRange(input, 1, input.length);
			li = new ListyIterator(names);
		} else {
			li = new ListyIterator();
		}

		String command = sc.nextLine();

		while (!command.equals("END")) {
			try {
				switch (command) {
				case "HasNext":
					System.out.println(li.hasNext());
					break;

				case "Print":
					li.print();
					break;

				case "Move":
					System.out.println(li.move());
					break;

				case "PrintAll":
					li.printAll();
				}
			} catch (Exception ex) {
				System.out.println("Invalid Operation!");
			}
			command = sc.nextLine();
		}
		sc.close();
	}

}
