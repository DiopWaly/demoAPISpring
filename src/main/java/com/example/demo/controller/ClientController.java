package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;

@CrossOrigin("*")
@RestController
public class ClientController {
	@Autowired
	private ClientService service;
	
	@GetMapping("/client/all")
	private List<Client> list(){
		return service.listAll();
	}
	@GetMapping("/client/{id}")
	private ResponseEntity<Client> get(@PathVariable(name="id") Long id){
		try {
			Client client = service.get(id);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/client/update/{id}")
	private Client update(@PathVariable(name="id") Long id,@RequestBody Client c) {
		return service.update(id, c);
	}
	
	@PostMapping("/client/add")
	private ResponseEntity<Client> add(@RequestBody Client c) {
		System.out.println(c.toString());
		try {
			service.save(c);
			return new ResponseEntity<Client>(c,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Client>(c,HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("/client/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Client>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping(value="/client/login")
	private Client login(@RequestBody Client c) {
		return service.login(c);
	}

}
