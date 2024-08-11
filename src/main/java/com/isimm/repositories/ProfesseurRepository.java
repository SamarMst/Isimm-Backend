package com.isimm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isimm.entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long>{
	Professeur findByEmail(String email);
	 Optional<Professeur> findOneByEmailAndPassword(String email, String password);
}