package samplePKG;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class myFirstRestAssuredClass {


	final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

//	public static void main(String[] args) {
//		
//		getResponseBody();
//		getResponseStatus();
//		
//	}
	
	//This will fetch the response body as is and log it. given and when are optional here
	@Test
	public static void getResponseBody(){
//		given().when().get(url).then().log()
//		.all();

//		given().queryParam("CUSTOMER_ID","68195")
//		.queryParam("PASSWORD","1234!")
//		.queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
	
		Long resTime=  given().queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getTime();
		System.out.println(resTime);
		Assert.assertTrue(resTime>1,"Response time: "+resTime);
		
	}

	@Test
	public void getResponseStatus(){
		int statusCode= given().queryParam("CUSTOMER_ID","68195")
				.queryParam("PASSWORD","1234!")
				.queryParam("Account_No","1")
				.when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
		System.out.println("The response status is "+statusCode);

		//given().when().get(url).then().assertThat().statusCode(200);
		Assert.assertEquals(statusCode, 200);
	}
}
