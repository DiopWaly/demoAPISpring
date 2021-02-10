package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Marque;
import com.example.demo.repositories.MarqueRepository;

@Service
public class MarqueService {
	@Autowired
	private MarqueRepository rep;
	
	public List<Marque> listAll(){
		return rep.findAll();
	}

	public Marque get(Long id){
		return rep.findById(id).get();
	}
	
	public Marque update(Long id,Marque m) {
		m.setId(id);
		return rep.save(m);
	}
	
	public Marque save(Marque m) {
		return rep.save(m);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
