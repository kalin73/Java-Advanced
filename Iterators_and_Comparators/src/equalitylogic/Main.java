package equalitylogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		HashSet<Person> hashSet = new HashSet<>();
		TreeSet<Person> treeSet = new TreeSet<>(new PersonComparator());

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			Person person = new Person(name, age);
			hashSet.add(person);
			treeSet.add(person);
		}

		System.out.println(hashSet.size() + "\n" + treeSet.size());
		sc.close();
	}

}
