package org.acm.demo.resource;

import org.acm.demo.common.MyException;
import org.acm.demo.model.Friend;
import org.acm.demo.model.User;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@POST
	@Path("add")
	@Transactional
	public Response add(@Valid User user) throws MyException {
		user.persistAndFlush ();
		user.delete ();
		return Response.ok(user).build ();
	}

	@GET
	@Path ("list")
	@Transactional
	public Response list() throws MyException {
		return Response.ok (User.findAll ().list ()).build ();
	}

	@GET
	@Path ("{id}")
	public Response findById(Long id) {
		return Response.ok (User.findById (id)).build ();
	}

	@GET
	@Path("friend/{userId}")
	public Response findFriendsByUserid(Long userId) {
		return Response.ok (Friend.findByUserId (userId)).build ();
	}

	@GET
	@Path ("friend/list")
	public Response listFriends() {
		return Response.ok (Friend.findAll ().list ()).build ();
	}
}
