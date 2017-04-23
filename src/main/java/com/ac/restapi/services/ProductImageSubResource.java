package com.ac.restapi.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ac.restapi.business.ImageBusiness;
import com.ac.restapi.entity.Image;

@RequestScoped
public class ProductImageSubResource {
	
	public ProductImageSubResource() {
	
	}
	
	@Inject
	private ImageBusiness imageBusiness;
	
	@GET
	@Produces({"application/json"})
	public List<Image> getImages() {		
		return imageBusiness.getAllImages();
	}
	
	@PUT
	@Produces({"application/json"})
	public Response updateImage(Image image) {
		if(image.getId() == null)
			return Response.status(409).entity("Image must have an ID in update").build();
		
		imageBusiness.update(image);
		return Response.ok().entity("Updated sucessfully").build();
	}	
	
	@POST	
	@Produces({"application/json"})
	public Response insertImage(Image image) {
		if(image.getId() != null)
			return Response.status(409).entity("Image must not have an ID in insert").build();
			
		image = imageBusiness.create(image);
		return Response.status(201).entity("Resource created sucessfully : product/image/"+image.getId()).build();
	}	
	
	@DELETE
	@Path("{id}")
	@Produces({"application/json"})
	public Response deleteImage(@PathParam("id") long id) {
		imageBusiness.remove(id);
		return Response.ok().entity("Deleted sucessfully").build();
	}		

}
