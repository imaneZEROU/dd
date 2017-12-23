package com.commerce.gestion.dao;
import java.util.List;

import com.commerce.gestion.dao.entity.Client;


public interface ClientDAO {
	
	public void add(Client e);
	public Client edite(Client e);
	public void delete (Long id);
	public List <Client> findAll();
	public Client findById(Long id);
	

}
