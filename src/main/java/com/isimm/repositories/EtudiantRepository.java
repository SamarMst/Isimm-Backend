package com.isimm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.isimm.entities.Etudiant;

@EnableJpaRepositories
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	Etudiant findByEmail(String email);
	 Optional<Etudiant> findOneByEmailAndPassword(String email, String password);
}