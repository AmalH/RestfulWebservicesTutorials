package net.amalhichri.restsamples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello rest";
	}

	/*
	 * @GET
	 * 
	 * @Path("/{p1}/{p2}") public String sayHelloTo(@PathParam("p1") String
	 * from, @PathParam("p2") String to) { return "hello from " + from + " to "
	 * + to; }
	 * 
	 * @GET public String sayHelloToSecond(@QueryParam("p1") String
	 * from, @QueryParam("p2") String to) { if (from == null && to == null) {
	 * return "hello rest"; } return "hello second from " + from + " to " + to;
	 * }
	 */
}
