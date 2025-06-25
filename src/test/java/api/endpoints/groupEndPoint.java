package api.endpoints;

import api.payload.Group;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GroupEndPoint {

	public static Response postGroupCreate(Group groupPayload) {
		System.out.println("Payload JSON => " + new com.google.gson.Gson().toJson(groupPayload));
		System.out.println("-------------------");

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