package com.librarymanagementsystem.webservice;

import com.librarymanagementsystem.beans.Client;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.ClientDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers")
public class CustomersRessource {

	private ClientDao customerService;
	private DaoFactory dao;
	
	public CustomersRessource()
	{
		dao = DaoFactory.getInstance();
		customerService = dao.getClientDao();
	}
	
  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response findOne(@PathParam("id") Long id) {
	  Client customer = null;
	
	    // ...
	
	    return Response.ok(customer).build();
  }
  
  @DELETE
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response deleteOne(@PathParam("id") Long id) {
	  boolean deleledRow = customerService.deleteOne(id);
	  if(deleledRow)
	  {
		  return Response.ok().build();
	  }
	  else {
		  return Response.status(400).entity("Client non trouvé avec id = "+id+" !!").build();
	  }
	
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON})
  public Response create(Client customer) {
	  customerService.create(customer);
	  return Response.status(201).entity(customer).build();
  }
}
