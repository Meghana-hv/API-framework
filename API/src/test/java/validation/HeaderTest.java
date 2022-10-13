package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class HeaderTest {
	@Test
	public void header() {
		baseURI="http://localhost";
		port=8084;

		String header="Origin";
		boolean flag = false;

		Response res = when().get("/projects");
		//res.then().log().all();

		//String act = res.getHeaders().toString();
		//System.out.println(act);
		
		   
		String pr = res.getHeader("Pragma");
		System.out.println(pr);

		List<Header> hr = res.getHeaders().getList("Vary");
		
		for(Header head:hr) {
			if(head.toString().contains(header)) {
				flag=true;
				System.out.println("header found");
			}
		}
		Assert.assertTrue(flag);
		

		 
		 
	}
}

