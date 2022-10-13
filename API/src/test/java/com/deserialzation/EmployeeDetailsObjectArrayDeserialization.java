package com.deserialzation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetailsObjectArray;

public class EmployeeDetailsObjectArrayDeserialization {
@Test
public void deserialization() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper map=new ObjectMapper();
	
	EmployeeDetailsObjectArray e = map.readValue(new File(".\\EmployeeDetailsObjectArray.json"), EmployeeDetailsObjectArray.class);
	
	System.out.println(e.getObj());
	Object[] o = e.getObj();
	System.out.println(o[0]+" "+o[1]);
	for(Object o1:e.getObj()) {
		System.out.println(o1);
	}
	
}
}
