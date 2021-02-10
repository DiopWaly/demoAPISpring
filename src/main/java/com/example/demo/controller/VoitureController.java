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

import com.example.demo.entities.Voiture;
import com.example.demo.service.VoitureService;

@CrossOrigin("*")
@RestController
public class VoitureController {
	@Autowired
	private VoitureService service;
	
	@GetMapping("/voiture/all")
	private List<Voiture> list(){
		return service.listAll();
	}
	@GetMapping("/voiture/{id}")
	private ResponseEntity<Voiture> get(@PathVariable(name="id") Long id){
		try {
			Voiture voiture = service.get(id);
			return new ResponseEntity<Voiture>(voiture, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Voiture>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/voiture/update/{id}")
	private Voiture update(@PathVariable(name="id") Long id,@RequestBody Voiture v) {
		return service.update(id, v);
	}
	
	@PostMapping("/voiture/add")
	private ResponseEntity<Voiture> add(@RequestBody Voiture v) {
		try {
			service.save(v);
			return new ResponseEntity<Voiture>(v,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Voiture>(v,HttpStatus.BAD_GATEWAY);
		}
	}
	@DeleteMapping("/voiture/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Voiture>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Voiture>(HttpStatus.NOT_FOUND);
		}
		
	}

}
