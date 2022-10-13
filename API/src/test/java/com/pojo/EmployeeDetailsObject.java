package com.pojo;

public class EmployeeDetailsObject {
	
	String name;
	String id;
	long[] phno;
	Object Spouse;
	
	public EmployeeDetailsObject(String name, String id, long[] phno, Object Spouse ) {
		this.name=name;
		this.id=id;
		this.phno=phno;
		this.Spouse=Spouse;
	}
	
	public EmployeeDetailsObject() {
		
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

	public long[] getPhno() {
		return phno;
	}

	public void setPhno(long[] phno) {
		this.phno = phno;
	}

	public Object getSpouse() {
		return Spouse;
	}

	public void setSpouse(Object spouse) {
		Spouse = spouse;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.name+" "+this.id+" "+this.phno+" "+this.Spouse;
//	}
//	
//	
	
	
	

}
