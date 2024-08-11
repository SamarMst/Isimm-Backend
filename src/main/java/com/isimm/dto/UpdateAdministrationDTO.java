package com.isimm.dto;

import java.util.List;

import com.isimm.entities.Etudiant;
import com.isimm.entities.Professeur;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class UpdateAdministrationDTO {
	private Long cin_admin;
	private Long telephone_admin;
	private String nom_admin ;
	private String email;
	private String bio;
	private String password ;
	private String titre_admin ;
	private String adresse;
	private String sexe;
	private String lieu_naissance;
	private String date_naissance;
	private String nationalite;
    private String photoData;
    private String ville;
	private String codepostal;
    
  //constructors
  	public UpdateAdministrationDTO() {}
  	
  //Getters and setters
	
	public Long getCin_admin() {
		return cin_admin;
	}
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public void setCin_admin(Long cin_admin) {
		this.cin_admin = cin_admin;
	}
	public Long getTelephone_admin() {
		return telephone_admin;
	}
	public void setTelephone_admin(Long telephone_admin) {
		this.telephone_admin = telephone_admin;
	}
	public String getNom_admin() {
		return nom_admin;
	}
	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitre_admin() {
		return titre_admin;
	}
	public void setTitre_admin(String titre_admin) {
		this.titre_admin = titre_admin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getLieu_naissance() {
		return lieu_naissance;
	}
	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getPhotoData() {
		return photoData;
	}
	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}
    
    
}
