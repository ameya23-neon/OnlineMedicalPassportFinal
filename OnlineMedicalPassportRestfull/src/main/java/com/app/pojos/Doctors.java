package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Doctors")
public class Doctors {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer doctorsId;
	@Column(name = "title",length = 20)
	private String title;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String email;
	@Column(name="Password",length = 10)
	private String password;
	@Column(name = "Speacilization")
	private String specialization;
	
	@Column(name = "Hospital_Area",length = 20)
	private String hospitalarea;
	
	@Column(name = "Hospital_City",length = 20)
	private String hospitalcity;
	
	@Column(name = "Hospital_Name",length = 20)
	private String hospitalname;
	
	@Column(name = "ContactNo",length = 20)
	private String contactno;
	
	
	//@JsonBackReference
	@JsonIgnoreProperties("selecteddoctor")
	@OneToMany(mappedBy = "selecteddoctor",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Users> users;
	
	
	
	//@JsonBackReference
	@JsonIgnoreProperties("selectdoctor")
	@OneToMany(mappedBy = "selectdoctor",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Description>description;
	
	
	public Doctors() {	
		System.out.println("In Doctors constr"+getClass().getName());
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	
	
	

	public List<Description> getDescription() {
		return description;
	}

	public void setDescription(List<Description> description) {
		this.description = description;
	}

	public Integer getDoctorsId() {
		return doctorsId;
	}

	public void setDoctorsId(Integer doctorsId) {
		this.doctorsId = doctorsId;
	}

	public String getHospitalarea() {
		return hospitalarea;
	}

	public void setHospitalarea(String hospitalarea) {
		this.hospitalarea = hospitalarea;
	}

	public String getHospitalcity() {
		return hospitalcity;
	}

	public void setHospitalcity(String hospitalcity) {
		this.hospitalcity = hospitalcity;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctors [id=" + doctorsId + ", title=" + title + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", specialization=" + specialization + ", hospitalarea=" + hospitalarea
				+ ", hospitalcity=" + hospitalcity + ", hospitalname=" + hospitalname + ", contactno=" + contactno
				+ ", users=" + users + "]";
	}
	
	
	
	
	
	
	
	
	
}
