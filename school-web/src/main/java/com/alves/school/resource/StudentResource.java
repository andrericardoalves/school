package com.alves.school.resource;

import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.alves.school.bo.StudentBO;
import com.alves.school.model.Student;

@Path("student")
public class StudentResource {

	@EJB
	private StudentBO bo;
	
	@POST
	@Path("/save")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response save(Student student){
	     bo.save(student);
       return Response.status(Response.Status.CREATED).build();
	}
	
	
	@GET
	@Path("/findById/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Integer id){
		return Response.status(200).entity(bo.findById(id)).build();
	}
	
	@GET
	@Path("/getAllStudents")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllStudents(){
		return Response.status(200).entity(bo.getAllStudents()).build();
	}
	
	@PUT
	@Path("/update")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response update(Student student){
		try {
			bo.update(student);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	     
	    return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/deleteById/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteById(@PathParam("id") Integer id){
		try {
			bo.deleteById(id);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.noContent().build();
	}
}
