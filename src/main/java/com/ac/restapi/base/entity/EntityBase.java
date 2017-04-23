package com.ac.restapi.base.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonView;

import com.ac.restapi.json.util.Views;

@MappedSuperclass
@XmlTransient
public abstract class EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonView(Views.Entity.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

}