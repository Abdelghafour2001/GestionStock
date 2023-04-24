package com.gestion.stock.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.stock.dao.ILigneCommandeClientDao;
import com.gestion.stock.entities.LigneCommandeClient;
import com.gestion.stock.services.ILigneCommandeClientService;

@Transactional
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService {
	
	@Autowired
	private ILigneCommandeClientDao dao;

	public void setDao(ILigneCommandeClientDao dao) {
		this.dao = dao;
	}
	
	@Override
	public LigneCommandeClient save(LigneCommandeClient entity) {
		return dao.save(entity);
	}

	@Override
	public LigneCommandeClient update(LigneCommandeClient entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<LigneCommandeClient> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneCommandeClient> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);		
	}

	@Override
	public LigneCommandeClient getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public LigneCommandeClient findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	public ILigneCommandeClientDao getDao() {
		return dao;
	}

	@Override
	public List<LigneCommandeClient> getByIdCommande(long idCommandeClient) {
		
		return dao.getByIdCommande(idCommandeClient);
	}

	

}
