package com.example.demo.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository rep;
	
	
	public List<Client> listAll(){
		return rep.findAll();
	}
	
	public Client get(Long id){
		return rep.findById(id).get();
	}
	
	public Client update(Long id,Client c) {
		c.setId(id);
		return rep.save(c);
	}
	
	public Client save(Client c) {
		return rep.save(c);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
	public Client login(Client c) {
		hashagepw(c);
		if(rep.findByEmailAndPassword(c.getEmail(),c.getPassword()) != null)
			return rep.findByEmailAndPassword(c.getEmail(),c.getPassword());
		else if(rep.findByTelAndPassword(c.getEmail(),c.getPassword()) != null)
			return rep.findByTelAndPassword(c.getEmail(),c.getPassword());
		else
			return rep.findByUserNameAndPassword(c.getEmail(),c.getPassword());
	}
	public void sauverImage(BufferedImage image, String nomImage) throws IOException {
		 File nomfichier = new File("profile/"+nomImage+".jpg");
		 ImageIO.write(image, "JPG", nomfichier);
	 }
	private void hashagepw(Client c){
		String password = c.getPassword();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff)+0x100, 16).substring(1));
			}
			c.setPassword(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
