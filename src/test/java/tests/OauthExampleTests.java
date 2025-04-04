package tests;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testmethods.OauthExampleTestMethods;
import helperfunctions.HelperFunctions;
public class OauthExampleTests {
	@Test
	public void OauthTokenTest() {
		String oauthToken = OauthExampleTestMethods.getAccessToken();

		Response getCourseDetails = OauthExampleTestMethods.getCourseDetails(oauthToken);
		JsonPath getCourseDetailsJson = HelperFunctions.convertRestAssuredResponseToJson(getCourseDetails);
		
		ArrayList<String> webAutomationCourses = getCourseDetailsJson.getJsonObject("courses.webAutomation");
		Assert.assertTrue(!webAutomationCourses.isEmpty(), "No Web Automation Courses as Not Expected");
		HelperFunctions.logToReportAndLog4j(String.format("There are %d Web Automation Courses", webAutomationCourses.size()));
	}
}
