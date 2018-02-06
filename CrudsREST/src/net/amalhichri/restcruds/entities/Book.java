package net.amalhichri.restcruds.entities;

/**
 * @author Amal
 *
 */
public class Book {
	
	private int isbn;
	private String title;
	private String authorName;
	private Shelf shelf;
	
	
	
	public Book() {
		super();
	}
	public Book(int isbn, String title, String authorName,Shelf shelf) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authorName = authorName;
		this.shelf=shelf;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Shelf getShelf() {
		return shelf;
	}
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", authorName=" + authorName + ", shelf=" + shelf + "]";
	}
	
	
	
	
	
}
