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

}
