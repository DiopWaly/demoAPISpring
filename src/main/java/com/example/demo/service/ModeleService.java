	package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Modele;
import com.example.demo.repositories.ModelRepository;

@Service
public class ModeleService {
	@Autowired
	private ModelRepository rep;
	
	public List<Modele>listAll(){
		return rep.findAll();
	}
	
	public Modele get(Long id){
		return rep.findById(id).get();
	}
	
	public Modele update(Long id,Modele m) {
		m.setId(id);
		return rep.save(m);
	}
	
	public Modele save(Modele m) {
		return rep.save(m);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
}
