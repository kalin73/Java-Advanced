package strategypattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		TreeSet<Person> sortedByName = new TreeSet<>(new NameComparator());
		TreeSet<Person> sortedByAge = new TreeSet<>(new AgeComparator());

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			Person person = new Person(name, age);
			sortedByName.add(person);
			sortedByAge.add(person);
		}

		sortedByName.forEach(x -> System.out.println(x));
		sortedByAge.forEach(x -> System.out.println(x));
		sc.close();

	}

}
