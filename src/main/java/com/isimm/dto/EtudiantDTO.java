package com.isimm.dto;

import jakarta.persistence.Column;

public class EtudiantDTO {
	
	private Long cin_etud;
	private Long telephone ;
	private String nom_etudiant;
	private String email ;
	private String password_etudiant ;
	
	 //constructors
	public EtudiantDTO() {}
	
	//Getters and setters
	

	public Long getCin_etud() {
		return cin_etud;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCin_etud(Long cin_etud) {
		this.cin_etud = cin_etud;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getNom_etudiant() {
		return nom_etudiant;
	}
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword_etudiant() {
		return password_etudiant;
	}
	public void setPassword_etudiant(String password_etudiant) {
		this.password_etudiant = password_etudiant;
	}

}