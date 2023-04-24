package com.gestion.stock.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestion.stock.entities.Category;
import com.gestion.stock.services.ICategoryService;

@Controller
@RequestMapping(value="/categories")
public class CategoriesController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value="/")
	public String category(Model model) {
		List<Category> categories= categoryService.selectAll();
		if(categories == null) {
			categories= new ArrayList<Category>();	
		}
		model.addAttribute("categories", categories);
		return "categories/categories";
	}
	
	@RequestMapping(value="/new" , method= RequestMethod.GET )
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		
		return "categories/addCategories";
	}
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregCategory(Model model, Category category) {
			
			if(category.getIdCategory()!=null) {
				categoryService.update(category);
			}else {
				categoryService.save(category);
			}	
		return "redirect:/categories/";
	}
	
	@RequestMapping(value="/modifier/{idCategory}")
	public String editCategory(Model model, @PathVariable Long idCategory) {
		if(idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if(category != null  )
			{
				model.addAttribute("category",category);
			}				
			}		
		return "categories/addCategories";
	}
	
	@RequestMapping(value="/supprimer/{idCategory}")
	public String deleteCategory( Model model, @PathVariable Long idCategory ) {
		if(idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if(category != null  )
			{
				categoryService.remove(idCategory);
			}				
			}		
		return "redirect:/categories/";
	}
}
