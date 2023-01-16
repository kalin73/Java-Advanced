package library;

import java.util.Iterator;
import book.Book;

public class Library<T> implements Iterable<Book> {
	private Book[] books;

	public Library(Book... books) {

		this.books = books;
	}

	public Iterator<Book> iterator() {

		return new LibraryIterator();

	}

	public Book[] getBooks() {
		return books;
	}

	private final class LibraryIterator implements Iterator<Book> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < books.length;
		}

		@Override
		public Book next() {
			return books[index++];
		}

	}
}
