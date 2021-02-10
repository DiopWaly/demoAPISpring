package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository rep;
	
	
	public List<Reservation> listAll(){
		return rep.findAll();
	}
	
	public Reservation get(Long id){
		return rep.findById(id).get();
	}
	
	public Reservation update(Long id,Reservation r) {
		r.setId(id);
		return rep.save(r);
	}
	
	public Reservation save(Reservation r) {
		return rep.save(r);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}

}
