package api.endpoints;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class userEndPoint {
		
	public static Response getUserDetail() {
		return given()
			.contentType(ContentType.JSON)
			.header("Authorization", Routes.token)
			.when()
			.get(Routes.get_User);
	}

	public static Response updateUserDetail(user userPayload) {
		return given()
			.contentType(ContentType.JSON)
			.header("Authorization", Routes.token)
			.body(userPayload)
			.when()
			.put(Routes.put_User);
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
