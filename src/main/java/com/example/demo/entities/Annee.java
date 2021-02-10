package com.example.demo.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Annee implements Serializable {

//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	String dateStr = sdf.format(new Date());
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	@Column(unique = true, nullable = false)
	private int annee;
	
	public Annee(int annee) {
		super();
		this.annee = annee;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public Annee() {
	}

}
