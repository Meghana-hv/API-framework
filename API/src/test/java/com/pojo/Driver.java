package com.pojo;

public class Driver {

	public static void main(String[] args) {
		String[] email=new String[2];
		email[0]="abc@gmail.com";
		email[1]="xyz@gmail.com";
		
		long[] phoneno=new long[2];
		phoneno[0]=12345;
		phoneno[1]=67890;
		EmployeeDetailsArray emp=new EmployeeDetailsArray("abc","Tyss_01",email, phoneno);
		
		System.out.print(emp);
		
		long[] phno=new long[2];
		phoneno[0]=12345;
		phoneno[1]=67890;
		
		Spouse sp=new Spouse("hi",123,"@gmail");
		
		EmployeeDetailsObject o=new EmployeeDetailsObject("abcd","Tyss_02", phno, sp );
		System.out.println(o);
		
		

	}

}
