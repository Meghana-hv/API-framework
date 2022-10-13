package com.serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetailsArray;

public class EmployeeDetailsArraySerialization {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		String[] email= {"abc@gmail.com","xyz@gmail.com"};
		long[] phoneno= {12345, 67890};
		
		EmployeeDetailsArray ed=new EmployeeDetailsArray("Meghana", "Tyss_01", email, phoneno);
		
		ObjectMapper map=new ObjectMapper();
		
		map.writeValue(new File("./EmployeeDetailsArray.json"), ed);
	}
}
