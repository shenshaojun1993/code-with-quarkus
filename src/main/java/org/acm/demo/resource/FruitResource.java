package org.acm.demo.resource;

import org.acm.demo.model.Fruit;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/fruit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @GET
    @Path("/list")
    public Response getAll() {
        return Response.ok(Fruit.findAll()).build();
    }

    @POST
    @Path("/add")
    @Transactional
    public Response add(Fruit f) {
        if (Objects.isNull(Fruit.findByNameAndDescription(f.name, f.description))) {
            Fruit.persist(f);
            return Response.ok(Fruit.findByNameAndDescription(f.name, f.description)).build();
        } else {
            return Response.ok().build();
        }
    }

    @DELETE
    @Path("/delete")
    @Transactional
    public Response delete(Integer id) {
        Fruit.deleteById(id);
        return Response.ok(Fruit.findAll()).build();
    }
}
