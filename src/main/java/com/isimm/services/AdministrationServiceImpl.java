package com.isimm.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.isimm.dto.AdministrationDTO;
import com.isimm.dto.EtudiantDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTOAdministration;
import com.isimm.dto.LoginResponse;
import com.isimm.dto.LoginResponseAdministration;
import com.isimm.dto.UpdateAdministrationDTO;
import com.isimm.entities.Administration;
import com.isimm.entities.Etudiant;
import com.isimm.repositories.AdministrationRepository;
import com.isimm.repositories.EtudiantRepository;

@Service
public class AdministrationServiceImpl implements AdministrationService  {
	 @Autowired
	 private AdministrationRepository administrationRepo;
	 @Autowired
	 private EtudiantRepository etudiantRepo;
	 private static  String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

	    @Override
	    public Administration addAdministration(AdministrationDTO administrationDTO) 
	       {
	    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
	    	String encryptedPwd = bcrypt.encode(administrationDTO.getPassword());
	    	Administration administration = new Administration(
	    			administrationDTO.getCin_admin(),
	    			administrationDTO.getTelephone_admin(),
	    			administrationDTO.getNom_admin(),
	    			administrationDTO.getEmail_admin(),
	    			administrationDTO.getPassword(),
	    			administrationDTO.getTitre_admin()
	    			 );
	    	administration.setPassword(encryptedPwd);
	    	administrationRepo.save(administration);
	    	return administration;
	       }
	    
	    
	    AdministrationDTO administrationDTO;
		@Override
		public LoginResponseAdministration loginAdministration(LoginDTOAdministration loginDTOAdministration) {
			 BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			 String msg = "";
			 Administration administration = administrationRepo.findByEmail(loginDTOAdministration.getEmail());
		        if (administration != null) {
		        	if (bcrypt.matches(loginDTOAdministration.getPassword(), administration.getPassword())) {
		        		 return new LoginResponseAdministration("Login Success", administration);
		            } else {
		                return new LoginResponseAdministration("Login Failed", administration);
		            }
		        } else {
		            return new LoginResponseAdministration("Email not exists", administration);
		        }
		    }
		
		@Override
		public Administration updateAdministration(UpdateAdministrationDTO updateAdministrationDTO) {
			// Find the administration by their email
	        Administration existingAdministration = administrationRepo.findByEmail( updateAdministrationDTO.getEmail());
	        if (existingAdministration != null) {
	            // Update existingAdministration with data from updateAdministrationDTO
	            if ( updateAdministrationDTO.getTelephone_admin() != null) {
	            	existingAdministration.setTelephone_admin( updateAdministrationDTO.getTelephone_admin());
	            }
	            if ( updateAdministrationDTO.getAdresse() != null) {
	            	existingAdministration.setAdresse( updateAdministrationDTO.getAdresse());
	            }
	           
	        	if( updateAdministrationDTO.getDate_naissance() != null) {
	        		existingAdministration.setDate_naissance( updateAdministrationDTO.getDate_naissance());
	        	}
	        	if( updateAdministrationDTO.getLieu_naissance() != null) {
	        		existingAdministration.setLieu_naissance( updateAdministrationDTO.getLieu_naissance());
	        	}
	        	if( updateAdministrationDTO.getNationalite() != null) {
	        		existingAdministration.setNationalite( updateAdministrationDTO.getNationalite());
	        	}
	        	if( updateAdministrationDTO.getTitre_admin() != null) {
	        		existingAdministration.setTitre_admin( updateAdministrationDTO.getTitre_admin());
	        	}
	        	if( updateAdministrationDTO.getSexe() != null) {
	        		existingAdministration.setSexe(updateAdministrationDTO.getSexe());
	        	}
	        	// Update password if provided
	            if (updateAdministrationDTO.getPassword() != null) {
	                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
	                String encryptedPwd = bcrypt.encode(updateAdministrationDTO.getPassword());
	                existingAdministration.setPassword(encryptedPwd);
	            }
	        	
	        	}
	            // Save the updated administration
	            return administrationRepo.save(existingAdministration);
	    }
		@Override
		public Administration updatesAdministration(UpdateAdministrationDTO updateAdministrationDTO, String email,
				String fileName) throws IOException {
			Administration existingAdmninistration = administrationRepo.findByEmail(email);
	        if (existingAdmninistration != null) {
	            if (updateAdministrationDTO.getTelephone_admin() != null) {
	                existingAdmninistration.setTelephone_admin(updateAdministrationDTO.getTelephone_admin());
	            }
	            if (updateAdministrationDTO.getAdresse() != null) {
	                existingAdmninistration.setAdresse(updateAdministrationDTO.getAdresse());
	            }
	        	if(updateAdministrationDTO.getVille() != null) {
	        		existingAdmninistration.setVille(updateAdministrationDTO.getVille());
	        	}
	        	if(updateAdministrationDTO.getCodepostal() != null) {
	        		existingAdmninistration.setCodepostal(updateAdministrationDTO.getCodepostal());
	        	}
	        	
		        if ( updateAdministrationDTO.getAdresse() != null) {
		        	existingAdmninistration.setAdresse( updateAdministrationDTO.getAdresse());
		            }
		           
		        if( updateAdministrationDTO.getDate_naissance() != null) {
		        		existingAdmninistration.setDate_naissance( updateAdministrationDTO.getDate_naissance());
		        	}
		        if( updateAdministrationDTO.getLieu_naissance() != null) {
		        	existingAdmninistration.setLieu_naissance( updateAdministrationDTO.getLieu_naissance());
		        	}
		        if( updateAdministrationDTO.getNationalite() != null) {
		        	existingAdmninistration.setNationalite( updateAdministrationDTO.getNationalite());
		        	}
		        if( updateAdministrationDTO.getTitre_admin() != null) {
		        		existingAdmninistration.setTitre_admin( updateAdministrationDTO.getTitre_admin());
		        	}
		        if( updateAdministrationDTO.getSexe() != null) {
		        		existingAdmninistration.setSexe(updateAdministrationDTO.getSexe());
		        	}
		        	// Update password if provided
		            if (updateAdministrationDTO.getPassword() != null) {
		                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
		                String encryptedPwd = bcrypt.encode(updateAdministrationDTO.getPassword());
		                existingAdmninistration.setPassword(encryptedPwd);
		            }
	            if (fileName != null) {
	                existingAdmninistration.setPhotoData(fileName);
	            }
	        }
	        return administrationRepo.save(existingAdmninistration);
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
