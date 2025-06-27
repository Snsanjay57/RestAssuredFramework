package api.endpoints;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import api.payload.Space;
import api.testcases.SpaceTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SpacesEndPoint {

	public static Response createSpace(Space spacePayload) {
		
		// 1) either mark imageData transient...
//		Map<String,Object> m = new HashMap<>();
//		m.put("spaceName",    spacePayload.getSpaceName());
//		m.put("locationName", spacePayload.getLocationName());
////		m.put("gpsLatitude",  spacePayload.getGpsLatitude());
////		m.put("gpsLongitude", spacePayload.getGpsLongitude());
//		m.put("spaceOrder",   spacePayload.getSpaceOrder());
//		m.put("createdFlag",  spacePayload.getCreatedFlag());
//		m.put("selected",     spacePayload.getSelected());
//		m.put("type",         spacePayload.getType());
//		m.put("imageFrom",    spacePayload.getImageFrom());
//		String spaceRequestJson = new Gson().toJson(m);

		return given()
				.baseUri(Routes.base_url)
				.basePath("/v2/spaces/register")
				.header("Authorization", Routes.token)
				.multiPart("imageData", spacePayload.getImageData())                 // file
//				.multiPart("spaceRequest", spaceRequestJson, "application/json")     // json
				.multiPart("spaceRequest", spacePayload, "application/json")
				.when()
				.post();
	}


	public static Response getSpaceList() {
		//		String baseUrl = Routes.base_url;
		//	    String path = "/v1/spaces";
		//
		//	    // Print the full URL
		//	    String fullUrl = baseUrl + path;
		//	    System.out.println("Calling GET: " + fullUrl);
		//	    System.out.println("CompleteURL: "+Routes.get_AllSpaces);

		return given()
				.baseUri(Routes.base_url)
				.basePath("/v1/spaces")
				.contentType(ContentType.JSON)
				.header("Authorization", Routes.token)
				.when()
				.get();

	}
	
		public static Response deleteCreatedSpace(int createdSpaceId, int spaceOneId) {
			return given()
					.baseUri(Routes.base_url)
					.basePath("/v1/spaces/"+ createdSpaceId +"?confirm=true&newSpaceId="+spaceOneId+"")
					.header("Authorization", Routes.token)
					.when()
					.delete();
		}


}
