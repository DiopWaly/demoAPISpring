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
import com.example.demo.entities.Marque;
import com.example.demo.service.MarqueService;

@CrossOrigin("*")
@RestController
public class MarqueController {
	@Autowired
	private MarqueService service;
	
	@GetMapping("/marque/all")
	private List<Marque> list(){
		return service.listAll();
	}
	@GetMapping("/marque/{id}")
	private ResponseEntity<Marque> get(@PathVariable(name="id") Long id){
		try {
			Marque marque = service.get(id);
			return new ResponseEntity<Marque>(marque, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Marque>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/marque/update/{id}")
	private Marque update(@PathVariable(name="id") Long id,@RequestBody Marque m) {
		return service.update(id, m);
	}
	
	@PostMapping("/marque/add")
	private void add(@RequestBody Marque m) {
		service.save(m);
	}
	@DeleteMapping("/marque/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Marque>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Marque>(HttpStatus.NOT_FOUND);
		}
		
	}


}
