package com.generic;

import java.util.ArrayList;
import java.util.Iterator;

import io.restassured.response.Response;

public class RestAssuredUtility {
	
	
	
	/**
	 * get json data from response body using json path
	 * @param response
	 * @param path
	 * @return
	 */

	
	public String getJsonData(Response response, String path) {
		String jsonData= response.jsonPath().get(path);
		return jsonData;
	}
	
	public String getProjectId(Response res, String expId) {
		 ArrayList jsonData= res.jsonPath().get("projectId");
			String pId="";
			Iterator it=jsonData.iterator();
			while(it.hasNext()) {	
				String pname=it.next().toString();
			   if(pname.contains(expId)) {
	         	pId=pId+pname;
	       	break;
			 }
		   }
			return pId;
	}

}
