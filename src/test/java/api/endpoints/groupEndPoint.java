package api.endpoints;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import api.payload.Group;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GroupEndPoint {

	public static Response createGroup(Group groupPayload) {
		System.out.println("Payload JSON => " + new com.google.gson.Gson().toJson(groupPayload));
		System.out.println("-------------------");

		//		JSONObject jo = new JSONObject();
		//		jo.put("groupName", groupPayload.getGroupName());
		//		jo.put("groupType", groupPayload.getGroupType());
		//		jo.put("rules", groupPayload.getRules());
		//		
		//		System.out.println("Payload JSON => " + new com.google.gson.Gson().toJson(jo));
		//
		//		return given()
		//				.baseUri(Routes.base_url)
		//				.basePath("/groups/v1")
		//				.header("Authorization", Routes.token)
		//				.contentType(ContentType.JSON)
		//				.body(jo.toString())
		//				.when()
		//				.post();


		return given()
				.baseUri(Routes.base_url)
				.basePath("/groups/v1")
				.header("Authorization", Routes.token)
				.contentType(ContentType.JSON)
				.body(groupPayload)
				.when()
				.post();
		//			.then()
		//			.statusCode(200); // Replace 'Response' with 'ValidatableResponse' return type or we can convert in Constructor.
	}

	public static Response getGroupList() {
		return given()
				.baseUri(Routes.base_url)
				.basePath("/groups/allGroups")
				.header("Authorization", Routes.token)
				.when()
				.get();
	}

	public static Response deleteCreatedGroup(int groupId) {

		return given()
				.baseUri(Routes.base_url)
				.basePath("/v1/groups/"+groupId)
				.header("Authorization", Routes.token)
				.when()
				.delete();
	}


}