package com.sample;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class StoreData {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static int id = 2;
	
	public static synchronized int generateId()
	{
		return id++;
	}
	
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    SessionFactory factory = createSessionFactory();
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	    
	    Employee p1 = new Employee();
	    p1.setEmployeeID(generateId());
	    p1.setFirstName("Steve");
	    p1.setLastName("Beckle");
	    p1.setSSN("123-456-789");
	    p1.setYearsService(10);
	    
	    session.persist(p1);
	    t.commit();
	    session.close();
	    
	    System.out.println("Sucessfully saved");
	
	}
}
