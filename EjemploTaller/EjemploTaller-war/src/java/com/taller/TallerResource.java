package com.taller;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("talleres")
@RequestScoped
public class TallerResource {

    @Context
    private UriInfo context;
    
    @EJB
    private TallerBean tallerBean;
    
    private Gson gson;

    public TallerResource() {
        this.gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        Taller taller = tallerBean.getTaller();
        return Response
                .ok()
                .entity(gson.toJson(taller))
                .build();
    }
    
}
