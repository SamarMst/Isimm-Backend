package com.isimm.dto;

import java.util.List;

import com.isimm.entities.Etudiant;
import com.isimm.entities.Professeur;


public class AdministrationDTO {
	private Long cin_admin;
	private Long telephone_admin;
	private String nom_admin ;
	private String email_admin ;
	private String password ;
	private String titre_admin ;
	private List<Etudiant> etudiants;
	private List<Professeur> professeurs;
	
	//constructors
		public AdministrationDTO() {}
	//Getters and setters
	public Long getCin_admin() {
		return cin_admin;
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
	public String getEmail_admin() {
		return email_admin;
	}
	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
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
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public List<Professeur> getProfesseurs() {
		return professeurs;
	}
	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}
	
	

}
