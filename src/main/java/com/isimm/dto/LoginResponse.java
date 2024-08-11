package com.isimm.dto;

import com.isimm.entities.Etudiant;

public class LoginResponse {
	String message;
    Etudiant status;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Etudiant getStatus() {
        return status;
    }
    public void setStatus(Etudiant status) {
        this.status = status;
    }
    public LoginResponse(String message, Etudiant status) {
        this.message = message;
        this.status = status;
    }
}
