package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Admin implements Serializable  {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 50)
	private String nom;
	@Column(nullable = false, length = 50)
	private String prenom;
	@Column(nullable = false, length = 5)
	private String civilite;
	@Column(length = 50)
	private String mail;
	@Column(length = 15)
	private String tel;
	@Column(length = 50)
	private String userName;
	@Column(length = 50)
	private String password;

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

}
