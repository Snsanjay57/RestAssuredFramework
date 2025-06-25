package api.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.GroupEndPoint;
import api.payload.Group;
import io.restassured.response.Response;
import org.testng.Assert;

public class GroupTest {

	Faker faker;
	Group groupPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		groupPayload = new Group();

		groupPayload.setGroupName(faker.team().name());
		groupPayload.setGroupType("ADMIN");

	}

//	@Test(priority = 3)
//	public void testCreateGroup() {
//		Response response = GroupEndPoint.postGroupCreate(groupPayload);
//		response.then().log().all();
//		Assert.assertEquals(response.statusCode(), 201);
//		System.out.println("=================NEXT METHOD====================");
//
//	}

	@Test(priority = 4)
	public void testGetGroupList() {
		Response response = GroupEndPoint.getGroupList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("=================NEXT METHOD====================");

	}
}
