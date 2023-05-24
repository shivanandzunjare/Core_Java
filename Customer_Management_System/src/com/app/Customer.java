package com.app;

import java.io.Serializable;
import java.time.LocalDate;



public class Customer implements Serializable {
	private int id;
	private String firstname;
	private String lastname;
	private  String email;
	private String passward;
	private LocalDate dob;
	private  CustomerPlan plan;
	
	public Customer(int id, String firstname, String lastname, String email, String passward, LocalDate dob,
			CustomerPlan plan) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.passward = passward;
		this.dob = dob;
		this.plan = plan;
	}

	
	public Customer(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public CustomerPlan getPlan() {
		return plan;
	}

	public void setPlan(CustomerPlan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", passward=" + passward + ", dob=" + dob + ", plan=" + plan + "]";
	}
	
	

}
