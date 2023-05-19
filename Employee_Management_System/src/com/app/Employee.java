package com.app;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

//		Emp details : id(string), first name , last name , 
//		dept(enum : RND,HR,SALES,FINANCE,PRODUCTION), joining date(LocalDate)
		private String id;
		private String firstname;
		private String lastname;
		private Departments dept;
		private LocalDate doj;
		
	

		public Employee(String id, String firstname, String lastname, Departments dept, LocalDate doj) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.dept = dept;
			this.doj = doj;
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



		public Departments getDept() {
			return dept;
		}



		public void setDept(Departments dept) {
			this.dept = dept;
		}

		public LocalDate getDoj() {
			return doj;
		}

		public void setDoj(LocalDate doj) {
			this.doj = doj;
		}

       public String getId() {
			return id;
		}


		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dept=" + dept
					+ ", doj=" + doj + "]";
		}

	

}
