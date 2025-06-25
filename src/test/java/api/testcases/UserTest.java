package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setFirstName("Ravi");
		userPayload.setMiddleName("Kumar");
		userPayload.setLastName("Jaiawaran");
		userPayload.setEmailId("ravijaiswaranitdgp2016@gmail.com");
		userPayload.setGender("MALE");
		// userPayload.setDateOfBirth(faker.date().birthday()); // optional
		userPayload.setRole("ADMIN");
	}

	@Test(priority = 1)
	public void testGetUser() {
		Response response = UserEndPoint.getUserDetail();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("=================NEXT METHOD====================");
	}

	@Test(priority = 2)
	public void testUpdateUser() {
		userPayload.setLastName(faker.name().lastName());
		Response response = UserEndPoint.updateUserDetail(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("=================NEXT METHOD====================");

	}
}
