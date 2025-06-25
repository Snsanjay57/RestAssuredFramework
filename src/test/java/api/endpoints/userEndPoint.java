package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndPoint {
		
	public static Response getUserDetail() {
		return given()
			.contentType(ContentType.JSON)
			.header("Authorization", Routes.token)
			.when()
			.get(Routes.get_User);
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
