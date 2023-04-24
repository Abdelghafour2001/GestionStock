package com.gestion.stock.services.imp;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.gestion.stock.dao.IFlickrDao;
import com.gestion.stock.services.IFlickrService;

@Component
public class FlickrServiceImp implements IFlickrService {

	
	private IFlickrDao flickrDao;
	

	private void setFlickrDao(IFlickrDao flickrDao) {
		this.flickrDao = flickrDao;
	}

	
	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		return flickrDao.savePhoto(stream, fileName);
	}


}