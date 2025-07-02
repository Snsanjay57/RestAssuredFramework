package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class UserEndPoint {

	public static Response getUserDetail() {
		return given()
				.contentType(ContentType.JSON)  // Optional, but good practice to specify content type
				.header("Authorization", Routes.token)
				.when()
				.get(Routes.get_User);
//		      .then()
//		      .statusCode(200)
//		      .body("firstName", equalTo("Ravi")); // Adjust this if the JSON structure is different
	}

	public static Response updateUserDetail(User userPayload) {
		return given()
				.contentType(ContentType.JSON)
				.header("Authorization", Routes.token)
				.body(userPayload)
				.when()
				.put(Routes.put_User);
	}

}
