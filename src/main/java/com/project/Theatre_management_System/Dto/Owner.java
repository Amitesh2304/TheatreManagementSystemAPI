package com.project.Theatre_management_System.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private String ownerGender;
	private long ownerPhone;
	private double ownnerNetWorth;
	
	@OneToOne(cascade = CascadeType.ALL)
	Theatre theatre;
	
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerGender() {
		return ownerGender;
	}
	public void setOwnerGender(String ownerGender) {
		this.ownerGender = ownerGender;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public double getOwnnerNetWorth() {
		return ownnerNetWorth;
	}
	public void setOwnnerNetWorth(double ownnerNetWorth) {
		this.ownnerNetWorth = ownnerNetWorth;
	}
	
	
}
