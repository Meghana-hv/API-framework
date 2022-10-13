package parameter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

import static io.restassured.RestAssured.*;

public class GithubQuery {
@Test
public void queryParameter() {
	baseURI="http://api.github.com";
	
//	Cookie my= new Cookie.Builder(baseURI).setHttpOnly(false).build();
//	
	
	 ResponseSpecification res1 = given().redirects().follow(true)
	.expect()
	.statusCode(301);
	 
	 
	
	
	
	 // .get("/repositories").getStatusCode();
	 
	 
//
//	 String s = res.toString();
	System.out.println(res1);
//	

	 
	 
	 
	 //String r = res.headers().asList().toString();
	 

	// res.then().log().all();
		
}
}
