package com.sid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.dao.ProduitRepository;
import com.sid.entities.Produit;

@SpringBootApplication
public class Tp4ThymeleafMvcApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp4ThymeleafMvcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0 ; i<9;i++) {
			
			produitRepository.save(new Produit(null,"Thinkpad T470S",4400,2));
			produitRepository.save(new Produit(null,"Thinkpad T480S",5500,3));
			produitRepository.save(new Produit(null,"ASUS XLD540",5100,6));
			produitRepository.save(new Produit(null,"HP PROBOOK",3200,5));
			produitRepository.save(new Produit(null,"Dell L",6100,9));
			produitRepository.save(new Produit(null,"Lenovo L5645D",4670,1));

		}
		
	
	}

}
