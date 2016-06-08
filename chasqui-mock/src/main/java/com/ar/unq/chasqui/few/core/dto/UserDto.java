package com.ar.unq.chasqui.few.core.dto;

import java.io.Serializable;

public class UserDto implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", password=" + password + "]";
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


}
