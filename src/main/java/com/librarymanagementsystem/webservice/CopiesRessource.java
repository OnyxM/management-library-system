package com.librarymanagementsystem.webservice;

import com.librarymanagementsystem.beans.Exemplaire;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.ExemplaireDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/copies")
public class CopiesRessource {

	private ExemplaireDao exemplaireService;
	private DaoFactory dao;
	
	public CopiesRessource()
	{
		dao = DaoFactory.getInstance();
		exemplaireService = dao.getExemplaireDao();
	}
	
  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response findOne(@PathParam("id") Long id) {
	  Exemplaire copy = null;
	
	    // ...
	
	    return Response.ok(copy).build();
  }
  
  @DELETE
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response deleteOne(@PathParam("id") Long id) {
	  boolean deleledRow = exemplaireService.deleteOne(id);
	  if(deleledRow)
	  {
		  return Response.ok().build();
	  }
	  else {
		  return Response.status(400).entity("Exemplaire non trouvé avec id = "+id+" !!").build();
	  }
	
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON})
  public Response create(Exemplaire copy) {
	  exemplaireService.create(copy);
	  return Response.status(201).entity(copy).build();
  }
}
