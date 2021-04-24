package org.acm.demo.common;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MyApplicationExceptionHandler implements ExceptionMapper<MyException> {
	@Override
	public Response toResponse(MyException exception)
	{
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}
}
