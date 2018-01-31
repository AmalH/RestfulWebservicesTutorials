package net.amalhichri.restcruds.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.amalhichri.restcruds.business.BooksBusiness;
import net.amalhichri.restcruds.entities.Book;

@Path("/books")
public class BookResource {
	
	BooksBusiness booksBusiness = new BooksBusiness();

	/** createBook **/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRdv(Book book){
		if (booksBusiness.addBook(book)) {
			return Response.status(Status.CREATED).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	/** getBook **/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Book> getBooks() {
		return booksBusiness.getbooksList();
	}
	
}
