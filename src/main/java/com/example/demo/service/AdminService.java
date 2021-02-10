package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository rep;
	
	public List<Admin> listAll(){
		return rep.findAll();
	}
	
	public Admin get(Long id){
		return rep.findById(id).get();
	}
	
	public Admin update(Long id,Admin a) {
		a.setId(id);
		return rep.save(a);
	}
	
	public Admin save(	Admin a) {
		return rep.save(a);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
