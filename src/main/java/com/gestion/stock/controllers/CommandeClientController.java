package com.gestion.stock.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.stock.entities.Article;
import com.gestion.stock.entities.Client;
import com.gestion.stock.entities.CommandeClient;
import com.gestion.stock.entities.LigneCommandeClient;
import com.gestion.stock.model.ModelCommandeClient;
import com.gestion.stock.services.IArticleService;
import com.gestion.stock.services.IClientService;
import com.gestion.stock.services.ICommandeClientService;
import com.gestion.stock.services.ILigneCommandeClientService;

@Controller
@RequestMapping(value="/cmdclient")
public class CommandeClientController {
	
	@Autowired
	private ICommandeClientService commandeClientService;
	
	@Autowired
	private ILigneCommandeClientService ligneCmdCltService;
	
	@Autowired
	private IClientService clientService;
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ModelCommandeClient modelCommande;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/")
	public String index(Model model) {
		List<CommandeClient> commandesClient = commandeClientService.selectAll();
		if(commandesClient.isEmpty()) {
			commandesClient = new ArrayList<CommandeClient>();
		}else {
			for(CommandeClient commandeClient:commandesClient) {
				List<LigneCommandeClient> lignecde = ligneCmdCltService.getByIdCommande(commandeClient.getIdCommandeClient());
				commandeClient.setLigneCommandeClient(lignecde);
			}
		}
		model.addAttribute("cmdclients", commandesClient);
		
		return "cmdclient/cmdclient";
	}
	
	@RequestMapping(value="/new")
	public String nouvelleCommande(Model model) {
		List<Client> clients = clientService.selectAll();
		if(clients.isEmpty()) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		model.addAttribute("codeCde",modelCommande.generateCodeCommande());
		model.addAttribute("dateCde",new Date());
		return "cmdclient/addcmdclient";
	}
	
	@RequestMapping(value="/creerCommande", method=RequestMethod.GET)
	public @ResponseBody String creerCommande(final Long idClient) throws JsonProcessingException {
		if(idClient==null) {
			return null;
		}
		Client client = clientService.getById(idClient);
		if(client == null) {
			return null;
		}
		modelCommande.creerCommande(client);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString("created");
		return jsonString;
	}
	
	
	
	@RequestMapping(value="/ajouterLigne")
	
	public @ResponseBody String getArticleById(final String codeArticle) throws JsonProcessingException {
		if(codeArticle ==null) {
			return null;
		}
		Article article = articleService.findOne("codeArticle",""+codeArticle);
		if(article ==null) {
			return null;
		}
		//LigneCommandeClient lignecde =ligneCmdCltService.findOne("idArticle", article.getIdArticle());
		LigneCommandeClient lignecde = modelCommande.ajouterLigneCommande(article);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lignecde);
		return jsonString;
	}
	
	
	@RequestMapping(value="/supprimerLigne", method=RequestMethod.GET)
	public @ResponseBody String supprimerLigne(final Long idArticle) throws JsonProcessingException {
		if(idArticle ==null) {
			return null;
		}
		Article article = articleService.getById(idArticle);
		if(article ==null) {
			return null;
		}
		
		modelCommande.supprimerLigneCommande(article);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString("deleted");
		return jsonString;
	}
	
	
}







