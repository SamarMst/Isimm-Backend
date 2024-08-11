package com.isimm.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isimm.dto.AdministrationDTO;
import com.isimm.dto.EtudiantDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTOAdministration;
import com.isimm.dto.LoginResponseAdministration;
import com.isimm.dto.UpdateAdministrationDTO;
import com.isimm.dto.UpdateEtudiantDTO;
import com.isimm.entities.Administration;
import com.isimm.entities.Etudiant;
import com.isimm.services.AdministrationService;
import com.isimm.services.EtudiantService;



@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdministrationController {
    
	@Autowired
    private AdministrationService administrationService;
	private static  String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

    @PostMapping(path = "/signup")
    public Administration saveAdministration (@RequestBody AdministrationDTO administrationDTO)
    {
    	Administration administration = administrationService.addAdministration(administrationDTO);
        return administration;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAdministration(@RequestBody LoginDTOAdministration loginDTOAdministration )
    {
    	LoginResponseAdministration loginResponseAdministration  = administrationService.loginAdministration(loginDTOAdministration );
        return ResponseEntity.ok(loginResponseAdministration );
    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateAdministration (@RequestBody UpdateAdministrationDTO updateAdministrationDTO){
    	Administration updatedAdministration = administrationService.updateAdministration(updateAdministrationDTO);
        if (updatedAdministration != null) {
            return ResponseEntity.ok(updatedAdministration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(path = "/updates")
    public ResponseEntity<?> updatesEtudiant(@RequestParam("email") String email,
                                             @RequestParam("imageData") MultipartFile file,
                                             @ModelAttribute UpdateAdministrationDTO updateAdministrationDTO) {
        try {
            String originalFileName = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
            Files.write(fileNameAndPath, file.getBytes());

            Administration updatedAdministration = administrationService.updatesAdministration(updateAdministrationDTO, email, originalFileName);
            if (updatedAdministration != null) {
                return ResponseEntity.ok(updatedAdministration);
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
    	List<GetAllEtudiantDTO>allEtudiants = administrationService.getAllEtudiant();
    	return allEtudiants;
    	
    }


}