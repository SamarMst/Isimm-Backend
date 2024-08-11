package com.isimm.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isimm.dto.AdministrationDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTOAdministration;
import com.isimm.dto.LoginResponseAdministration;
import com.isimm.dto.UpdateAdministrationDTO;
import com.isimm.entities.Administration;



@Service
public interface AdministrationService {
	Administration addAdministration(AdministrationDTO administrationDTO);
	LoginResponseAdministration loginAdministration(LoginDTOAdministration loginDTOAdministration);
	Administration updateAdministration(UpdateAdministrationDTO administrationDTO);
	Administration updatesAdministration(UpdateAdministrationDTO updateAdministrationDTO, String email, String fileName) throws IOException;
	List<GetAllEtudiantDTO> getAllEtudiant();

}