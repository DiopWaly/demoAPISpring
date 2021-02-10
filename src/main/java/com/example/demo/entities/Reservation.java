package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
public class Reservation implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Client client;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Voiture voiture;
	
	@Column(nullable = false)
	private Date dateReservation;
	@Column(nullable = false)
	private Date dateRetour;
	private boolean withdriver;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Chauffeur chauffeur;
	private float tarif;
	private String lieudisposition;
	@Column(nullable = false)
	private Long cli;
	@Column(nullable = false)
	private Long c;
	@Column(nullable = false)
	private Long v;
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Voiture getVoiture() {
		return voiture;
	}


	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}


	public Date getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}


	public boolean isWithdriver() {
		return withdriver;
	}


	public void setWithdriver(boolean withdriver) {
		this.withdriver = withdriver;
	}


	public Chauffeur getChauffeur() {
		return chauffeur;
	}


	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}


	public float getTarif() {
		return tarif;
	}


	public void setTarif(float tarif) {
		this.tarif = tarif;
	}


	public String getLieudisposition() {
		return lieudisposition;
	}


	public void setLieudisposition(String lieudisposition) {
		this.lieudisposition = lieudisposition;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}


	public Reservation() {
	}

	public Long getCli() {
		return cli;
	}


	public void setCli(Long cli) {
		this.cli = cli;
	}


	public Long getC() {
		return c;
	}


	public void setC(Long c) {
		this.c = c;
	}


	public Long getV() {
		return v;
	}

	public void setV(Long v) {
		this.v = v;
	}


	public Reservation(Long id, Client client, Voiture voiture, Date dateReservation, Date dateRetour,
			boolean withdriver, Chauffeur chauffeur, float tarif, String lieudisposition) {
		this.id = id;
		this.client = client;
		this.voiture = voiture;
		this.dateReservation = dateReservation;
		this.dateRetour = dateRetour;
		this.withdriver = withdriver;
		this.chauffeur = chauffeur;
		this.tarif = tarif;
		this.lieudisposition = lieudisposition;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client=" + client + ", voiture=" + voiture + ", dateReservation="
				+ dateReservation + ", dateRetour=" + dateRetour + ", withdriver=" + withdriver + ", chauffeur="
				+ chauffeur + ", tarif=" + tarif + ", lieudisposition=" + lieudisposition + ", cli=" + cli + ", c=" + c
				+ ", v=" + v + "]";
	}

}
