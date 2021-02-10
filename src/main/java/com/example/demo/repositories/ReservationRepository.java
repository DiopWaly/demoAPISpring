package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Reservation;

@CrossOrigin("*")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
