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

import com.gestion.stock.entities.Client;
import com.gestion.stock.entities.Fournisseur;
import com.gestion.stock.services.IClientService;
import com.gestion.stock.services.IFlickrService;
import com.gestion.stock.services.IFournisseurService;

@Controller
@RequestMapping(value="/fournisseur")
public class FournisseurController {
	
	@Autowired
	private IFournisseurService fournisseurService;
	
	@Autowired
	private IFlickrService flickerService ;
	
	@RequestMapping(value="/")
	public String fournisseur(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs == null) {
			fournisseurs= new ArrayList<Fournisseur>();	
		}
		model.addAttribute("fournisseurs", fournisseurs);
		return "fournisseur/fournisseur";
	}
	
	@RequestMapping(value="/new" , method= RequestMethod.GET )
	public String addFournisseur(Model model) {
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur", fournisseur);
		
		return "fournisseur/addFournisseur";
	}
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregFournisseur(Model model, Fournisseur fournisseur, MultipartFile file) {
		String photoUrl = null;
		if(fournisseur != null) {
			if(file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();					
					photoUrl = flickerService.savePhoto(stream, fournisseur.getNom());	
					fournisseur.setPhoto(photoUrl);
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
			
			if(fournisseur.getIdFournisseur()!=null) {
				fournisseurService.update(fournisseur);
			}else {
				fournisseurService.save(fournisseur);
			}
			
		}	
		return "redirect:/fournisseur/";
	}
	
	@RequestMapping(value="/modifier/{idFournisseur}")
	public String editFournisseur(Model model, @PathVariable Long idFournisseur) {
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null  )
			{
				model.addAttribute("fournisseur",fournisseur);
			}				
			}		
		return "fournisseur/addFournisseur";
	}
	
	@RequestMapping(value="/supprimer/{idFournisseur}")
	public String deleteFournisseur(Model model, @PathVariable Long idFournisseur) {
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null  )
			{
				fournisseurService.remove(idFournisseur);
			}				
			}		
		return "redirect:/fournisseur/";
	}
	
}

