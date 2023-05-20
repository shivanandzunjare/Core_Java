package com.app;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {  // serializable student class 

	private int roll_no;
	private String firstname;
	private String lastname;
	private LocalDate dob;
	private Subject sub;
	private double gpa;
	
	//parameterized constructor 
	public Student(int roll_no, String firstname, String lastname, LocalDate dob, Subject sub, double gpa) {
		super();
		this.roll_no = roll_no;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.sub = sub;
		this.gpa = gpa;

	}

	

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", sub=" + sub + ", gpa=" + gpa + "]";
	}



}
