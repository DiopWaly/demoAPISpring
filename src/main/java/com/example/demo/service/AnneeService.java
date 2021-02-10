package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Annee;
import com.example.demo.repositories.AnneeRepository;

@Service
public class AnneeService {
	@Autowired
	private AnneeRepository rep;
	
	
	public List<Annee> listAll(){
		return rep.findAll();
	}
	
	public Annee get(Long id){
		return rep.findById(id).get();
	}
	
	public Annee update(Long id,Annee a) {
		a.setId(id);
		return rep.save(a);
	}
	
	public Annee save(Annee a) {
		return rep.save(a);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
