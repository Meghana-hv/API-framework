package com.deserialzation;

import java.util.List;

public class EmpArray {
//{\"name\":\"Meghana\",\"id\":\"Tyss_01\",\"email\":[\"abc@gmail.com\",\"xyz@gmail.com\"],\"phoneno\":[12345,67890]}
	
	private String name;
	private String id;
	private List<String> email;
	private List<Integer>phoneno;
	
	EmpArray(String name, String id, List<String> email, List<Integer> phoneno){
		this.name=name;
		this.id=id;
		this.email=email;
		this.phoneno=phoneno;
	}
	EmpArray(){}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	public List<Integer> getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(List<Integer> phoneno) {
		this.phoneno = phoneno;
	}
	
	
//	public String toString() {
//		// TODO Auto-generated method stub
//		return  this.name+" "+this.name+" "+this.email+" "+this.phoneno;
//		
//	}
	
	
	
}
