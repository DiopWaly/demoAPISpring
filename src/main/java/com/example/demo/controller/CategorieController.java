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

import com.example.demo.entities.Categorie;
import com.example.demo.service.CategorieService;

@CrossOrigin("*")
@RestController
public class CategorieController {
	@Autowired
	private CategorieService service;
	
	@GetMapping("/categorie/all")
	private List<Categorie> list(){
		return service.listAll();
	}
	@GetMapping("/categorie/{id}")
	private ResponseEntity<Categorie> get(@PathVariable(name="id") Long id){
		try {
			Categorie categorie = service.get(id);
			return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/categorie/update/{id}")
	private Categorie update(@PathVariable(name="id") Long id,@RequestBody Categorie a) {
		return service.update(id, a);
	}
	
	@PostMapping("/categorie/add")
	private void add(@RequestBody Categorie c) {
		service.save(c);
	}
	@DeleteMapping("/categorie/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Categorie>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
		}
		
	}

}
