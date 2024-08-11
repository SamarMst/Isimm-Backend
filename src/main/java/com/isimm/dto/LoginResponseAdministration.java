package com.isimm.dto;

import com.isimm.entities.Administration;

public class LoginResponseAdministration {
	String message;
    Administration status;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Administration getStatus() {
        return status;
    }
    public void setStatus(Administration status) {
        this.status = status;
    }
    public LoginResponseAdministration(String message, Administration status) {
        this.message = message;
        this.status = status;
    }
}
