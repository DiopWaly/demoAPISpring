package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Categorie implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}


	@Column(unique = true, nullable = false)
	private String categorie;

	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String libelle) {
		this.categorie = libelle;
	}


	public Categorie() {
	}

}
