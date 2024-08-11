package com.isimm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isimm.entities.Administration;

public interface AdministrationRepository extends JpaRepository<Administration, Long>{
	Administration findByEmail(String email);
	 Optional<Administration> findOneByEmailAndPassword(String email, String password);
}
