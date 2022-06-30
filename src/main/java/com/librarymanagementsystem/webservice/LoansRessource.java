package com.librarymanagementsystem.webservice;

import com.librarymanagementsystem.beans.Emprunt;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.EmpruntDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/loans")
public class LoansRessource {

	private EmpruntDao empruntService;
	private DaoFactory dao;
	
	public LoansRessource()
	{
		dao = DaoFactory.getInstance();
		empruntService = dao.getEmpruntDao();
	}
	
  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response findOne(@PathParam("id") Long id) {
	  Emprunt loan = null;
	
	    // ...
	
	    return Response.ok(loan).build();
  }
  
  @DELETE
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response deleteOne(@PathParam("id") Long id) {
	  boolean deleledRow = empruntService.deleteOne(id);
	  if(deleledRow)
	  {
		  return Response.ok().build();
	  }
	  else {
		  return Response.status(400).entity("Emprunt non trouvé avec id = "+id+" !!").build();
	  }
	
  }
  
  @PUT
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response updateOne(@PathParam("id") Long id, Emprunt loan) {
	  boolean updatedRow = empruntService.updateOne(id, loan);
	  if(updatedRow)
	  {
		  return Response.status(201).entity(loan).build();
	  }
	  else {
		  return Response.status(400).entity("Emprunt non trouvé avec id = "+id+" !!").build();
	  }
	
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON})
  public Response create(Emprunt loan) {
	  empruntService.create(loan);
	  return Response.status(201).entity(loan).build();
  }
}
