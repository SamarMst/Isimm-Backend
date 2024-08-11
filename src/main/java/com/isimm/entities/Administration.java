package com.isimm.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Administration  implements Serializable {
	@Id
	@Column
	private Long cin_admin;
	@Column(unique = true,nullable=false)
	private Long telephone_admin;
	@Column(nullable=false)
	private String nom_admin ;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String password ;
	@Column(nullable=false)
	private String titre_admin ;
	@OneToMany(mappedBy = "administration")
	private List<Etudiant> etudiants;
	@OneToMany(mappedBy = "administration")
	private List<Professeur> professeurs;
	@Column
	private String adresse;
	@Column
	private String sexe;
	@Column
	private String bio;
	@Column
	private String lieu_naissance;
	@Column
	private String date_naissance;
	@Column
	private String nationalite;
	@Column
	private String ville;
	@Column
	private String codepostal;
	@Column
	private String cnss;
	@Column
    private String photoData; // Field to store the file data as byte array    
     //constructors
     public Administration(Long cin_admin, Long telephone_admin, String nom_admin,
    	        String email_admin, String password, String titre_admin) {
    	    this.cin_admin = cin_admin;
    	    this.telephone_admin = telephone_admin;
    	    this.nom_admin = nom_admin;
    	    this.email = email_admin;
    	    this.password = password;
    	    this.titre_admin = titre_admin;
    	}

     
   public Administration() {
		
	}

//Getters and setters
    
	public Long getCin_admin() {
		return cin_admin;
	}
	public String getCnss() {
		return cnss;
	}


	public void setCnss(String cnss) {
		this.cnss = cnss;
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


	public String getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
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
		return email;
	}
	public void setEmail_admin(String email_admin) {
		this.email = email_admin;
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

