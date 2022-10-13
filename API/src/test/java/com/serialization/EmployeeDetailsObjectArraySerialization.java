package com.serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.pojo.Child;
import com.pojo.EmployeeDetailsObjectArray;
import com.pojo.Spouse;

public class EmployeeDetailsObjectArraySerialization {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		long[] phno= {12345, 67890};
		
		Spouse sp= new Spouse("hello", 4567, "hello@gmail");
		Child ch=new Child("me", 6);
		Object[] obj= {sp, ch};
		
		EmployeeDetailsObjectArray ea=new EmployeeDetailsObjectArray("pqr", "Tyss_01", phno, obj);
		
		ObjectMapper map=new ObjectMapper();
		
		map.writeValue(new File("./EmployeeDetailsObjectArray.json"), ea);
		
	}
}
