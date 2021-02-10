package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Modele implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String libelle;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Marque marque;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categorie categorie;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Annee annee;

	public Modele() {
	}

	public Modele(String libelle, Marque marque, Categorie categorie, Annee annee) {
		super();
		this.libelle = libelle;
		this.marque = marque;
		this.categorie = categorie;
		this.annee = annee;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	
}
