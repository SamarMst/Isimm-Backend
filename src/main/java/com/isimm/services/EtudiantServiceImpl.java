package com.isimm.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.isimm.dto.EtudiantDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTO;
import com.isimm.dto.LoginResponse;
import com.isimm.dto.UpdateEtudiantDTO;
import com.isimm.entities.Etudiant;
import com.isimm.repositories.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService  {
	 @Autowired
	    private EtudiantRepository etudiantRepo;
	 private static  String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

	    @Override
	    public Etudiant addEtudiant(EtudiantDTO etudiantDTO) 
	       {
	    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
	    	String encryptedPwd = bcrypt.encode(etudiantDTO.getPassword_etudiant());
	    	Etudiant etudiant = new Etudiant(
	    			etudiantDTO.getCin_etud(),
	    			etudiantDTO.getTelephone(),
	    			etudiantDTO.getNom_etudiant(),
	    			etudiantDTO.getEmail(),
	    			etudiantDTO.getPassword_etudiant()
	    			 );
	    	etudiant.setPassword(encryptedPwd);
	    	etudiantRepo.save(etudiant);
	    	return etudiant;
	       }
	    
	    
	    EtudiantDTO etudiantDTO;
	    @Override
	    public LoginResponse  loginEtudiant(LoginDTO loginDTO) {
	        String msg = "";
	        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	        Etudiant etudiant = etudiantRepo.findByEmail(loginDTO.getEmail());
	        if (etudiant != null) {
	        	if (bcrypt.matches(loginDTO.getPassword(), etudiant.getPassword())) {
	                return new LoginResponse("Login Success", etudiant);
	            } else {
	                return new LoginResponse("Login Failed", etudiant);
	            }
	        } else {
	            return new LoginResponse("Email not exists", etudiant);
	        }
	    }
	    
	    @Override
	    public Etudiant updateEtudiant(UpdateEtudiantDTO updateetudiantDTO) {
	        // Find the student by their email
	        Etudiant existingEtudiant = etudiantRepo.findByEmail(updateetudiantDTO.getEmail());
	        if (existingEtudiant != null) {
	            // Update existingEtudiant with data from etudiantDTO
	            if (updateetudiantDTO.getTelephone() != null) {
	                existingEtudiant.setTelephone(updateetudiantDTO.getTelephone());
	            }
	            if (updateetudiantDTO.getAdresse() != null) {
	                existingEtudiant.setAdresse(updateetudiantDTO.getAdresse());
	            }
	            if (updateetudiantDTO.getBio() != null) {
	                existingEtudiant.setBio(updateetudiantDTO.getBio());
	            }
	        	if(updateetudiantDTO.getVille() != null) {
	        		existingEtudiant.setVille(updateetudiantDTO.getVille());
	        	}
	        	if(updateetudiantDTO.getDate_naissance() != null) {
	        		existingEtudiant.setDate_naissance(updateetudiantDTO.getDate_naissance());
	        	}
	        	if(updateetudiantDTO.getCodepostal() != null) {
	        		existingEtudiant.setCodepostal(updateetudiantDTO.getCodepostal());
	        	}
	        	if(updateetudiantDTO.getLieu_naissance() != null) {
	        		existingEtudiant.setLieu_naissance(updateetudiantDTO.getLieu_naissance());
	        	}
	        	if(updateetudiantDTO.getNationalite() != null) {
	        		existingEtudiant.setNationalite(updateetudiantDTO.getNationalite());
	        	}
	        	if(updateetudiantDTO.getSpecialite() != null) {
	        		existingEtudiant.setSpecialite(updateetudiantDTO.getSpecialite());
	        	}
	        	if(updateetudiantDTO.getNiveau_etude() != null) {
	        		existingEtudiant.setNiveau_etude(updateetudiantDTO.getNiveau_etude());
	        	}
	        	if(updateetudiantDTO.getTd() != null) {
	        		existingEtudiant.setTd(updateetudiantDTO.getTd());
	        	}
	        	if(updateetudiantDTO.getSexe() != null) {
	        		existingEtudiant.setSexe(updateetudiantDTO.getSexe());
	        	}
	        	if(updateetudiantDTO.getCnss() != null) {
	        		existingEtudiant.setCnss(updateetudiantDTO.getCnss());
	        	}
	        	if(updateetudiantDTO.getSection_bac() != null) {
	        		existingEtudiant.setSection_bac(updateetudiantDTO.getSection_bac());
	        	}
	        	if(updateetudiantDTO.getSession_bac() != null) {
	        		existingEtudiant.setSession_bac(updateetudiantDTO.getSession_bac());
	        	}
	        	if(updateetudiantDTO.getAnnee_bac() != null) {
	        		existingEtudiant.setAnnee_bac(updateetudiantDTO.getAnnee_bac());
	        	}
	        	if(updateetudiantDTO.getMoyenne_bac() != null) {
	        		existingEtudiant.setMoyenne_bac(updateetudiantDTO.getMoyenne_bac());
	        	}
	        	if(updateetudiantDTO.getMention_bac() != null) {
	        		existingEtudiant.setMention_bac(updateetudiantDTO.getMention_bac());
	        	}
	        	if(updateetudiantDTO.getLinkedIn() != null) {
	        		existingEtudiant.setLinkedIn(updateetudiantDTO.getLinkedIn());
	        	}
	        	if(updateetudiantDTO.getGithub() != null) {
	        		existingEtudiant.setGithub(updateetudiantDTO.getGithub());
	        	}
	        	

	            // Update password if provided
	            if (updateetudiantDTO.getPassword_etudiant() != null) {
	                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
	                String encryptedPwd = bcrypt.encode(updateetudiantDTO.getPassword_etudiant());
	                existingEtudiant.setPassword(encryptedPwd);
	            }
	            // Save the updated etudiant
	            return etudiantRepo.save(existingEtudiant);
	        }
	        return null; // Return null if the student with the provided email is not found
	    }
	    
	    @Override
	    public Etudiant updatesEtudiant(UpdateEtudiantDTO updateEtudiantDTO, String email, String fileName) throws IOException {
	        Etudiant existingEtudiant = etudiantRepo.findByEmail(email);
	        if (existingEtudiant != null) {
	            if (updateEtudiantDTO.getTelephone() != null) {
	                existingEtudiant.setTelephone(updateEtudiantDTO.getTelephone());
	            }
	            if (updateEtudiantDTO.getAdresse() != null) {
	                existingEtudiant.setAdresse(updateEtudiantDTO.getAdresse());
	            }
	            if (updateEtudiantDTO.getPassword_etudiant() != null) {
	                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	                String encryptedPwd = bcrypt.encode(updateEtudiantDTO.getPassword_etudiant());
	                existingEtudiant.setPassword(encryptedPwd);
	            }
	            if (updateEtudiantDTO.getBio() != null) {
	                existingEtudiant.setBio(updateEtudiantDTO.getBio());
	            }
	        	if(updateEtudiantDTO.getVille() != null) {
	        		existingEtudiant.setVille(updateEtudiantDTO.getVille());
	        	}
	        	if(updateEtudiantDTO.getDate_naissance() != null) {
	        		existingEtudiant.setDate_naissance(updateEtudiantDTO.getDate_naissance());
	        	}
	        	if(updateEtudiantDTO.getCodepostal() != null) {
	        		existingEtudiant.setCodepostal(updateEtudiantDTO.getCodepostal());
	        	}
	        	if(updateEtudiantDTO.getLieu_naissance() != null) {
	        		existingEtudiant.setLieu_naissance(updateEtudiantDTO.getLieu_naissance());
	        	}
	        	if(updateEtudiantDTO.getNationalite() != null) {
	        		existingEtudiant.setNationalite(updateEtudiantDTO.getNationalite());
	        	}
	        	if(updateEtudiantDTO.getSpecialite() != null) {
	        		existingEtudiant.setSpecialite(updateEtudiantDTO.getSpecialite());
	        	}
	        	if(updateEtudiantDTO.getNiveau_etude() != null) {
	        		existingEtudiant.setNiveau_etude(updateEtudiantDTO.getNiveau_etude());
	        	}
	        	if(updateEtudiantDTO.getTd() != null) {
	        		existingEtudiant.setTd(updateEtudiantDTO.getTd());
	        	}
	        	if(updateEtudiantDTO.getSexe() != null) {
	        		existingEtudiant.setSexe(updateEtudiantDTO.getSexe());
	        	}
	        	if(updateEtudiantDTO.getCnss() != null) {
	        		existingEtudiant.setCnss(updateEtudiantDTO.getCnss());
	        	}
	        	if(updateEtudiantDTO.getSection_bac() != null) {
	        		existingEtudiant.setSection_bac(updateEtudiantDTO.getSection_bac());
	        	}
	        	if(updateEtudiantDTO.getSession_bac() != null) {
	        		existingEtudiant.setSession_bac(updateEtudiantDTO.getSession_bac());
	        	}
	        	if(updateEtudiantDTO.getAnnee_bac() != null) {
	        		existingEtudiant.setAnnee_bac(updateEtudiantDTO.getAnnee_bac());
	        	}
	        	if(updateEtudiantDTO.getMoyenne_bac() != null) {
	        		existingEtudiant.setMoyenne_bac(updateEtudiantDTO.getMoyenne_bac());
	        	}
	        	if(updateEtudiantDTO.getMention_bac() != null) {
	        		existingEtudiant.setMention_bac(updateEtudiantDTO.getMention_bac());
	        	}
	        	if(updateEtudiantDTO.getLinkedIn() != null) {
	        		existingEtudiant.setLinkedIn(updateEtudiantDTO.getLinkedIn());
	        	}
	        	if(updateEtudiantDTO.getGithub() != null) {
	        		existingEtudiant.setGithub(updateEtudiantDTO.getGithub());
	        	}
	            if (fileName != null) {
	                existingEtudiant.setPhotoData(fileName);
	            }
	        }
	        return etudiantRepo.save(existingEtudiant);
	    }
	    
	    
	    @Override
		public List<GetAllEtudiantDTO> getAllEtudiant() {
			List<Etudiant> getAllEtudiants = etudiantRepo.findAll();
			List<GetAllEtudiantDTO> etudiantDTOList = new ArrayList<>();
			for(Etudiant e : getAllEtudiants) {
				GetAllEtudiantDTO etudiantDTO = new GetAllEtudiantDTO(
						e.getCin_etud(),
						e.getTelephone(),
						e.getNom_etudiant(),
						e.getEmail(),
						e.getSpecialite(),
						e.getNiveau_etude(),
						e.getTd()
						);
				etudiantDTOList.add(etudiantDTO);
			}
			return etudiantDTOList;
		}

}
