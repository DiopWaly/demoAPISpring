package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;
import com.example.demo.repositories.CategoriRepository;

@Service
public class CategorieService {
	@Autowired
	private CategoriRepository rep;
	
	public List<Categorie> listAll(){
		return rep.findAll();
	}
	
	public Categorie get(Long id){
		return rep.findById(id).get();
	}
	
	public Categorie update(Long id,Categorie c) {
		c.setId(id);
		return rep.save(c);
	}
	
	public Categorie save(Categorie c) {
		return rep.save(c);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
