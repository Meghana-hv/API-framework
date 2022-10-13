package com.serialization;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import com.pojo.EmployeeDetails;


public class EmployeeDetailsSerialization {
@Test
public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
//Step1: create object of pojo class
		EmployeeDetails ed=new EmployeeDetails("tom", "tyss_01", 12345, "abc@gmail");
		//Step 2: Create object of object mapper from jackson mapper
		
		ObjectMapper obj=new ObjectMapper();
		//Step3: Write the value to json file
		obj.writeValue(new File("./EmployeeDetails.json"), ed);
		
	}
}

