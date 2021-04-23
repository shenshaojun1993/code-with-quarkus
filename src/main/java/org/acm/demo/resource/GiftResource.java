package org.acm.demo.resource;

import org.acm.demo.model.Gift;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class GiftResource {

    @GET
    @Path("/list")
    public Response hello() {
        return Response.ok(Gift.findAll().list()).build();
    }

    @POST
    @Path("/add")
    @Transactional
    public Response add(Gift gift) {
        Gift.persist(gift);
        return Response.ok(Gift.findAll().list()).build();
    }
}
