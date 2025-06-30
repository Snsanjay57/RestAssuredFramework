package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.GroupEndPoint;
import api.payload.Group;
import io.restassured.response.Response;

public class GroupTest {

	Faker faker;
	Group groupPayload;
	private int groupId;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		groupPayload = new Group();

		groupPayload.setGroupName(faker.team().name());
		groupPayload.setGroupType("ADMIN");
		groupPayload.setRules(faker.team().name());

	}

	@Test(priority = 3)
	public void testCreateGroup() {
		Response response = GroupEndPoint.createGroup(groupPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		
		
		groupId = response.jsonPath().getInt("groupId");
		System.out.println("Created spaceId => " + groupId);
		System.out.println("=================NEXT METHOD====================");

	}

	@Test(priority = 4)
	public void testGetGroupList() {
		Response response = GroupEndPoint.getGroupList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("=================NEXT METHOD====================");

	}

	@Test(priority = 4)
	public void testdeleteCreatedGroup() {
		Response response = GroupEndPoint.deleteCreatedGroup(groupId);
				response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);


		System.out.println("=================NEXT METHOD====================");
	}
}
