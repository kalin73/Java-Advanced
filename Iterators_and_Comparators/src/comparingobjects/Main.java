package comparingobjects;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		ArrayList<Person> people = new ArrayList<>();

		while (!"END".equals(input[0])) {
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			String town = input[2];
			Person person = new Person(name, age, town);
			people.add(person);
			input = sc.nextLine().split(" ");
		}

		int index = sc.nextInt();

		Person person = people.get(index - 1);

		compare(person, people);
		sc.close();
	}

	public static void compare(Person person, ArrayList<Person> people) {
		int equal = 0;
		int diff = 0;

		for (Person p : people) {
			if (p.compareTo(person) == 1) {
				equal++;
			}
		}

		diff = people.size() - equal;

		if (equal == 1) {
			System.out.println("No matches");
		} else {
			System.out.println(equal + " " + diff + " " + people.size());
		}
	}
}
