package com.gestion.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class CommandeClient implements Serializable{
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long idCommandeClient;
	
	private String code;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommandeClient;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany(mappedBy="cmdClient",fetch = FetchType.EAGER)
	private List<LigneCommandeClient> ligneCommandeClient;
	
	@Transient
	private String ligneCommandeJson;
	
	@Transient
	private BigDecimal totalCommande;

	public CommandeClient() {
		
	}

	public long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Date getDateCommandeClient() {
		return dateCommandeClient;
	}

	public void setDateCommandeClient(Date dateCommandeClient) {
		this.dateCommandeClient = dateCommandeClient;
	}
	
	@JsonIgnore
	public List<LigneCommandeClient> getLigneCommandeClient() {
		return ligneCommandeClient;
	}

	public void setLigneCommandeClient(List<LigneCommandeClient> ligneCommandeClient) {
		this.ligneCommandeClient = ligneCommandeClient;
	}
	
	
public BigDecimal getTotalCommande() {
		totalCommande =BigDecimal.ZERO;
		if(!ligneCommandeClient.isEmpty()) {
			for(LigneCommandeClient ligneCmdClt:ligneCommandeClient) {
				BigDecimal totalLigne = ligneCmdClt.getQuantite().multiply(ligneCmdClt.getPrixUnitaire());
						totalCommande=totalCommande.add(totalLigne);
			}
		}
		
		return totalCommande;
	}
	
	public String getLigneCommandeJson() {
		if(!ligneCommandeClient.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(ligneCommandeClient);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public void setLigneCommandeJson(String ligneCommandeJson) {
		this.ligneCommandeJson = ligneCommandeJson;
	}

	public void setTotalCommande(BigDecimal totalCommande) {
		this.totalCommande = totalCommande;
	}

}
