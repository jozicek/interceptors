package jozinko.interceptors.boundary;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("show")
@RequestScoped
public class InterceptorsResource {

    @GET
    @Log
    @Path("log")
    public Response log() {
        return Response.ok("logging interceptor in use").build();
    }

    @GET
    @Measure
    @Log
    @Path("measure")
    public Response measure() throws InterruptedException {
        Thread.sleep(2000);
        return Response.ok("measure delay interceptor in use").build();
    }

}
