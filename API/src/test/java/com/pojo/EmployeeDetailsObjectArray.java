package com.pojo;

public class EmployeeDetailsObjectArray {
	
	String ename;
	String id;
	long[] phno;
	Object[] obj;
	
	public EmployeeDetailsObjectArray(String ename,String id, long[] phno, Object[] obj) {
		this.ename=ename;
		this.id=id;
		this.phno=phno;
		this.obj=obj;
	}
	
	public EmployeeDetailsObjectArray() {}

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

	public long[] getPhno() {
		return phno;
	}

	public void setPhno(long[] phno) {
		this.phno = phno;
	}

	public Object[] getObj() {
		return obj;
	}

	public void setObj(Object[] obj) {
		this.obj = obj;
	}
	
	

}
