package io.github.douglasjunior.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Douglas
 */
@Path("teste")
public class TesteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TesteResource
     */
    public TesteResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{\"mensagem\" : \"Web Service Funcionando!\"}";
    }
}
