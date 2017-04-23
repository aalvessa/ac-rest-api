package com.ac.restapi.services;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.ac.restapi.business.ImageBusiness;
import com.ac.restapi.entity.Image;

import junit.framework.Assert;

@RunWith(CdiTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageBusinessTest   {
	
	@Inject
    private ImageBusiness imageBusiness;

	@Test
	public void _1_insertProduct(){
		
		Image image = new Image();
		image.setDescription("Image 1");		
		imageBusiness.create(image);
		List<Image> images = imageBusiness.getAllImages();
	
		Assert.assertEquals(1 , images.size());
	}
	
	@Test
	public void _2_getProducts(){
		
		List<Image> images = imageBusiness.getAllImages();
		
		Assert.assertEquals(1, images.size());
	}
	
	@Test
	public void _3_updateProduct(){
		
		List<Image> images = imageBusiness.getAllImages();		
		Image image = new Image();
		image.setId(images.get(0).getId());
		image.setDescription("Image 2");
		imageBusiness.update(image);		
		List<Image> imagesUpdated = imageBusiness.getAllImages();		
		
		Assert.assertEquals("Image 2", imagesUpdated.get(0).getDescription());		
	}
	
	@Test
	public void _4_deleteProduct(){
		
		List<Image> images = imageBusiness.getAllImages();
		imageBusiness.remove(images.get(0).getId());
		List<Image> imagesRemoved = imageBusiness.getAllImages();	
		
		Assert.assertEquals(0, imagesRemoved.size());		
	}

}
