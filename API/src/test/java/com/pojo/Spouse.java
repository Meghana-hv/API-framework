package com.pojo;

public class Spouse {

	String name;
	long phno;
	String email;
	
	public Spouse(String name,long phno,String email) {
		this.name=name;
		this.phno=phno;
		this.email=email;
	}
	public Spouse() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
