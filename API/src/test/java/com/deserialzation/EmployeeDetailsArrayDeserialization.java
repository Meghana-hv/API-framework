package com.deserialzation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetailsArray;

public class EmployeeDetailsArrayDeserialization {
	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper map=new ObjectMapper();
		
		EmployeeDetailsArray e = map.readValue(new File(".\\EmployeeDetailsArray.json"), EmployeeDetailsArray.class);
		

		for(String s:e.getEmail()) {
			System.out.println(s);
		}
		
		for(long l:e.getPhoneno()) {
			System.out.println(l);
		}
		
		
		System.out.println(e.getId()+" "+e.getName()+" "+e.getPhoneno());
		
		
	}
	

}
