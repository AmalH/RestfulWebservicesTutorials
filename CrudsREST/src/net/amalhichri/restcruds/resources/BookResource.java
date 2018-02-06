package net.amalhichri.restcruds.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.QueryParam;

import net.amalhichri.restcruds.business.BooksBusiness;
import net.amalhichri.restcruds.entities.Book;

@Path("books")
public class BookResource {

	static BooksBusiness booksBusiness = new BooksBusiness();

	/** POST **/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
		if (booksBusiness.addBook(book)) {
			for (Book b : booksBusiness.getbooksList()){
				System.out.println(b.getTitle());
			}
			return Response.status(Status.CREATED).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/** GET **/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		for (Book b : booksBusiness.getbooksList()){
			System.out.println(b.getTitle());
		}
		return booksBusiness.getbooksList();
		// return Response.status(Status.CREATED).build();
	}

	/** getBooksByShelf **/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooksByShelf(@QueryParam("shelfId") int shelfId) {
		List<Book> books = new ArrayList<Book>();
		if (shelfId == 0) {
			books = booksBusiness.getbooksList();
		} else {
			books = booksBusiness.getbooksListByShelfId(shelfId);
		}

		if (books.size() == 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(books).build();
	}
	
	/** getBooksById **/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response recupererRendezVousById(@PathParam("isbn") int isbn) {

		Book book = booksBusiness.getBookById(isbn);
		if (book == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(book).build();
	}
	
	/** delete book **/
	@DELETE
	@Path("{isbn}")
	public Response removeBookById(@PathParam("isbn") int isbn) {
		if(booksBusiness.deleteBook(isbn))
		{
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
	/** update book **/
	@PUT
	@Path("{isbn}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response modifierRendezVous(@PathParam("isbn") int isbn, Book book)
	{
		if(booksBusiness.updateBook(isbn, book))
		{
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

}
