package com.pojo;

public class EmployeeDetailsArray {
	
	String name;
	String id;
	String[] email;
	long[] phoneno;
	
	public EmployeeDetailsArray(String name, String id, String[] email, long[] phoneno) {
		this.name=name;
		this.id=id;
		this.email=email;
		this.phoneno=phoneno;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.name+" "+this.id+" "+this.email[0]+" "+this.email[1]+" "+this.phoneno[0]+" "+this.phoneno[1];
//	}

	public EmployeeDetailsArray() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public long[] getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long[] phoneno) {
		this.phoneno = phoneno;
	}
	
	

}
