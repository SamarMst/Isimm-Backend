package com.isimm.dto;


public class ProfesseurDTO {
	private Long cin_prof;
	private Long telephone_prof ;
	private String nom_prof ;
	private String email ;
	private String departement ;
	private String titre ;
	private String password ;
	
	public ProfesseurDTO() {}

	public Long getCin_prof() {
		return cin_prof;
	}

	public void setCin_prof(Long cin_prof) {
		this.cin_prof = cin_prof;
	}

	public Long getTelephone_prof() {
		return telephone_prof;
	}

	public void setTelephone_prof(Long telephone_prof) {
		this.telephone_prof = telephone_prof;
	}

	public String getNom_prof() {
		return nom_prof;
	}

	public void setNom_prof(String nom_prof) {
		this.nom_prof = nom_prof;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
