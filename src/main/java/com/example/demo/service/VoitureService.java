package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Voiture;
import com.example.demo.repositories.VoitureRepository;

@Service
public class VoitureService {
	@Autowired
	private VoitureRepository rep;
	
	
	public List<Voiture> listAll(){
		return rep.findAll();
	}
	
	public Voiture get(Long id){
		return rep.findById(id).get();
	}
	
	public Voiture update(Long id,Voiture v) {
		v.setId(id);
		return rep.save(v);
	}
	
	public Voiture save(Voiture v) {
		return rep.save(v);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
