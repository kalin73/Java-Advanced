package customListWithSorter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomList<String> list = new CustomList<>();

		String[] commands = sc.nextLine().split(" ");

		while (!"END".equals(commands[0])) {
			String command = commands[0];

			switch (command) {
			case "Add":
				String element = commands[1];
				list.add(element);
				break;

			case "Remove":
				int index = Integer.parseInt(commands[1]);
				list.remove(index);
				break;

			case "Contains":
				element = commands[1];
				System.out.println(list.contains(element));
				break;

			case "Swap":
				int index1 = Integer.parseInt(commands[1]);
				int index2 = Integer.parseInt(commands[2]);
				list.swap(index1, index2);
				break;

			case "Greater":
				element = commands[1];
				System.out.println(list.countGreaterThan(element));
				break;

			case "Max":
				System.out.println(list.getMax());
				break;

			case "Min":
				System.out.println(list.getMin());
				break;

			case "Print":
				list.print();
				break;

			case "Sort":
				Sorter.sort(list);
				break;

			default:
				break;
			}
			commands = sc.nextLine().split(" ");
		}
		sc.close();
	}
}
