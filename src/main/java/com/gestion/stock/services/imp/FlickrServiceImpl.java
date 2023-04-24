package com.gestion.stock.services.imp;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.stock.dao.IFlickrDao;
import com.gestion.stock.services.IFlickrService;

public class FlickrServiceImpl implements IFlickrService {

	
	private IFlickrDao dao;
	
	
	private void setDao(IFlickrDao dao) {
		this.dao=dao;
	}
	
	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		// TODO Auto-generated method stub
		return dao.savePhoto(stream, fileName);
	}

}
