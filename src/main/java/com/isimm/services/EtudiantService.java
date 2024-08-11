package com.isimm.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.isimm.dto.EtudiantDTO;
import com.isimm.dto.GetAllEtudiantDTO;
import com.isimm.dto.LoginDTO;
import com.isimm.dto.LoginResponse;
import com.isimm.dto.UpdateEtudiantDTO;
import com.isimm.entities.Etudiant;


@Service
public interface EtudiantService {
	Etudiant addEtudiant(EtudiantDTO etudiantDTO);

	LoginResponse loginEtudiant(LoginDTO loginDTO);

	Etudiant updateEtudiant(UpdateEtudiantDTO etudiantDTO);
	Etudiant updatesEtudiant(UpdateEtudiantDTO updateEtudiantDTO, String email, String fileName) throws IOException;
	List<GetAllEtudiantDTO> getAllEtudiant();
	}