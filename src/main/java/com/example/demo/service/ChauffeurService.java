package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Chauffeur;
import com.example.demo.repositories.ChauffeurRepository;

@Service
public class ChauffeurService {
	@Autowired
	private ChauffeurRepository rep;
	
	
	public List<Chauffeur> listAll(){
		return rep.findAll();
	}
	
	public Chauffeur get(Long id){
		return rep.findById(id).get();
	}
	
	public Chauffeur update(Long id,Chauffeur c) {
		c.setId(id);
		return rep.save(c);
	}
	
	public Chauffeur save(Chauffeur c) {
		return rep.save(c);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
