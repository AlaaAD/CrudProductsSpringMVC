package com.sid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.dao.ProduitRepository;
import com.sid.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path = "/produits")
	public String produits(Model model,
			@RequestParam(name = "page",defaultValue = "0") int page,
			@RequestParam(name = "size",defaultValue = "5") int size,
			@RequestParam(name = "motCle",defaultValue = "") String mc) {
		Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("motCle", mc);
		model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
		model.addAttribute("pageProduits", pageProduits.getContent());
		
		return "produits";
	}
	@GetMapping(path = "/deleteProduits")
	public String delete(Long id ,int page,int size,String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/produits?page="+page+"&size="+size+"&motCle="+motCle;
	}

}
