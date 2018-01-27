import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloResourceClient {

	public static void main(String[] args) {

		// create new JAX-RS client
		Client client = ClientBuilder.newClient();

		// the base url of the service
		WebTarget target = client.target("http://localhost:18080/HelloREST/rest");

		// consuming sayHello method
		WebTarget hello = target.path("hello");

		// get the response from the target url
		Response response = hello.request().get();

		// read the result as a string
		String result = response.readEntity(String.class);

		System.out.println("RESULTAT 1 " + result);
		response.close();

		/*********** Consommation d'une resource parametrée ********/
		/*** identifié par une url ***/

		WebTarget helloTo1 = target.path("hello").path("helloParam").path("p1").path("p2");
		Response response1 = helloTo1.request().get();
		String result1 = response1.readEntity(String.class);
		System.out.println("RESULTAT 2 " + result1);
		response1.close();

		/*** accessible via l'url ***/
		// building the relative URL manually for the sayHello2 method
		WebTarget helloTo2 = target.path("hello").path("helloParam2").queryParam("p1", "amal").queryParam("p2",
				"Ben foulen");
		// get the response from the target url
		Response response2 = helloTo2.request().get();
		// read the result as a string
		String result2 = response2.readEntity(String.class);
		// print the result to the standard output
		System.out.println("RESULTAT 3 " + result2);
		response2.close();

		// close client after consuming resources
		client.close();
	}

}
