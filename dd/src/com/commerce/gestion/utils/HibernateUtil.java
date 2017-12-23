package com.commerce.gestion.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
public class HibernateUtil {
 private static SessionFactory sessionFactory = buildSessionFactory();
    //private static ServiceRegistry serviceRegistry;

 private static SessionFactory buildSessionFactory() {
  try {
  return new 
Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
   
    
  } catch (Throwable ex) {
  
   System.err.println("Initial SessionFactory creation failed." + ex);
   throw new ExceptionInInitializerError(ex);
  }
 }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session openSession(){
     return sessionFactory.openSession();
    }
    
    public Session getCurrentSession(){
     return sessionFactory.getCurrentSession();
    }
    
    public static void close(){
     if(sessionFactory != null){
      sessionFactory.close();
     }
     sessionFactory = null;
    }
    
}