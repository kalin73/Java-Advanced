package comparingobjects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String town;

	@Override
	public int compareTo(Person o) {
		boolean compared = this.name.equals(o.getName());
		if (compared) {
			if (this.age == o.getAge()) {
				if (this.town.equals(o.getTown())) {
					return 1;
				}
			}
		}
		return -1;

	}

	public Person(String name, int age, String towng) {
		this.name = name;
		this.age = age;
		this.town = towng;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getTown() {
		return town;
	}

}
