package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import helperfunctions.HelperFunctions;
import pojo.responses.getcourse.Course;
import pojo.responses.getcourse.GetCoursesInfo;
import testmethods.OauthExampleTestMethods;
public class OauthExampleTests {
	@Test
	public void OauthTokenTest() {
		String oauthToken = OauthExampleTestMethods.getAccessToken();
		GetCoursesInfo coursesInfo = OauthExampleTestMethods.getCoursesInfo(oauthToken).as(GetCoursesInfo.class);		
		List<Course> apiCourses = coursesInfo.getCourses().getApi();
		String coursePrice = OauthExampleTestMethods.getCoursePrice("SoapUI Webservices testing", apiCourses);
		
		Assert.assertEquals("40", coursePrice, 
				String.format("'Soap Webservices testing' API Automation Course price is '%s' as Not Expected", coursePrice));
		HelperFunctions.logToReportAndLog4j(
				String.format("'Soap Webservices testing' API Automation Course price is '40' as Expected"));
	}
}
