package com.deserialzation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetails;

public class EmployeeDetailsDeserialization {
	
	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper map=new ObjectMapper();
		
		EmployeeDetails e = map.readValue(new File(".\\EmployeeDetails.json"), EmployeeDetails.class);
		
		System.out.println();
		System.out.println(e.getEname()+" "+e.getId()+" "+e.getPhoneno()+" "+e.getEmail()+" "+e.getClass());
		
		
	}

}
