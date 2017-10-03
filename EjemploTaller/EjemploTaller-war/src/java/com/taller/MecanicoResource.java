package com.taller;

import com.google.gson.Gson;
import java.util.Map;
import javax.ejb.EJB;
import javax.validation.ValidationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mecanicos")
public class MecanicoResource {

    @Context
    private UriInfo context;
    
    @EJB
    private MecanicoBean mecanicoBean;
    
    private Gson gson;

    public MecanicoResource() {
        this.gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        Map json = gson.fromJson(content, Map.class);
        String nombre = (String) json.get("nombre");
        try {
            Mecanico mecanico = mecanicoBean.crearMecanico(nombre);
            return Response
                    .ok()
                    .status(Response.Status.CREATED)
                    .entity(gson.toJson(mecanico))
                    .build();
        } catch (InvalidDataException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson(ex))
                    .build();
        } catch (Exception ex) {
            return Response
                    .serverError()
                    .build();
            
        }
    }
    
}
