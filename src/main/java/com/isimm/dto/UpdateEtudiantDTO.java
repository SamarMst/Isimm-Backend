package com.isimm.dto;

import jakarta.persistence.Column;

public class UpdateEtudiantDTO {
	
	private Long cin_etud;
	private Long telephone ;
	private String nom_etudiant;
	private String email ;
	private String password_etudiant ;
	private String specialite;
    private String niveau_etude;
    private String date_naissance;
    private String adresse;
    private String sexe;
    private String lieu_naissance;
    private String nationalite;
    private String annee_bac;
    private String session_bac;
    private String section_bac;
    private String mention_bac;
    private String moyenne_bac;
    private String pays_bac;
    private String photoData; 
    private String td;
    private String cnss;
    private String ville;
    private String codepostal;
    private String bio;
    private String github;
    private String linkedIn;
	 //constructors
	public UpdateEtudiantDTO() {}
	
	//Getters and setters
	
	public Long getCin_etud() {
		return cin_etud;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNiveau_etude() {
		return niveau_etude;
	}

	public void setNiveau_etude(String niveau_etude) {
		this.niveau_etude = niveau_etude;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getAnnee_bac() {
		return annee_bac;
	}

	public void setAnnee_bac(String annee_bac) {
		this.annee_bac = annee_bac;
	}

	public String getSession_bac() {
		return session_bac;
	}

	public void setSession_bac(String session_bac) {
		this.session_bac = session_bac;
	}

	public String getSection_bac() {
		return section_bac;
	}

	public void setSection_bac(String section_bac) {
		this.section_bac = section_bac;
	}

	public String getMention_bac() {
		return mention_bac;
	}

	public void setMention_bac(String mention_bac) {
		this.mention_bac = mention_bac;
	}

	public String getMoyenne_bac() {
		return moyenne_bac;
	}

	public void setMoyenne_bac(String moyenne_bac) {
		this.moyenne_bac = moyenne_bac;
	}

	public String getPays_bac() {
		return pays_bac;
	}

	public void setPays_bac(String pays_bac) {
		this.pays_bac = pays_bac;
	}

	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}

	public String getTd() {
		return td;
	}

	public void setTd(String td) {
		this.td = td;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
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
	public void setEmail_etudiant(String email) {
		this.email = email;
	}
	public String getPassword_etudiant() {
		return password_etudiant;
	}
	public void setPassword_etudiant(String password_etudiant) {
		this.password_etudiant = password_etudiant;
	}
}