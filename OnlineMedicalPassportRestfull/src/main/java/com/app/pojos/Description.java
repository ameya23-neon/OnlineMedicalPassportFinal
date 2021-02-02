package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "users_descriptions")
public class Description {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer descriptionid;
	private String age;
	private float height;
	private float oxygenLevel;
	private int heartRate;
	private int bloodPressure;
	private String allergies;
	private String medicalhistory;
	private LocalDate lastcheckupdate;
	private LocalDate  upcomingcheckupdate;
	
	//@JsonBackReference
	@JsonIgnoreProperties("userdetails")
	@OneToOne 
	@JoinColumn(name="user_id",nullable = true)
	private Users userdetails;
	
	@JsonIgnoreProperties("selectdoctor")
	@ManyToOne
	@JoinColumn(name="doctors_id",nullable = true)
	private Doctors selectdoctor;
	
	
	public Description() {
		System.out.println("in Description Constr"+getClass().getName());
	}

	public Description(String age, float height, float oxygenLevel, int heartRate, int bloodPressure, String allergies,
			String medicalhistory, LocalDate lastcheckupdate, LocalDate upcomingcheckupdate, Users userdetails) {
		this.age = age;
		this.height = height;
		this.oxygenLevel = oxygenLevel;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.allergies = allergies;
		this.medicalhistory = medicalhistory;
		this.lastcheckupdate = lastcheckupdate;
		this.upcomingcheckupdate = upcomingcheckupdate;
		this.userdetails = userdetails;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getOxygenLevel() {
		return oxygenLevel;
	}

	public void setOxygenLevel(float oxygenLevel) {
		this.oxygenLevel = oxygenLevel;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getMedicalhistory() {
		return medicalhistory;
	}

	public void setMedicalhistory(String medicalhistory) {
		this.medicalhistory = medicalhistory;
	}

	public LocalDate getLastcheckupdate() {
		return lastcheckupdate;
	}

	public void setLastcheckupdate(LocalDate lastcheckupdate) {
		this.lastcheckupdate = lastcheckupdate;
	}

	public LocalDate getUpcomingcheckupdate() {
		return upcomingcheckupdate;
	}

	public void setUpcomingcheckupdate(LocalDate upcomingcheckupdate) {
		this.upcomingcheckupdate = upcomingcheckupdate;
	}

	public Users getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Users userdetails) {
		this.userdetails = userdetails;
	}

	
	public Integer getDescriptionid() {
		return descriptionid;
	}

	public void setDescriptionid(Integer descriptionid) {
		this.descriptionid = descriptionid;
	}

	public Doctors getSelectdoctor() {
		return selectdoctor;
	}

	public void setSelectdoctor(Doctors selectdoctor) {
		this.selectdoctor = selectdoctor;
	}

	@Override
	public String toString() {
		return "Description [descriptionid=" + descriptionid + ", age=" + age + ", height=" + height + ", oxygenLevel="
				+ oxygenLevel + ", heartRate=" + heartRate + ", bloodPressure=" + bloodPressure + ", allergies="
				+ allergies + ", medicalhistory=" + medicalhistory + ", lastcheckupdate=" + lastcheckupdate
				+ ", upcomingcheckupdate=" + upcomingcheckupdate + ", userdetails=" + userdetails + "]";
	}


}
