package com.ac.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.ac.restapi.base.entity.EntityBase;
import com.ac.restapi.json.util.Views;

@Entity
public class Image extends EntityBase {

	private static final long serialVersionUID = 1L;

	@JsonView(Views.Image.class)
	private String description;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	Product product;
	
	public Image(long id) {
		this.setId(id);
	}
	
	public Image() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}