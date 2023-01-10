package com.deserialzation;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializationArray {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		String emp="{\"name\":\"Meghana\",\"id\":\"Tyss_01\",\"email\":[\"abc@gmail.com\",\"xyz@gmail.com\"],\"phoneno\":[12345,67890]}";
		
		ObjectMapper map=new ObjectMapper();
		
		EmpArray e=map.readValue(emp, EmpArray.class);
		
		
		System.out.println(e.getPhoneno());
		System.out.println(e.getEmail());
		
		System.out.println(e.getName());
		
		System.out.println(e);
	}

}
