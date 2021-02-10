package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Client;

@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {
	public Client findByEmailAndPassword(String email,String pwd);
	public Client findByTelAndPassword(String tel,String pwd);
	public Client findByUserNameAndPassword(String userName,String pwd);
	
	
}
