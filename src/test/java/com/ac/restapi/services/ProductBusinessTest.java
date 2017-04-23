package com.ac.restapi.services;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.ac.restapi.business.ProductBusiness;
import com.ac.restapi.entity.Product;

import junit.framework.Assert;

@RunWith(CdiTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductBusinessTest   {
	
	@Inject
    private ProductBusiness productBusiness;

	@Test
	public void _1_insertProduct(){
		
		Product product = new Product();
		product.setDescription("Product 1");		
		productBusiness.create(product);
		List<Product> products = productBusiness.getAllProducts();
		
		Assert.assertEquals( 1, products.size());
	}
	
	@Test
	public void _2_getProducts(){
		
		List<Product> products = productBusiness.getAllProducts();
		
		Assert.assertEquals(1, products.size());
	}
	
	@Test
	public void _3_updateProduct(){
		
		List<Product> products = productBusiness.getAllProducts();			
		Product product = new Product();
		product.setId(products.get(0).getId());
		product.setDescription("Product 2");
		productBusiness.update(product);		
		List<Product> productsUpdated = productBusiness.getAllProducts();		
		
		Assert.assertEquals("Product 2", productsUpdated.get(0).getDescription());		
	}
	
	@Test
	public void _4_deleteProduct(){
		
		List<Product> products = productBusiness.getAllProducts();			
		productBusiness.remove(products.get(0).getId());
		List<Product> productsRemoved = productBusiness.getAllProducts();	
		
		Assert.assertEquals(0, productsRemoved.size());		
	}

}
