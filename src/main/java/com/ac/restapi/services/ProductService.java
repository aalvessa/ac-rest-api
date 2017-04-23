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

import org.codehaus.jackson.map.annotate.JsonView;

import com.ac.restapi.business.ProductBusiness;
import com.ac.restapi.entity.Image;
import com.ac.restapi.entity.Product;
import com.ac.restapi.json.util.Views;

@RequestScoped
@Path("/product")
public class ProductService {
	
	public ProductService() {
		
	}
	
	@Inject
	private ProductBusiness productBusiness;
	
	@Inject 
	private ProductImageSubResource productImageSubResource;
	
	@JsonView(Views.Product.class)
	@GET
	@Produces({"application/json"})
	public List<Product> getProducts() {		
		return productBusiness.getAllProducts();
	}
	
	@JsonView(Views.Product.class)
	@GET
	@Path("{id}")
	@Produces({"application/json"})
	public Product getProduct(@PathParam("id") Long id) {
		return productBusiness.getProductById(id);
	}

	@JsonView(Views.ProductAndChildProduct.class)
	@GET
	@Path("/withChild")
	@Produces({"application/json"})
	public List<Product> getProductsWithChild() {
		return productBusiness.getAllProducts();
	}
	
	@JsonView(Views.ProductAndChildProduct.class)
	@GET
	@Path("/withChild/{id}")
	@Produces({"application/json"})
	public Product getProductWithChild(@PathParam("id") Long id) {
		return  productBusiness.getProductById(id);
	}
	
	@JsonView(Views.ProductAndChildProduct.class)
	@GET
	@Path("/children/{id}")
	@Produces({"application/json"})
	public List<Product> getProductChildren(@PathParam("id") Long id) {
		Product product =  productBusiness.getProductById(id);
		return product.getChildProducts();
	}
	
	@JsonView(Views.ProductAndImages.class)
	@GET
	@Path("/images/{id}")
	@Produces({"application/json"})
	public List<Image> getImages(@PathParam("id") Long id) {
		Product product =  productBusiness.getProductById(id);
		return product.getImages();
	}

	@JsonView(Views.ProductAndImages.class)
	@GET
	@Path("/withImages/")
	@Produces({"application/json"})
	public List<Product> getProductsWithImages() {
		return productBusiness.getAllProducts();
	}
	
	@JsonView(Views.ProductAndImages.class)
	@GET
	@Path("/withImages/{id}")
	@Produces({"application/json"})
	public Product getProductWithImages(@PathParam("id") Long id) {
		return productBusiness.getProductById(id);
	}	
	
	@PUT
	@Produces({"application/json"})
	public Response updateProduct(Product product) {
		if(product.getId() == null)
			return Response.status(409).entity("Product must have an ID in update").build();
		
		productBusiness.update(product);
		return Response.ok().entity("Updated sucessfully").build();
	}	
	
	@POST	
	@Produces({"application/json"})
	public Response insertProduct(Product product) {
		if(product.getId() != null)
			return Response.status(409).entity("Product must not have an ID in insert").build();
			
		productBusiness.create(product);
		return Response.status(201).entity("Resource created sucessfully : product/"+product.getId()).build();
	}	
	
	@DELETE
	@Path("{id}")
	@Produces({"application/json"})
	public Response deleteImage(@PathParam("id") long id) {
		productBusiness.remove(id);
		return Response.ok().entity("Deleted sucessfully").build();
	}		
	
	@Path("/image")
	public ProductImageSubResource getProductImageSubResource() {
		//List<Product> products = productDao.findAll();
		return this.productImageSubResource;
	}

}