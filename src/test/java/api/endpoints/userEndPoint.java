package api.endpoints;


import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class userEndPoint {
	
	public static String token;
	
	public static Response getUserDetial() {
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + token)
		
		.when()
		.get(Routes.get_User);
		
		return response;
	
	}
	
	public static Response updateUserDetial(user payload) {
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + token)

		.body(payload)
		
		.when()
		.get(Routes.put_User);
		
		return response;
	
	}
	
//	public static Response getUserDetails(String token) {		
//		return RestAssured
//                .given()
//                    .baseUri(Routes.base_url)
//                    .basePath("/user")
//                    .header("Authorization", "Bearer " + token)
//                    .header("Accept", "*/*")
//                .when()
//                    .get()
//                .then()
//                    .log().all()  // optional: logs the full response
//                    .extract().response();
//	
//	}
//	
//	public static Response updateUser(String token, user requestBody) {		
//		return RestAssured
//                .given()
//                    .baseUri("https://qa.bewizor.com")
//                    .basePath("/api/user")
//                    .header("Authorization", "Bearer " + token)
//                    .header("Accept", "*/*")
//                    .contentType(ContentType.JSON)
//                    .body(requestBody)
//                .when()
//                    .put()
//                .then()
//                    .log().all()
//                    .extract().response();
//	
//	}

}
