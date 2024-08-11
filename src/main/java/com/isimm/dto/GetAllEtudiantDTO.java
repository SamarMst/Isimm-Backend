package com.isimm.dto;

public class GetAllEtudiantDTO {
	private Long cin_etud;
	private Long telephone ;
	private String nom_etudiant;
	private String email ;
	private String specialite;
    private String niveau_etude;
    private String td;
    
    
	public GetAllEtudiantDTO() {
	}
	
	public GetAllEtudiantDTO(Long cin_etud, Long telephone, String nom_etudiant, String email, String specialite,
			String niveau_etude, String td) {
		this.cin_etud = cin_etud;
		this.telephone = telephone;
		this.nom_etudiant = nom_etudiant;
		this.email = email;
		this.specialite = specialite;
		this.niveau_etude = niveau_etude;
		this.td = td;
	}

	public Long getCin_etud() {
		return cin_etud;
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
	public void setEmail(String email) {
		this.email = email;
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
	public String getTd() {
		return td;
	}
	public void setTd(String td) {
		this.td = td;
	}
    
    

}
