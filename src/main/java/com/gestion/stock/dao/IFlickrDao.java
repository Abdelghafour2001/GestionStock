package com.gestion.stock.dao;

import java.io.InputStream;

public interface IFlickrDao {

	public String savePhoto(InputStream stream, String fileName) throws Exception;
	
}