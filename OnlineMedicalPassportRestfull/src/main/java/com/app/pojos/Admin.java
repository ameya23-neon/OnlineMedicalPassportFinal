package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminid;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "email",length = 30,unique = true)
	private String email;
	@Column(name = "contact",length = 10)
	private String contact;
	@Column(name = "password")
    private String password;
	public Admin(String firstname, String lastname, String email, String contact, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	
	



	public Integer getAdminid() {
		return adminid;
	}





	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}





	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [admiid=" + adminid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", contact=" + contact + "]";
	}
}
