package org.acm.demo.resource;

import org.acm.demo.model.Fruit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public Response get() {
        return Response.ok(fruits).build();
    }

    @POST
    public Response add(Fruit f) {
        fruits.add(f);
        return Response.ok(fruits).build();
    }

    @DELETE
    public Response delete(Fruit f) {
        fruits.removeIf(single -> single.name.contentEquals(f.name));
        return Response.ok(fruits).build();
    }
}
