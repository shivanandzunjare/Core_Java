package com.app.core;
import java.time.LocalDate;

//pojo Class
public class Customer implements Comparable<Customer> {
//customer id(int) ,first name, last name (string),email(string),password(string),
	//registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)

	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String passward;
	private double registrationAmount;
	private LocalDate dob;
	private  CustomerPlan plan;
	
	private static int counter;
	
	static {
		counter=1;
	}

	//parameterized constructor 
	public Customer(String first_name, String last_name, String email, String passward,
			double registrationAmount, LocalDate dob, CustomerPlan plan) {
		super();
	    this.id=counter++;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.passward = passward;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public Customer(String email) {
	
		this.email = email;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public CustomerPlan getPlan() {
		return plan;
	}

	public void setPlan(CustomerPlan plan) {
		this.plan = plan;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Customer.counter = counter;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public String getPassward() {
		return passward;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+  ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + "]";
	}
	
	//equal method for email
	@Override
	public boolean equals(Object o) {
		//System.out.println("in customer method");
		
		if(o instanceof Customer)
			return this.email.equals(((Customer)o).email);
		return false;
			
	}
	//compare method for sorting by email
	public int compareTo(Customer anotherCust) {
		return this.email.compareTo(anotherCust.email);
	}

}
