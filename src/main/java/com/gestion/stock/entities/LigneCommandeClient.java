package com.gestion.stock.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommandeClient {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneCmdClt;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	@ManyToOne
	@JoinColumn(name="idCommandeClient")
	private CommandeClient cmdClient;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	

	
	public LigneCommandeClient () {
		
	}



	public Long getIdLigneCmdClt() {
		return idLigneCmdClt;
	}



	public void setIdLigneCmdClt(Long idLigneCmdClt) {
		this.idLigneCmdClt = idLigneCmdClt;
	}



	public BigDecimal getQuantite() {
		return quantite;
	}



	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}



	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}



	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	@JsonIgnore
	public CommandeClient getCmdClient() {
		return cmdClient;
	}



	public void setCmdClient(CommandeClient cmdClient) {
		this.cmdClient = cmdClient;
	}


	//@JsonIgnore
	public Article getArticle() {
		return article;
	}



	public void setArticle(Article article) {
		this.article = article;
	}
	
}
