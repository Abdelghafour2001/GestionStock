package com.gestion.stock.dao;

import java.util.List;

import com.gestion.stock.entities.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient>{
	public List<LigneCommandeClient> getByIdCommande(long idCommandeClient);
}
