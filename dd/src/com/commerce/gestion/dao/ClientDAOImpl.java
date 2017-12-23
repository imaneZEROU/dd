package com.commerce.gestion.dao;

import java.util.List;

import org.hibernate.Session;

import com.commerce.gestion.dao.entity.Client;
import com.commerce.gestion.utils.HibernateUtil;

public class ClientDAOImpl implements ClientDAO {

	   Session sesion= HibernateUtil.openSession(); 

	@Override   
	public void add(Client e) {
 	
		sesion.beginTransaction();
		sesion.save(e);
		sesion.getTransaction().commit();
		
	}

	@Override
	public Client edite(Client e) {
		sesion.beginTransaction();
		Client p = (Client) sesion.merge(e);
		sesion.getTransaction().commit();		
		return p;
	}

	@Override
	public void delete(Long id) {
		
		sesion.beginTransaction();
		Client p = findById(id);
		sesion.delete(p);
		sesion.getTransaction().commit();		
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return sesion.createQuery("select o from Client o").list();
	}

	@Override
	public Client findById(Long id) {

		return (Client) sesion.get(Client.class, id);
	}
	
	
	

}
