package api.testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.SpacesEndPoint;
import api.payload.Space;
import io.restassured.response.Response;

public class SpaceTest {

    Faker faker;
    Space spacePayload;
    public static int spaceId;
    public static int spaceOneId;

    @BeforeClass
    public void setupData() throws IOException {
        faker = new Faker();
        spacePayload = new Space();

        spacePayload.setSpaceName(faker.team().name());
        spacePayload.setLocationName("Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India");
//        spacePayload.setGpsLatitude("26.8520598");
//        spacePayload.setGpsLongitude("75.7947802");
        spacePayload.setSpaceOrder("0");
        spacePayload.setCreatedFlag("true");
        spacePayload.setSelected("false");
        spacePayload.setType("OTHER");
        spacePayload.setImageFrom("CAMERA");

        // Set file image
//        String imagePath = "C:\\Users\\SanjayMeena\\Pictures\\Bird.jpg";
//        File imageFile = new File(imagePath);
        spacePayload.setImageData(new File("C:\\Users\\SanjayMeena\\Pictures\\Bird.jpg"));
    }
    
    @Test (priority = 1)
    public void testSpaceCreate() {
		System.out.println("=================NEXT METHOD====================");

    	Response response = SpacesEndPoint.createSpace(spacePayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		

		// ✅ Extract spaceId from response
		spaceId = response.jsonPath().getInt("spaceId");
		System.out.println("Created spaceId => " + spaceId);

//		// ✅ Optionally store it for use in next test
//		spacePayload.setSpaceId(spaceId);
//		System.out.println("=================NEXT METHOD====================");
    }
    
    @Test (priority = 2)
    public void testGetSpaceList() {

    	Response response = SpacesEndPoint.getSpaceList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		// ✅ Extract list of all spaces
		List<Map<String, Object>> spaces = response.jsonPath().getList("");

		spaceOneId = -1;

		for (Map<String, Object> space : spaces) {
			String name = (String) space.get("spaceName");
			if ("SpaceOne".equalsIgnoreCase(name)) {
				spaceOneId = (int) space.get("spaceId");
				break;
			}
		}

		// ✅ Validate and print
		Assert.assertTrue(spaceOneId != -1, "SpaceOne not found in response!");
		System.out.println("SpaceOne ID => " + spaceOneId);
		System.out.println("=================NEXT METHOD====================");
    }
    
    @Test (priority = 3) 
	public void testDeleteCreatedSpace() {
		Response response = SpacesEndPoint.deleteCreatedSpace(spaceId, spaceOneId);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
}
