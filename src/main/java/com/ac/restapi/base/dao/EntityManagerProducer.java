package com.ac.restapi.base.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer{


	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.ac.restapi");
	
	@Produces @RequestScoped
    protected EntityManager createEntityManager(){
        return factory.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager){
    	if (entityManager.isOpen())
            entityManager.close();
    }
}