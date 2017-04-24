package com.ac.restapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.map.annotate.JsonView;

import com.ac.restapi.base.entity.EntityBase;
import com.ac.restapi.json.util.Views;

@Entity
public class Product extends EntityBase{

	private static final long serialVersionUID = 1L;
	
	@JsonView(Views.Product.class)
	private String description;
	
	@JsonView(Views.ProductAndImages.class)
	@OneToMany(mappedBy = "product", targetEntity = Image.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Image> images;
		
	@ManyToOne(fetch=FetchType.LAZY)
	private Product parentProduct;
	
	@JsonView(Views.ProductAndChildProduct.class)
	@OneToMany(mappedBy = "parentProduct", targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> childProducts;
	
	public Product(long id) {
		this.setId(id);
	}
	
	public Product(){
		
	}		

	public Product getParentProduct() {
		return parentProduct;
	}

	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	public List<Product> getChildProducts() {
		return childProducts;
	}

	public void setChildProducts(List<Product> childProducts) {
		this.childProducts = childProducts;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addImage(Image image) {
		image.setProduct(this);
		this.getImages().add(image);
	}

}