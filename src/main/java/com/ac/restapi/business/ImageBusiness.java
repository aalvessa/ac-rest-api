package com.ac.restapi.business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ac.restapi.dao.ImageDao;
import com.ac.restapi.entity.Image;

@RequestScoped
public class ImageBusiness {
	
	public ImageBusiness() {
	
	}
	
	@Inject
	private ImageDao imageDao;
	
	public List<Image> getAllImages() {		
		return imageDao.findAll();
	}
	
	public void update (Image image){
		imageDao.update(image);
	}
	
	public Image create (Image image){
		imageDao.insert(image);
		return image;
	}
	
	public void remove (long id){
		imageDao.delete(new Image(id));
	}

}
