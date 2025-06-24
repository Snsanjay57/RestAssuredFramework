package api.endpoints;

public class Routes {
	
	public static String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc1NraXBwZWRVc2VyIjp0cnVlLCJzdWIiOiI5NDA1OTYzNTQiLCJpYXQiOjE3NTA3NjUwNDEsImV4cCI6MTc4MjMwMTA0MX0.qfrdu3gZBFl1y9A-2UmGmUZR7JCLFi1b0hCwlCTscbs";
	
	public static String base_url = "https://qa.bewizor.com/api";

	// User module URLs
	public static String get_User = base_url + "/user";
	public static String put_User = base_url + "/user";

	// User Setting module URLs
	public static String get_UserSetting = base_url + "/userSetting";

	// Tips module URLs
	public static String get_Tips = base_url + "/tip?status=ACTIVE";

	// Group module URLs
	public static String post_GroupCreate = base_url + "/groups/v1";
	public static String get_GroupList = base_url + "/groups/allGroups";
}
