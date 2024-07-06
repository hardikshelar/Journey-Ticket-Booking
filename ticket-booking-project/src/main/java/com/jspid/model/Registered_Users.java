package com.jspid.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class Registered_Users {
	@Id
	private String username;
	private String password;
	private String email;
	private String phone;
	
	public Registered_Users() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	/**
	 * @param username
	 * @param password
	 */
	public Registered_Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 */
	public Registered_Users(String username, String password, String email, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	


}
