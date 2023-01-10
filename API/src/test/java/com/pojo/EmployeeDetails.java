package com.pojo;

public class EmployeeDetails {
// declare all variables as global
	String ename;
	String id;
	long phoneno;
	String email;
	
	//Create constructor for initialization
	public EmployeeDetails(String ename, String id, long phoneno, String email) {
		this.ename=ename;
		this.id=id;
		this.phoneno=phoneno;
		this.email=email;
	}
	
	public EmployeeDetails() {
		
	}
	
//Generate geters and setters
	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
