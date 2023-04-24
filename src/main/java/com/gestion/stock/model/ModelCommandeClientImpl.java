package com.gestion.stock.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.gestion.stock.entities.Article;
import com.gestion.stock.entities.Client;
import com.gestion.stock.entities.CommandeClient;

import com.gestion.stock.entities.LigneCommandeClient;

@Component
public class ModelCommandeClientImpl implements ModelCommandeClient {

	private CommandeClient commande;
	
	private Map<Long, LigneCommandeClient> ligneCde = new HashMap<Long, LigneCommandeClient>();
	
	@Override
	public void creerCommande(Client client) {
		commande = new CommandeClient();
		commande.setDateCommandeClient(new Date());
		commande.setCode(generateCodeCommande());
	}

	@Override
	public LigneCommandeClient ajouterLigneCommande(Article article) {
		if(article==null) {
			return null;
		}
		LigneCommandeClient lc = getLigneCde().get(article.getIdArticle());
		if(lc !=null) {
			BigDecimal qte = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			getLigneCde().put(article.getIdArticle(), lc);
			return lc;
		}else {
			LigneCommandeClient ligne = new LigneCommandeClient();
			ligne.setCmdClient(getCommande());
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaire(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			getLigneCde().put(article.getIdArticle(), ligne);
			return ligne;
		}
	}

	@Override
	public LigneCommandeClient supprimerLigneCommande(Article article) {
	if(article==null) {
		return null;
	}
	return getLigneCde().remove(article.getIdArticle());
	}

	@Override
	public LigneCommandeClient modifierQuantite(Article article, double qte) {
		if(article==null) {
			return null;
		}
		LigneCommandeClient lc = getLigneCde().get(article.getIdArticle());
		if(lc==null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(qte));
		return lc;
	}

	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
	}
	@Override
	public CommandeClient getCommande() {
		return commande;
	}

	public void setCommande(CommandeClient commande) {
		this.commande = commande;
	}
	@Override
	public Map<Long, LigneCommandeClient> getLigneCde() {
		return ligneCde;
	}

	public void setLigneCde(Map<Long, LigneCommandeClient> ligneCde) {
		this.ligneCde = ligneCde;
	}

	@Override
	public void modifierCommande(Client client) {
		if(client==null) {
			return ;
		}
		if(commande !=null)
		{
			commande.setClient(client);
		}
		
	}
	
	

}
