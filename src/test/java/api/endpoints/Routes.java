package api.endpoints;

public class Routes {
	
	public static String base_url = "'https://qa.bewizor.com/api ";

	// User module url's
	public static String get_User = base_url + "/user";
	public static String put_User = base_url + "/user";
	
	// User setting module url's
	public static String get_UserSetting = base_url + "/userSetting";
	
	// Tips module url's
	public static String get_Tips = base_url + "/tip?status=ACTIVE";
	
	// Group module url's
	public static String post_GroupCreate = base_url + "/groups/v1";
	public static String get_GroupList = base_url + "/groups/allGroups";


}
