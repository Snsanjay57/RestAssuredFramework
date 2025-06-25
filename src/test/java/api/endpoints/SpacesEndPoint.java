package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Space;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SpacesEndPoint {

	public static Response postSpaceCreate(Space spacePayload) {

		System.out.println("Payload JSON: "+ new com.google.gson.Gson().toJson(spacePayload));
		System.out.println("------------------");
		
		return given()
				.baseUri(Routes.base_url)
				.basePath("/v2/spaces/register")
				.header("Authorization", Routes.token)
				.contentType(ContentType.JSON)
				.body(spacePayload)
				.when()
				.post();
		
	}
	
	public static Response getAllSpaceList() {
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


}
