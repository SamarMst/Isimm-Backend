package com.isimm.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.isimm.dto.LoginDTOProfesseur;
import com.isimm.dto.LoginResponse;
import com.isimm.dto.LoginResponseProfesseur;
import com.isimm.dto.ProfesseurDTO;
import com.isimm.dto.UpdateProfesseurtDTO;
import com.isimm.entities.Professeur;
import com.isimm.repositories.ProfesseurRepository;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {
	    @Autowired
	    private ProfesseurRepository professeurRepo;

	    @Override
	    public Professeur addProfesseur(ProfesseurDTO professeurDTO) 
	       {
	    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
	    	String encryptedPwd = bcrypt.encode(professeurDTO.getPassword());
	    	Professeur professeur = new Professeur(
	    			professeurDTO.getCin_prof(),
	    			professeurDTO.getTelephone_prof(),
	    			professeurDTO.getNom_prof(),
	    			professeurDTO.getEmail(),
	    			professeurDTO.getDepartement(),
	    			professeurDTO.getTitre(),
	    			professeurDTO.getPassword()
	    			 );
	    	professeur.setPassword(encryptedPwd);
	    	professeurRepo.save(professeur);
	    	return professeur;
	       }
	    
	    
	    ProfesseurDTO professeurDTO;
	    @Override
	    public LoginResponseProfesseur  loginProfesseur(LoginDTOProfesseur loginDTO) {
	        String msg = "";
	        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	        Professeur professeur = professeurRepo.findByEmail(loginDTO.getEmail());
	        if (professeur != null) {
	        	if (bcrypt.matches(loginDTO.getPassword(), professeur.getPassword())) {
	                return new LoginResponseProfesseur("Login Success", true);
	            } else {
	                return new LoginResponseProfesseur("Login Failed", false);
	            }
	        } else {
	            return new LoginResponseProfesseur("Email not exists", false);
	        }
	    }
		@Override
		public Professeur updateProfesseur(UpdateProfesseurtDTO professeurDTO) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Professeur updatesProfesseur(UpdateProfesseurtDTO updateProfesseurDTO, String email, String fileName)
				throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
}
