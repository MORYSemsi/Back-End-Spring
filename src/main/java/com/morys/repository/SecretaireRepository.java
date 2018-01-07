package com.morys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.morys.model.Secretaire;

@CrossOrigin()
@RepositoryRestResource
@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire,Integer>{
	
	

	
	
}

