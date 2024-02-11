package reqres;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetUser {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		
		//get single user using get 
		given().log().all()
		.when().get("/api/users/2")
		.then().log().all().assertThat().statusCode(200);
		

	}

}

