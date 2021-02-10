package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
public class Voiture implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 50)
	private String matricule;
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Modele modele;
	private String description;
	private float tarifjrne;
	private String capacite;
	private String air;
	private String options;
	private String conditions;
	private String image;

	public Voiture() {
		
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTarifjrne() {
		return tarifjrne;
	}

	public void setTarifjrne(float tarifjrne) {
		this.tarifjrne = tarifjrne;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public Voiture(Long id, String matricule, Modele modele, String description, float tarifjrne, String capacite,
			String air, String options, String conditions, String image) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.modele = modele;
		this.description = description;
		this.tarifjrne = tarifjrne;
		this.capacite = capacite;
		this.air = air;
		this.options = options;
		this.conditions = conditions;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", matricule=" + matricule + ", modele=" + modele + ", description=" + description
				+ ", tarifjrne=" + tarifjrne + ", capacite=" + capacite + ", air=" + air + ", options=" + options
				+ ", conditions=" + conditions + ", image=" + image + "]";
	}
	
	
}
