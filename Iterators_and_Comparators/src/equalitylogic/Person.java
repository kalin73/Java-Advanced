package equalitylogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.name + " " + this.age;
	}
}
