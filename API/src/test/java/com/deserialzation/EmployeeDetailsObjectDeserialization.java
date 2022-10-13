package com.deserialzation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetailsObject;

public class EmployeeDetailsObjectDeserialization {
@Test
public void deserialization() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper map=new ObjectMapper();
	
	EmployeeDetailsObject e = map.readValue(new File(".\\EmployeeDetailsObject.json"), EmployeeDetailsObject.class);
	
	System.out.println(e.getSpouse());
	
}
}
