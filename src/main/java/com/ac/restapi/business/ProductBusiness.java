package com.ac.restapi.business;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ac.restapi.dao.ProductDao;
import com.ac.restapi.entity.Image;
import com.ac.restapi.entity.Product;

@RequestScoped
public class ProductBusiness {
	
	@Inject
	ImageBusiness imageBusiness;
	
	public ProductBusiness() {
		
	}
	
	@Inject
	private ProductDao productDao;
	
	public List<Product> getAllProducts(){
		List<Product> products = productDao.findAll();
		return products;
	}
	
	public Product getProductById(long id){
		Product product = (Product) productDao.findById(Product.class, id);
		return product;
	}
	
	public Product create(Product product){
		updateImages(product);		
		productDao.insert(product);
		return product;
	}	
	
	public void update(Product product){
		updateImages(product);
		productDao.update(product);
	}
	
	public void remove(long id){
		productDao.delete(new Product(id));
	}
	
	private void updateImages(Product product) {
		if((product.getImages() != null) && !product.getImages().isEmpty()){
			List<Image> images = new ArrayList<>(product.getImages());
			product.setImages(new ArrayList<>());
			for(Image image : images){
				image = imageBusiness.findById(image.getId());
				product.addImage(image);
			}
		}
	}

}