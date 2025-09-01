package iuh.fit.se.restapidemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/persons")
public class PersonResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}