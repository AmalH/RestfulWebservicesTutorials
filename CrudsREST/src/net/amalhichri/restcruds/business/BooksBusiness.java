package net.amalhichri.restcruds.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.amalhichri.restcruds.entities.Book;
import net.amalhichri.restcruds.entities.Shelf;

public class BooksBusiness {
	
	List<Book> booksList;
	ShelfBusiness shelfBusiness=new ShelfBusiness();

	public BooksBusiness() {
		booksList=new ArrayList<Book>();
		booksList.add(new Book(1, "The Pragmatic Programmer"," Andy Hunt",shelfBusiness.getShelfById(2)));
		booksList.add(new Book(2, "Code Complete","Steve McConnell",shelfBusiness.getShelfById(3)));
		booksList.add(new Book(3, "The Art of Computer Programming","Donald Knuth",shelfBusiness.getShelfById(1)));
	}
	
	public boolean addBook(Book Book){
		int refShelf=Book.getShelf().getId();
		Shelf Shelf=shelfBusiness.getShelfById(refShelf);
		if(Shelf!=null){
			Book.setShelf(Shelf);
			return booksList.add(Book);
		}
		return false;
	}
	
	public boolean updateBook(int isbnBook, Book Book){
		for(Book r:booksList){
			if(r.getIsbn()==isbnBook){
				int index=booksList.indexOf(Book);
				Shelf Shelf=shelfBusiness.getShelfById(Book.getShelf().getId());
				if(Shelf!=null){
					booksList.set(index, Book);
					return true;
				}	
			}
		}
		return false;
	}
	
	public Book getBookById(int isbn){
		Book Book=null;
		for(Book r:booksList){
			if(r.getIsbn()==isbn)
				Book=r;
		}
		return Book;
	}
	
	public boolean deleteBook(int isbn){
		Iterator<Book> iterator=booksList.iterator();
		while(iterator.hasNext()){
			Book r=iterator.next();
			if(r.getIsbn()==isbn){
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public List<Book> getbooksList() {
		return booksList;
	}

	public void setbooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
	
	public List<Book> getbooksListByShelfId(int id) {
		List<Book> liste=new ArrayList<Book>();
		for(Book r:booksList){
			if(r.getShelf().getId()==id)
				liste.add(r);
		}
		return liste;
	}
}
