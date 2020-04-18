import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/helloworld")
public class HelloWorld {
    @GET
    @Produces("application/json")
    public String getMessage() {
        return "{\"title\":\"SOAP ok\"}";
    }
}