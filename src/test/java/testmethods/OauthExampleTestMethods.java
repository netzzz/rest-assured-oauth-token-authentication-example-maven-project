package testmethods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OauthExampleTestMethods {
	private static String baseURIToken = "https://rahulshettyacademy.com";
	
	public static String getAccessToken(){
		RestAssured.baseURI = baseURIToken;
		Response getTokenResponse = given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().extract().response();
		
		JsonPath getTokenResponseJson = getTokenResponse.jsonPath();
		
		return getTokenResponseJson.getString("access_token");
	}
	
	public static Response getCourseDetails(String accessToken) {
		RestAssured.baseURI = baseURIToken;
		
		return given().queryParam("access_token", accessToken)
				.when().get("oauthapi/getCourseDetails")
				.then().extract().response();
	}
	
	
}
