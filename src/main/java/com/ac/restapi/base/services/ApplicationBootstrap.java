package com.ac.restapi.base.services;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ac.restapi.dao.ProductDao;
import com.ac.restapi.entity.Image;
import com.ac.restapi.entity.Product;

@ApplicationPath("/rest")
public class ApplicationBootstrap extends Application{
	
	public ApplicationBootstrap() {
	
	}
	
	@Inject
	ProductDao productDao;
	
	@Inject
	ProductDao imageDao;
	
	
	@PostConstruct
	private void init(){
		
	//	register(provider);
		
	/*	Product product = new Product();
		
		//product.setId(new Long(1));
		product.setDescription("product 1");
		
		Product product2 = new Product();
		
		//product2.setId(new Long(2));
		product2.setDescription("product 2");
		
		Product product3 = new Product();
		
		//product3.setId(new Long(3));
		product3.setDescription("product 3");
		
		Image image = new Image();
		//image.setId(new Long(1));
		image.setDescription("image 1");
		
		Image image2 = new Image();
		//image2.setId(new Long(2));
		image2.setDescription("image 2");
		
		productDao.insert(product);
		
		image.setProduct(product);
		image2.setProduct(product);
		
		imageDao.insert(image);
		imageDao.insert(image2);
		
		productDao.update(product);
				
		product2.setParentProduct(product);
		product3.setParentProduct(product);
		
		productDao.insert(product2);
		productDao.insert(product3);*/
	}
} 