package com.gestion.stock.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.gestion.stock.dao.IFlickrDao;


public class FlickrDaoImpl implements IFlickrDao{
	
private Flickr flickr;
private UploadMetaData uploadMetaData = new UploadMetaData();
private String apiKey ="5ad8b943a91ab64b0da0ef73bbc93fea";
private String sharedSecret="c2c81200ab80d870";

private void connect() {
	flickr = new Flickr(apiKey,sharedSecret, new REST());
	Auth auth = new Auth();
	auth.setPermission(Permission.READ);
	auth.setToken("72157719298560211-07669a2c75e64f36");
	auth.setTokenSecret("845e3b40877fb1ef");
	RequestContext requestContext = RequestContext.getRequestContext();
	requestContext.setAuth(auth);
	flickr.setAuth(auth);
}

@Override 
public String savePhoto(InputStream photo, String title) throws Exception{
	connect();
	uploadMetaData.setTitle(title);
	String photoId = flickr.getUploader().upload(photo, uploadMetaData);
	return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
}

public void auth() {
	flickr = new Flickr(apiKey,sharedSecret, new REST());
	AuthInterface authInterface= flickr.getAuthInterface();
	org.scribe.model.Token token = authInterface.getRequestToken();
	System.out.println("token : "+token);
	String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
	System.out.println("Follow this URL to authorise yourself on Flickr");
	System.out.println(url);
	System.out.println("Paste in the token it gives you:");
	System.out.print(">>");
	
	String tokenKey = JOptionPane.showInputDialog(null);
	org.scribe.model.Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
	
	System.out.println("Auth success");
	Auth auth= null;
	try {
		auth = authInterface.checkToken(requestToken);
	}catch(FlickrException e) {
		e.printStackTrace();
	}
	///
	System.out.println("Token: "+ requestToken.getToken());
	System.out.println("Secret: "+ requestToken.getSecret());
	System.out.println("nsid: "+ auth.getUser().getId());
	System.out.println("Realname: "+ auth.getUser().getRealName());
	System.out.println("Username: "+ auth.getUser().getUsername());
	System.out.println("Permission: "+ auth.getPermission().getType());

}

}
