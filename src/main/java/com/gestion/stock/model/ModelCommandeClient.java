package com.gestion.stock.model;

import java.util.Map;

import com.gestion.stock.entities.Article;
import com.gestion.stock.entities.Client;
import com.gestion.stock.entities.CommandeClient;
import com.gestion.stock.entities.LigneCommandeClient;

public interface ModelCommandeClient {

	void creerCommande(Client client);
	void modifierCommande(Client client);
	
	LigneCommandeClient ajouterLigneCommande(Article article);
	
	LigneCommandeClient supprimerLigneCommande(Article article);
	
	LigneCommandeClient modifierQuantite(Article article, double qte);
	
	String generateCodeCommande();
	 CommandeClient getCommande();
	 Map<Long, LigneCommandeClient> getLigneCde();
}
