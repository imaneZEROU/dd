package com.commerce.gestion.service;

import java.util.List;
import com.commerce.gestion.dao.ClientDAOImpl;
import com.commerce.gestion.dao.ClientDAO;
import com.commerce.gestion.dao.entity.Client;
import com.commerce.gestion.service.ClientServices;

public class ClientServicesImpl implements ClientServices{
	
	ClientDAO dao = new ClientDAOImpl();

	@Override
	public void add(Client e) {
          dao.add(e);		
	}

	@Override
	public Client edite(Client e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
         dao.delete(id);		
	}

	@Override
	public List<Client> findAll() {

		return dao.findAll();
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
