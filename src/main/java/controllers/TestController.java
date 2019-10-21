package controllers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping-pong")
@Produces(MediaType.APPLICATION_JSON)
public class TestController {


    @GET
    @Path("/")
    public Response getPingPong(){
        return Response.ok().entity("Ping Pong !!!").build();
    }
}