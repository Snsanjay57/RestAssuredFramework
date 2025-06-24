package api.endpoints;

import api.payload.group;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class groupEndPoint {

	public static Response postGroupCreate(group groupPayload) {
		return given()
			.baseUri(Routes.base_url)
			.basePath("/groups/v1")
			.header("Authorization", Routes.token)
			.contentType(ContentType.JSON)
			.body(groupPayload)
			.when()
			.post();
	}

	public static Response getGroupList() {
		return given()
			.baseUri(Routes.base_url)
			.basePath("/groups/allGroups")
			.header("Authorization", Routes.token)
			.when()
			.get();
	}
}