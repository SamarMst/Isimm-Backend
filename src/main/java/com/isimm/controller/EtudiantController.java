package com.isimm.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.isimm.dto.EtudiantDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTO;
import com.isimm.dto.LoginResponse;
import com.isimm.dto.UpdateEtudiantDTO;
import com.isimm.entities.Etudiant;
import com.isimm.services.EtudiantService;





@RestController
@CrossOrigin
@RequestMapping("/etudiant")
public class EtudiantController {
	
    
	@Autowired
    private EtudiantService etudiantService;
	 private static  String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

    @PostMapping(path = "/signup")
    public Etudiant saveEtudiant(@RequestBody EtudiantDTO etudiantDTO)
    {
        Etudiant etudiant = etudiantService.addEtudiant(etudiantDTO);
        return etudiant;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEtudiant(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = etudiantService.loginEtudiant(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateEtudiant (@RequestBody UpdateEtudiantDTO updateEtudiantDTO){
    	Etudiant updatedEtudiant = etudiantService.updateEtudiant(updateEtudiantDTO);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(path = "/updates")
    public ResponseEntity<?> updatesEtudiant(@RequestParam("email") String email,
                                             @RequestParam("imageData") MultipartFile file,
                                             @ModelAttribute UpdateEtudiantDTO updateEtudiantDTO) {
        try {
            String originalFileName = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
            Files.write(fileNameAndPath, file.getBytes());

            Etudiant updatedEtudiant = etudiantService.updatesEtudiant(updateEtudiantDTO, email, originalFileName);
            if (updatedEtudiant != null) {
                return ResponseEntity.ok(updatedEtudiant);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload file: " + e.getMessage());
        }
    }
    @GetMapping(path = "/etudiants")
    public List<GetAllEtudiantDTO>getAllEtudiants(){
    	List<GetAllEtudiantDTO>allEtudiants = etudiantService.getAllEtudiant();
    	return allEtudiants;
    	
    }
   

}