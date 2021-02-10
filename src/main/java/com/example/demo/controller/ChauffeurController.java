package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Chauffeur;
import com.example.demo.service.ChauffeurService;

@CrossOrigin("*")
@RestController
public class ChauffeurController {
	@Autowired
	private ChauffeurService service;
	
	@GetMapping("/chauffeur/all")
	private List<Chauffeur> list(){
		return service.listAll();
	}
	@GetMapping("/chauffeur/{id}")
	private ResponseEntity<Chauffeur> get(@PathVariable(name="id") Long id){
		try {
			Chauffeur chauffeur = service.get(id);
			return new ResponseEntity<Chauffeur>(chauffeur, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Chauffeur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/chauffeur/update/{id}")
	private Chauffeur update(@PathVariable(name="id") Long id,@RequestBody Chauffeur c) {
		return service.update(id, c);
	}
	
	@PostMapping("/chauffeur/add")
	private ResponseEntity<Chauffeur> add(@RequestBody Chauffeur c) {
		try {
			service.save(c);
			return new ResponseEntity<Chauffeur>(c,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Chauffeur>(c,HttpStatus.BAD_GATEWAY);
		}
	}
	@DeleteMapping("/chauffeur/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Chauffeur>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Chauffeur>(HttpStatus.NOT_FOUND);
		}
		
	}

}
