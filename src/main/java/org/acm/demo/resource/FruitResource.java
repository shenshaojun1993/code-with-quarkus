package org.acm.demo.resource;

import org.acm.demo.common.CustomResponse;
import org.acm.demo.common.MyException;
import org.acm.demo.model.Fruit;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/fruit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @GET
    @Path("list")
    public Response getAll() {
        return Response.ok(Fruit.findAll().list()).build();
    }

    @POST
    @Path("add")
    @Transactional
    public Response add(@Valid Fruit f) throws MyException {
        if (Fruit.findByNameAndDescription(f.name, f.description) == null) {
            Fruit.persist(f);
            return Response.ok(Fruit.findByNameAndDescription(f.name, f.description)).build();
        } else {
//            throw new MyException (String.format ("%s is already exists", f));
            return Response.ok(new CustomResponse(401, "Already exists")).build();
        }
    }

    @DELETE
    @Path("delete")
    @Transactional
    public Response delete(Integer id) {
        Fruit.deleteById(id);
        return Response.ok(Fruit.findAll()).build();
    }
}
