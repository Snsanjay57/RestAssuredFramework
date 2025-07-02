package api.testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import api.endpoints.Routes;


public class TipsTest {
	
	@Test(priority = 1)
	void testGetTips() {
		
		
//		public static String get_Tips = base_url + "/tip?status=ACTIVE";

		given()
		      .pathParam("myPath", "tip")
		      .queryParam("status", "ACTIVE")
		      .header("Authorization", Routes.token) // Adding the authorization header
		      .when()
		      .get(Routes.base_url + "/{myPath}") // queryParam("status", "ACTIVE") is automatically appended to the URL
			  .then()
              .statusCode(200)
              .log().all();
		
	}

}
