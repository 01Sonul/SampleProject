package shoppersStack;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class Shopper {
	public static void main(String[] args) {
		RestAssured.baseURI="https://www.shoppersstack.com/shopping";
		
			//login & capture the shopperId
				Object shopperId = given().log().all().contentType("application/json")
				.body("{\r\n"
						+ "  \"email\": \"api.rp21@gmail.com\",\r\n"
						+ "  \"password\": \"Reset@123\",\r\n"
						+ "  \"role\": \"SHOPPER\"\r\n"
						+ "}")
				.when().post("/users/login").jsonPath().get("data.userId");
				System.out.println("shopperId is "+shopperId);
				
				
				Object token = given().contentType("application/json")
				.body("{\r\n"
						+ "  \"email\": \"api.rp21@gmail.com\",\r\n"
						+ "  \"password\": \"Reset@123\",\r\n"
						+ "  \"role\": \"SHOPPER\"\r\n"
						+ "}")
				.when().post("/users/login").jsonPath().get("data.jwtToken");
				System.out.println("token is "+token);
				
		
		//veiw product
				Object productId=when().get("/products/alpha").jsonPath().get("data[0].productId");
				System.out.println("productId is "+productId);
			
			
		//add product to wishlist
				given().log().all().header("content-type", "application/json").header("Authorization", "Bearer "+token)
				.body("{\r\n"
						+ "  \"productId\":" +productId+",\r\n"
						+ "  \"quantity\": 0\r\n"
						+ "}")
				.when().post("/shoppers/"+shopperId+"/wishlist")
				.then().assertThat().statusCode(201).log().all();
	}

}
