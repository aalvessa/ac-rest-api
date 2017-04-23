package com.ac.restapi.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.ac.restapi.base.dao.GenericDao;
import com.ac.restapi.entity.Image;

@RequestScoped
public class ImageDao extends GenericDao {
	
	public ImageDao() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Image> findAll() {
		return (List<Image>) this.findAll(" FROM Image ", null);
	}

}
