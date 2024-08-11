package com.isimm.services;

import java.io.IOException;

import org.springframework.stereotype.Service;



import com.isimm.dto.LoginDTOProfesseur;
import com.isimm.dto.LoginResponseProfesseur;
import com.isimm.dto.ProfesseurDTO;
import com.isimm.dto.UpdateProfesseurtDTO;
import com.isimm.entities.Professeur;

@Service
public interface ProfesseurService {
	Professeur addProfesseur(ProfesseurDTO professeurDTO);

	LoginResponseProfesseur loginProfesseur(LoginDTOProfesseur loginDTOProfesseur);
	Professeur updateProfesseur(UpdateProfesseurtDTO professeurDTO);
	public Professeur updatesProfesseur(UpdateProfesseurtDTO updateProfesseurDTO, String email, String fileName) throws IOException;

}
