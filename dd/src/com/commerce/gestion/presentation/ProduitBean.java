package com.commerce.gestion.presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.primefaces.context.RequestContext;

import com.commerce.gestion.dao.entity.Client;
import com.commerce.gestion.service.ClientServices;
import com.commerce.gestion.service.ClientServicesImpl;

import com.commerce.gestion.utils.HibernateUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;




@ManagedBean (name="produitBean1")
@RequestScoped
public class ProduitBean {
	
	public Logger log = Logger.getLogger(ProduitBean.class);
	private ClientServices clientServices = new ClientServicesImpl();
	


//private boolean visible;

	private String success ;
	
	
	private String nom ;
	
	private String prenom ;


	private String login ;
	private String password ;

	private String envia ;

     private boolean showForm = true ; 
	
	private List<Client> clientList;
private String id;
private String operation ;
	
	
	static {
	
		System.out.println("block static !");
	}
	{
		System.out.println("block !");
	}
	
	
	public ProduitBean() {
		System.out.println("construct !");
	}
	@PostConstruct
	
	public void initBean() {
		System.out.println("Post Construct !");
         //showForm=false;
         
   
		
		
	
		
		clientList = clientServices.findAll();
		System.out.println("id :" +getParam("id"));
		System.out.println("operation :" +getParam("operation"));

		if("edit".equalsIgnoreCase(getParam("operation"))) {
			setOperation(getParam("operation"));
			Long id = null;
			Client client = null ;
			
			
			try {
				id=Long.valueOf(getParam("id"));
				setId(getParam("id"));
			}catch(Exception e ){
				
			}
			if(id != null) {
				client = clientServices.findById(id);
				if(client != null) {
					
					
					  nom = client.getNom();		
				  prenom = client.getPrenom();	
				  login = client.getLogin();
				  password =client.getPassword().toString();;
				
				  if(client.getPassword() !=null) {
					  password =client.getPassword().toString();
				  }
				  
				

					showForm = true;

				}
					
			}
			
			
		

		}

		
	}
	
	

	

 
	   
	
	public String getParam(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	     return params.get(name);
	     }

	//public void show() {
		
	//	visible=true;
	//}
	
public void hide() {
		
		showForm=false;
	}

	
	//public boolean isVisible() {
	//return visible;
//}
//public void setVisible(boolean visible) {
	//this.visible = visible;
	
//}

	public void showFormAction(ActionEvent e) {
		log.info("true");
		
		showForm =true;
		//visible=true;
	}

	public void cancelAction(ActionEvent e) {
		log.info("true");
		
		showForm =true;
		nom ="";
		prenom ="";
		login ="";
		password ="";
	
	}



		
		
	public void generateDescription(ActionEvent e) {

		String desc ="";
		desc += "le code est : " +nom + "<br/>";
		desc = desc + "le prix est : " +prenom  + "<br/>";
		
		showForm =true;

		prenom = desc;  
		nom ="";
		login ="";
		password="";
		addMessage("generer");

		
	}
	public void addProject(ActionEvent e) {

		//success ="";

		 if (!password.matches("[0-9]*")) {
			
           addMessageError("prix doit etre un nombre  !")		;
		}else {	
			
			log.error("les valeurs");
			
			log.info("nom: " + nom);
			log.info("prenom: " + prenom);
			log.info("login: " +login);
			log.info("password: " + password);
			
			
			Client p =null;
			
			System.out.println("addClient : " +operation+" - " + id);
			
			if("edit".equalsIgnoreCase(operation)){	
				p = clientServices.findById(new Long(id));
				System.out.println("edit" );

			}else{	
				p = new Client();
				System.out.println("new " );

			}
			
		
			
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setPassword(Double.valueOf(password));
			

			clientServices.add(p);
			
			//success ="bien ajoute";
			addMessage("Succeded");
			nom ="";
			prenom ="";
			password ="";
			login ="";
			
			id="";
			operation="";
			
			clientList = clientServices.findAll();

		}
			
	

	}
	
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public void deleteProject(ActionEvent e) {
		showForm =false;

		log.info("delete client");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> param = fc.getExternalContext().getRequestParameterMap();
		
		
		log.info("id :" +param.get("id"));
		log.info("nom :" +param.get("nom"));
		
		clientServices.delete(new Long(param.get("id")));
		clientList = clientServices.findAll();


	}

	
		
	
	public void saveDate(ActionEvent e) {
		
		log.info("le nom est :" + nom);
	}
	
	
	public ClientServices getClientServices() {
		return clientServices;
	}
	public void setClientServices(ClientServices clientServices) {
		this.clientServices = clientServices;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnvia() {
		return envia;
	}
	public void setEnvia(String envia) {
		this.envia = envia;
	}
	public List<Client> getClientList() {
		return clientList;
	}
	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

	//public void login() {
	//RequestContext context = RequestContext.getCurrentInstance();
	//	context.execute("swal('Login sucess!','Congrats !you are logged in',success')");
	//}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
 }
	
	public void addMessageError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}




