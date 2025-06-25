package api.testcases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

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

    @BeforeClass
    public void setupData() throws IOException {
        faker = new Faker();
        spacePayload = new Space();

        // Common data
        spacePayload.setSpaceName(faker.team().name());
        spacePayload.setLocationName("Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India");
        spacePayload.setCreatedFlag("true");
        spacePayload.setType("OTHER"); // Setting space type

        // Set image (mandatory for OTHER)
        String imagePath = "C:\\Users\\SanjayMeena\\Pictures\\Bird.jpg";
        File imageFile = new File(imagePath);
        byte[] fileContent = Files.readAllBytes(imageFile.toPath());
        String base64Image = Base64.getEncoder().encodeToString(fileContent);

        spacePayload.setImageFrom("CAMERA");
        spacePayload.setImageData(base64Image);
        
    }
    
    @Test (priority = 1)
    public void testSpaceCreate() {
		System.out.println("=================NEXT METHOD====================");

    	Response response = SpacesEndPoint.postSpaceCreate(spacePayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
//		System.out.println("=================NEXT METHOD====================");
    }
    
    @Test (priority = 2)
    public void testAllSpacceList() {
		System.out.println("=================NEXT METHOD====================");

    	Response response = SpacesEndPoint.getAllSpaceList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
//		System.out.println("=================NEXT METHOD====================");
    }
}
