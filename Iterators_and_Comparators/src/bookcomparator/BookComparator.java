package bookcomparator;

import java.util.Comparator;
import book.*;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		int compared = o1.getTitle().compareTo(o2.getTitle());

		if (compared == 0) {
			if (o1.getYear() > o2.getYear()) {
				return 1;

			} else if (o1.getYear() > o2.getYear()) {
				return -1;

			} else {
				return 0;
			}

		}
		return compared;
	}

}
