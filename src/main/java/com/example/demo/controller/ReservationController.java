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

import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ChauffeurRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.VoitureRepository;
import com.example.demo.service.ChauffeurService;
import com.example.demo.service.ClientService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.VoitureService;

@CrossOrigin("*")
@RestController
public class ReservationController {
	@Autowired
	private ReservationService service;
	@Autowired
	private ClientService repC;
	@Autowired
	private VoitureService repV;
	@Autowired
	private ChauffeurService repCh;
	
	@GetMapping("/reservation/all")
	private List<Reservation> list(){
		return service.listAll();
	}
	@GetMapping("/reservation/{id}")
	private ResponseEntity<Reservation> get(@PathVariable(name="id") Long id){
		try {
			Reservation reservation = service.get(id);
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/reservation/update/{id}")
	private Reservation update(@PathVariable(name="id") Long id,@RequestBody Reservation a) {
		return service.update(id, a);
	}
	
	@PostMapping("/reservation/add")
	private ResponseEntity<Reservation> add(@RequestBody Reservation r) {
		try {
			r.setClient(repC.get((Long)r.getCli()));
			r.setChauffeur(repCh.get((Long)r.getC()));
			r.setVoiture(repV.get((Long)r.getV()));
			System.out.println(r.toString());
			service.save(r);
			return new ResponseEntity<Reservation>(r,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Reservation>(r,HttpStatus.BAD_GATEWAY);
		}
	}
	@DeleteMapping("/reservation/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<Reservation>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
		}
		
	}

}
