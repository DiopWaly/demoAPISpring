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

import com.example.demo.entities.Annee;
import com.example.demo.service.AnneeService;

@CrossOrigin("*")
@RestController
public class AnneeController {
	@Autowired
	private AnneeService service;
	
	@GetMapping("/annee/all")
	private List<Annee> list(){
		return service.listAll();
	}
	@GetMapping("/annee/{id}")
	private ResponseEntity<Annee> get(@PathVariable(name="id") Long id){
		try {
			Annee annee = service.get(id);
			return new ResponseEntity<Annee>(annee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Annee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/annee/update/{id}")
	private Annee update(@PathVariable(name="id") Long id,@RequestBody Annee a) {
		return service.update(id, a);
	}
	
	@PostMapping("/annee/add")
	private ResponseEntity<Annee> add(@RequestBody Annee a) {
		try {
			service.save(a);
			return new ResponseEntity<Annee>(a,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Annee>(a,HttpStatus.BAD_GATEWAY);
		}
	}
	@DeleteMapping("/annee/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Annee>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Annee>(HttpStatus.NOT_FOUND);
		}
		
	}
}
