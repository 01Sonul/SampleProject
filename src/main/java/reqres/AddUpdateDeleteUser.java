package reqres;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class AddUpdateDeleteUser {
	 public static void main(String[] args) {
		 RestAssured.baseURI="https://reqres.in";
		 
		 //add user using post
			
//			HashMap<Object, String> body= new HashMap();
//			body.put("name", "sonul");
//			body.put("job", "testlead");
			
		 //capturing id
			Object id= given().log().all().contentType("application/json")
					.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
			.when().post("/api/users/").jsonPath().get("id");
			System.out.println("Captured id "+id);
			
			
			//update user using put
			given().log().all().contentType("application/json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}")
			.when().put("/api/users/"+id)
			.then().assertThat().statusCode(200).log().all();
			
			
			//delete user using delete
			given()
			.when().delete("/api/users/"+id)
			.then().assertThat().statusCode(204).log().all();
			
	}

}
