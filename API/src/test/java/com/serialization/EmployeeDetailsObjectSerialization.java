package com.serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.EmployeeDetailsObject;
import com.pojo.Spouse;

public class EmployeeDetailsObjectSerialization {
@Test
public void serialization() throws JsonGenerationException, JsonMappingException, IOException  {
	long[] phno= {12345, 67890};
	Spouse sp=new Spouse("hi", 2345, "hi@gmail");
	EmployeeDetailsObject eo=new EmployeeDetailsObject("Meghana", "TYSS_01", phno, sp);
	
	ObjectMapper obj=new ObjectMapper();
	
	obj.writeValue(new File("./EmployeeDetailsObject.json"), eo);
	
}

}
