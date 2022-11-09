package comparablebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
	private String title;
	private int year;
	private List<String> authors;

	public Book(String title, int year, String... author) {
		this.setTitle(title);
		this.setYear(year);
		this.setAuthors(author);

	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	private void setYear(int year) {
		this.year = year;
	}

	public List<String> getAuthors() {
		return authors;
	}

	private void setAuthors(String... author) {
		if (author.length == 0) {
			authors = new ArrayList<>(Arrays.asList());
		} else {
			authors = new ArrayList<>(Arrays.asList(author));
		}

	}

	@Override
	public int compareTo(Book o) {
		int compared = this.getTitle().compareTo(o.getTitle());

		if (compared == 0) {
			if (this.getYear() > o.getYear()) {
				return 1;

			} else if (this.getYear() > o.getYear()) {
				return -1;

			} else {
				return 0;
			}

		}
		return compared;
	}

	@Override
	public String toString() {
		return this.title;
	}

}
