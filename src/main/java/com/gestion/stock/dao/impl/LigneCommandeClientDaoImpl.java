package com.gestion.stock.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.gestion.stock.dao.ILigneCommandeClientDao;
import com.gestion.stock.entities.LigneCommandeClient;

public class LigneCommandeClientDaoImpl extends GenericDaoImpl<LigneCommandeClient> implements ILigneCommandeClientDao{

	@Override
	public List<LigneCommandeClient> getByIdCommande(long idCommandeClient) {
		String queryString="select lc from "+LigneCommandeClient.class.getSimpleName()+" lc where lc.cmdClient.idCommandeClient  = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x",idCommandeClient);
		return query.getResultList();
			}

}
