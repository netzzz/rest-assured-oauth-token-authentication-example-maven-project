package testmethods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.responses.getcourse.Course;

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
	
	public static Response getCoursesInfo(String accessToken) {
		RestAssured.baseURI = baseURIToken;
		
		return given().queryParam("access_token", accessToken)
				.when().get("oauthapi/getCourseDetails")
				.then().extract().response();
	}
	
	public static String getCoursePrice(String courseTitle, List<Course> coursesList) {
		for(Course course : coursesList) {
			if(course.getCourseTitle().equals(courseTitle)) {
				return course.getPrice();
			}
		}
		return String.format("Course %s doesn't exist in provided collection", courseTitle);
	}
	
	
}
