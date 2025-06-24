package api.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.groupEndPoint;
import api.payload.group;
import io.restassured.response.Response;
import org.testng.Assert;

public class GroupTest {

	Faker faker;
	group groupPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		groupPayload = new group();

		groupPayload.setGroupName(faker.team().name());
		groupPayload.setGroupType("ADMIN");
//		groupPayload.setRules(faker.lorem().paragraph());
//		groupPayload.setDescription(faker.lorem().sentence());
//		groupPayload.setAssetIDs(faker.number().numberBetween(1000, 9999));
//		groupPayload.setImageData(null); // if no image
	}

	@Test(priority = 3)
	public void testCreateGroup() {
		Response response = groupEndPoint.postGroupCreate(groupPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		System.out.println("=================NEXT METHOD====================");

	}

	@Test(priority = 4)
	public void testGetGroupList() {
		Response response = groupEndPoint.getGroupList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("=================NEXT METHOD====================");

	}
}
