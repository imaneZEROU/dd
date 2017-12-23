package com.commerce.gestion.dao.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom ;
	private String login;
	private Double password;


	


	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getNom() {
		return nom;
	}







	public void setNom(String nom) {
		this.nom = nom;
	}







	public String getPrenom() {
		return prenom;
	}







	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}







	public String getLogin() {
		return login;
	}







	public void setLogin(String login) {
		this.login = login;
	}







	




	public Double getPassword() {
		return password;
	}







	public void setPassword(Double password) {
		this.password = password;
	}







	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	
	
	
}
