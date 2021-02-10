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

import com.example.demo.entities.Admin;
import com.example.demo.service.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/admin/all")
	private List<Admin> list(){
		return service.listAll();
	}
	@GetMapping("/admin/{id}")
	private ResponseEntity<Admin> get(@PathVariable(name="id") Long id){
		try {
			Admin admin = service.get(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/admin/update/{id}")
	private Admin update(@PathVariable(name="id") Long id,@RequestBody Admin a) {
		return service.update(id, a);
	}
	
	@PostMapping("/admin/add")
	private void add(@RequestBody Admin a) {
		service.save(a);
	}
	@DeleteMapping("/admin/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Admin>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		
	}

}
