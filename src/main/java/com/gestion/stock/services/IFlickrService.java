package com.gestion.stock.services;

import java.io.InputStream;

import org.springframework.stereotype.Component;
public interface IFlickrService {
	public String savePhoto(InputStream stream, String fileName) throws Exception;

}
