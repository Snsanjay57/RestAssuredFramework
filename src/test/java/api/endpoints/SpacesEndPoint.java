package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import api.payload.Space;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SpacesEndPoint {
	//	Object file;
	public static Response createSpace(Space spacePayload) {

		//		// 1) Post method by HashMap
		//		Map<String,Object> m = new HashMap<>();
		//		m.put("spaceName", spacePayload.getSpaceName());
		//		m.put("locationName", spacePayload.getLocationName());
		////		m.put("gpsLatitude",  spacePayload.getGpsLatitude());
		////		m.put("gpsLongitude", spacePayload.getGpsLongitude());
		//		m.put("spaceOrder",   spacePayload.getSpaceOrder());
		//		m.put("createdFlag",  spacePayload.getCreatedFlag());
		//		m.put("selected",     spacePayload.getSelected());
		//		m.put("type",         spacePayload.getType());
		//		m.put("imageData",    spacePayload.getImageData());
		//// 		String spaceRequestJson = new Gson().toJson(m); 
		////		System.out.println("-----------"+spaceRequestJson+"-------------");	  {"spaceName":"Maryland conspirators","createdFlag":"true","locationName":"Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India","imageFrom":"CAMERA","spaceOrder":"0","type":"OTHER","selected":"false"}-------------
		////
		////		System.out.println("-----------"+m+"-------------");   {spaceName=Maryland conspirators, createdFlag=true, locationName=Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India, imageFrom=CAMERA, spaceOrder=0, type=OTHER, selected=false}
		//
		//
		//		return given()
		//				.baseUri(Routes.base_url)
		//				.basePath("/v2/spaces/register")
		//				.header("Authorization", Routes.token)
		//				.multiPart("imageData", m.get("imageData"))                 // file
		////				.multiPart("spaceRequest", spaceRequestJson, "application/json")     // json
		//				.multiPart("spaceRequest", m, "application/json")
		//			   .when()
		//				.post();


		// 2) Post method by JSON library
		JSONObject m = new JSONObject();
		m.put("spaceName", spacePayload.getSpaceName());
		m.put("locationName", spacePayload.getLocationName());
		m.put("spaceOrder", spacePayload.getSpaceOrder());
		m.put("createdFlag", spacePayload.getCreatedFlag());
		m.put("selected", spacePayload.getSelected());
		m.put("type", spacePayload.getType());
		m.put("imageFrom", spacePayload.getImageFrom());
		m.put("imageData", spacePayload.getImageData()); 
		// m is a JSONObject that holds key-value pairs to be sent as JSON (excluding the image file).
		// imageData is a File (or something similar) that needs to be sent as a separate multipart field, not inside the JSON body
		
		Object imageFile = m.get("imageData"); // Store the file
		m.remove("imageData");                 // Remove file from JSON data

		String spaceRequestJson = new Gson().toJson(m.toMap());

		return given()
				.baseUri(Routes.base_url)
				.basePath("/v2/spaces/register")
				.header("Authorization", Routes.token)
				.multiPart("imageData", imageFile) // file
				.multiPart("spaceRequest", spaceRequestJson, "application/json")

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

	public static Response deleteCreatedSpace(int spaceId) {
		return given()
				.baseUri(Routes.base_url)
				.basePath("/v1/spaces/"+spaceId+"?confirm=true&newSpaceId=940596395")
				.header("Authorization", Routes.token)
				.when()
				.delete();
	}


}
