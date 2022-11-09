package book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private int year;
	private List<String> authors;

	public Book(String title, int year, String... author) {
		this.setTitle(title);
		this.setYear(year);
		authors = new ArrayList<>();
		this.setAuthors(author);
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	private void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	private void setAuthors(String... author) {
		for (String s : author) {
			this.authors.add(s);
		}

	}

	public List<String> getAuthors() {
		return authors;
	}

	@Override
	public String toString() {

		return String.format("%s year %d.",this.title,this.year);
	}
}
