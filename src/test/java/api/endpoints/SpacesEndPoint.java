package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

import api.payload.Space;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SpacesEndPoint {

	public static Response createSpace(Space spacePayload) throws IOException {

		// 1) Post method by HashMap
//		Map<String,Object> m = new HashMap<>();
//		m.put("spaceName", spacePayload.getSpaceName());
//		m.put("locationName", spacePayload.getLocationName());
//		//		m.put("gpsLatitude",  spacePayload.getGpsLatitude());
//		//		m.put("gpsLongitude", spacePayload.getGpsLongitude());
//		m.put("spaceOrder",   spacePayload.getSpaceOrder());
//		m.put("createdFlag",  spacePayload.getCreatedFlag());
//		m.put("selected",     spacePayload.getSelected());
//		m.put("type",         spacePayload.getType());
//		m.put("imageData",    spacePayload.getImageData());
//
//		System.out.println("-----------"+m+"-------------");  // {spaceName=Maryland conspirators, createdFlag=true, locationName=Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India, imageFrom=CAMERA, spaceOrder=0, type=OTHER, selected=false}
//
//		return given()
//				.baseUri(Routes.base_url)
//				.basePath("/v2/spaces/register")
//				.header("Authorization", Routes.token)
//				.multiPart("imageData", m.get("imageData"))                 // file
//				.multiPart("spaceRequest", m, "application/json")
//				.when()
//				.post();


		// 2) Post method by JSON library
//		JSONObject m = new JSONObject();
//		m.put("spaceName", spacePayload.getSpaceName());
//		m.put("locationName", spacePayload.getLocationName());
//		m.put("spaceOrder", spacePayload.getSpaceOrder());
//		m.put("createdFlag", spacePayload.getCreatedFlag());
//		m.put("selected", spacePayload.getSelected());
//		m.put("type", spacePayload.getType());
//		m.put("imageFrom", spacePayload.getImageFrom());
//		m.put("imageData", spacePayload.getImageData()); 
//		// m is a JSONObject that holds key-value pairs to be sent as JSON (excluding the image file).
//		// imageData is a File (or something similar) that needs to be sent as a separate multipart field, not inside the JSON body
//
//		Object imageFile = m.get("imageData"); // Store the file
//		m.remove("imageData");                 // Remove file from JSON data
//
//		String spaceRequestJson = new Gson().toJson(m.toMap());
//
//		return given()
//				.baseUri(Routes.base_url)
//				.basePath("/v2/spaces/register")
//				.header("Authorization", Routes.token)
//				.multiPart("imageData", imageFile) // file
//				.multiPart("spaceRequest", spaceRequestJson, "application/json")
//
//				.when()
//				.post();


		// 3) Post method by POJO class (Plain old java object
//		Faker faker= new Faker();
//		Space pojoClass = new Space();
//		pojoClass.setSpaceName(faker.team().name());
//		pojoClass.setLocationName("Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India");
//		pojoClass.setSpaceOrder("0");
//		pojoClass.setCreatedFlag("true");
//		pojoClass.setSelected("false");
//		pojoClass.setType("OTHER");
//		pojoClass.setImageFrom("CAMERA");
//
//		pojoClass.setImageData(new File("C:\\Users\\SanjayMeena\\Pictures\\Bird.jpg"));
//		pojoClass = spacePayload -- > Both are same trick.

//		return given()
//				.baseUri(Routes.base_url)
//				.basePath("/v2/spaces/register")
//				.header("Authorization", Routes.token)
//				.multiPart("imageData", spacePayload.getImageData() ) // file
//				.multiPart("spaceRequest", spacePayload, "application/json")
//
//				.when()
//				.post();
		
//		4) Post method by External JSON file
		File file = new File(".\\SpaceCreateJsonBody.json");

		try (FileReader reader = new FileReader(file)) {
		    JSONTokener jsonToken = new JSONTokener(reader);
		    JSONObject jsonObject = new JSONObject(jsonToken);

		    // Add image data separately (do not serialize file to JSON)
		    jsonObject.put("imageData", spacePayload.getImageData());

		    Object imageFile = jsonObject.get("imageData");
		    jsonObject.remove("imageData");

		    return given()
		        .baseUri(Routes.base_url)
		        .basePath("/v2/spaces/register")
		        .header("Authorization", Routes.token)
		        .multiPart("imageData", imageFile)
		        .multiPart("spaceRequest", jsonObject.toString(), "application/json")
		        .when()
		        .post();

		} catch (IOException e) {
		    e.printStackTrace();
		    return null; // Or handle gracefully
		}

		
		
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

	public static Response deleteCreatedSpace(int createdSpaceId, int spaceOneId) {
		return given()
				.baseUri(Routes.base_url)
				.basePath("/v1/spaces/"+ createdSpaceId +"?confirm=true&newSpaceId="+spaceOneId+"")
				.header("Authorization", Routes.token)
				.when()
				.delete();
	}

}
