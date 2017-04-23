package com.ac.restapi.base.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import com.ac.restapi.base.entity.EntityBase;


@RequestScoped
public class GenericDao {

	@Inject
	EntityManager entityManager;

	@Transactional
	public void insert(EntityBase entity){
		this.entityManager.persist(entity);
	}
	@Transactional
	public void update(EntityBase entity){
		this.entityManager.merge(entity);
	}
	@Transactional
	public void delete(EntityBase entity){		
		this.entityManager.remove(this.entityManager.find(entity.getClass(), entity.getId()));
	}
	@SuppressWarnings("unchecked")
	public List<? extends EntityBase> findAll(String query, Map<String, Object> parameters){
		
		Query hqlQuery;
		
		if(StringUtils.isEmpty(query))
			return new ArrayList<>();
			
		hqlQuery = this.entityManager.createQuery(query);
		
		if(parameters != null && !parameters.keySet().isEmpty()){
			for(String key : parameters.keySet()){
				hqlQuery.setParameter(key, parameters.get(key));
			}
		}
		List<? extends EntityBase> list = hqlQuery.getResultList(); 
		return 	list;
	}
	
	@SuppressWarnings("unchecked")
	public EntityBase findById(Class classz, long id){				
		return (EntityBase) this.entityManager.find(classz, id);	
	}
}