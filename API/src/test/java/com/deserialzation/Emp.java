package com.deserialzation;

public class Emp {
	
	private String ename;
	private String id;
	private String phoneno;
	private String email;
	
	public Emp(String ename, String id, String phoneno, String email) {
		this.ename=ename;
		this.id=id;
		this.phoneno=phoneno;
		this.email=email;	
	}
	public Emp() {}
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
