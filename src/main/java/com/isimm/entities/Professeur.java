package com.isimm.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Professeur  implements Serializable {
	@Id
	@Column
	private Long cin_prof;
	@Column(unique=true,nullable=false)
	private Long telephone_prof ;
	@Column(nullable=false)
	private String nom_prof ;
	@Column(unique=true,nullable=false)
	private String email ;
	@Column
	private String departement ;
	@Column
	private String titre ;
	@Column
	private String password ;
	@ManyToOne
    @JoinColumn(name = "id_admin")
	private Administration administration;
    @Column
    private String adresse;
    @Column
    private String sexe;
    @Column
    private String date_naissance;
    @Column
    private String lieu_naissance;
    @Column
    private String nationalite;
    @Column
    private byte[] photoData; // Field to store the file data as byte array

	
	//constructors
	
	public Professeur() {
		// TODO Auto-generated constructor stub
	}
	public Professeur(Long cin, Long telephone, String nom, String email, String departement, String titre,
			String password) {
		this.cin_prof = cin;
		this.telephone_prof = telephone;
		this.nom_prof = nom;
		this.email = email;
		this.departement = departement;
		this.titre = titre;
		this.password = password;
	}
	//Getters and setters
	
	public Long getCin() {
		return cin_prof;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
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
	
	public byte[] getPhotoData() {
		return photoData;
	}
	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}
	public void setCin(Long cin) {
		this.cin_prof = cin;
	}
	public Administration getAdministration() {
		return administration;
	}
	public void setAdministration(Administration administration) {
		this.administration = administration;
	}
	public Long getTelephone() {
		return telephone_prof;
	}
	public void setTelephone(Long telephone) {
		this.telephone_prof = telephone;
	}
	public String getNom() {
		return nom_prof;
	}
	public void setNom(String nom) {
		this.nom_prof = nom;
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

