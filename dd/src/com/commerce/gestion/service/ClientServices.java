package com.commerce.gestion.service;

import java.util.List;

import com.commerce.gestion.dao.entity.Client;

public interface ClientServices {

	
	public void add(Client e);
	public Client edite(Client e);
	public void delete (Long id);
	public List <Client> findAll();
	public Client findById(Long id);
	
	
}
