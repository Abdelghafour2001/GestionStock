package com.gestion.stock.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.stock.entities.Article;
import com.gestion.stock.entities.Client;
import com.gestion.stock.services.IArticleService;
import com.gestion.stock.services.IFlickrService;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IFlickrService flickerService ;
	
	@RequestMapping(value="/")
	public String article(Model model) {
		List<Article> articles= articleService.selectAll();
		if(articles == null) {
		articles= new ArrayList<Article>();	
		}
		model.addAttribute("articles", articles);
		return "article/article";
	}
	
	@RequestMapping(value="/new" , method= RequestMethod.GET )
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		
		return "article/addArticle";
	}
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregArticle(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if(article != null) {
			if(file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();					
					photoUrl = flickerService.savePhoto(stream, article.getCodeArticle());	
					article.setPhotos(photoUrl);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						stream.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(article.getIdArticle()!=null) {
				articleService.update(article);
			}else {
				articleService.save(article);
			}
			
		}	
		return "redirect:/article/";
	}
	
	@RequestMapping(value="/modifier/{idArticle}")
	public String editArticle(Model model, @PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			if(article != null  )
			{
				model.addAttribute("article",article);
			}				
			}		
		return "article/addArticle";
	}
	
	@RequestMapping(value="/supprimer/{idArticle}")
	public String deleteArticle(Model model, @PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			if(article != null  )
			{
				articleService.remove(idArticle);
			}				
			}		
		return "redirect:/article/";
	}
}
