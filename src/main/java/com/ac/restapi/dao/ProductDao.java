package com.ac.restapi.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.ac.restapi.base.dao.GenericDao;
import com.ac.restapi.entity.Product;

@RequestScoped
public class ProductDao extends GenericDao {
	
	public ProductDao() {
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return (List<Product>) this.findAll(" FROM Product ", null);
	}

}
