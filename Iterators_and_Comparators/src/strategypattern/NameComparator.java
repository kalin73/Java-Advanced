package strategypattern;

import java.util.Comparator;

class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getName().length() > o2.getName().length()) {
			return 1;
			
		} else if (o1.getName().length() == o2.getName().length()) {
			return o1.getName().compareToIgnoreCase(o2.getName());
			
		}
		return -1;
	}

}
