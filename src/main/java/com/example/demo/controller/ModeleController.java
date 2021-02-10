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

import com.example.demo.entities.Modele;
import com.example.demo.service.ModeleService;

@CrossOrigin("*")
@RestController
public class ModeleController {
	@Autowired
	private ModeleService service;
	
	@GetMapping("/modele/all")
	private List<Modele> list(){
		return service.listAll();
	}
	@GetMapping("/modele/{id}")
	private ResponseEntity<Modele> get(@PathVariable(name="id") Long id){
		try {
			Modele modele = service.get(id);
			return new ResponseEntity<Modele>(modele, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Modele>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/modele/update/{id}")
	private Modele update(@PathVariable(name="id") Long id,@RequestBody Modele m) {
		return service.update(id, m);
	}
	
	@PostMapping("/modele/add")
	private void add(@RequestBody Modele m) {
		service.save(m);
	}
	@DeleteMapping("/modele/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Modele>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Modele>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
