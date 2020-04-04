package com.sid.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long>{
	public List<Produit> findByDesignation(String designation);
	
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercherproduits(@Param("x") String mc , Pageable pageable);
	
	public Page<Produit> findByDesignationContains(String mc,Pageable pageable);

}
