package com.gestion.stock.services;

import java.util.List;

import com.gestion.stock.entities.LigneCommandeClient;

public interface ILigneCommandeClientService {

	public LigneCommandeClient save(LigneCommandeClient entity);

	public LigneCommandeClient update(LigneCommandeClient entity);

	public List<LigneCommandeClient> selectAll();

	public List<LigneCommandeClient> selectAll(String sortField, String sort);

	public void remove(Long id);

	public LigneCommandeClient getById(Long id);

	public LigneCommandeClient findOne(String paramName, Object paramValue);

	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);
	
	public List<LigneCommandeClient> getByIdCommande(long idCommandeClient);
}
