package com.librarymanagementsystem.webservice;

import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.DocumentDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/documents")
public class DocumentsRessource {

	private DocumentDao documentService;
	private DaoFactory dao;
	
	public DocumentsRessource()
	{
		dao = DaoFactory.getInstance();
		documentService = dao.getDocumentDao();
	}
	
  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response findOne(@PathParam("id") Long id) {
	  Document document = null;
	
	    // ...
	
	    return Response.ok(document).build();
  }
  
  @DELETE
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response deleteOne(@PathParam("id") Long id) {
	  boolean deleledRow = documentService.deleteOne(id);
	  if(deleledRow)
	  {
		  return Response.ok().build();
	  }
	  else {
		  return Response.status(400).entity("Document non trouvé avec id = "+id+" !!").build();
	  }
	
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON})
  public Response create(Document document) {
	  documentService.create(document);
	  return Response.status(201).entity(document).build();
  }
}
