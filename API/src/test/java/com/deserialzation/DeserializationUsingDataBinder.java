package com.deserialzation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationUsingDataBinder {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json="{\"ename\":\"tom\",\"id\":\"tyss_01\",\"phoneno\":12345,\"email\":\"abc@gmail\"}";
		
		ObjectMapper map=new ObjectMapper();
		
		Emp e= map.readValue(json, Emp.class);
		
		System.out.println(e.getPhoneno());
		
		System.out.println(e.getEname());
		

	}

}
