package com.isimm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isimm.dto.LoginDTOProfesseur;
import com.isimm.dto.LoginResponseProfesseur;
import com.isimm.dto.ProfesseurDTO;
import com.isimm.entities.Professeur;
import com.isimm.services.ProfesseurService;

@RestController
@CrossOrigin
@RequestMapping("/professeur")
public class ProfesseurController {
    
	@Autowired
    private ProfesseurService professeurService;

    @PostMapping(path = "/signup")
    public Professeur saveProfesseur(@RequestBody ProfesseurDTO professeurDTO)
    {
        Professeur professeur = professeurService.addProfesseur(professeurDTO);
        return professeur;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginProfesseur(@RequestBody LoginDTOProfesseur loginDTO)
    {
        LoginResponseProfesseur loginResponse = professeurService.loginProfesseur(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}